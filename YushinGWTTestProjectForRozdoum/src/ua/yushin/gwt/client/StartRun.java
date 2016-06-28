/*
    This is the test project for Rozdoum
 */
package ua.yushin.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;

import java.util.ArrayList;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 *
 * @author      Yushin Roman
 * @version     28.06.2016
 */
public class StartRun implements EntryPoint {

    /**
     * store all clients in arrayList
     */
    private ArrayList<Client> clients = new ArrayList<Client>();

    /**
     * A panel that lays all of its widgets out in a single vertical column.
     */
    private VerticalPanel mainPanel;

    /**
     * A flexible table that creates cells on demand.
     */
    private FlexTable clientsFlexTable;

    /**
     * A panel that lays all of its widgets out in a single horizontal column.
     */
    private HorizontalPanel addPanel;

    /**
     * A standard single-line text box.
     * TextBox for name of new client
     */
    private TextBox newSymbolTextBox;

    /**
     *  A standard push-button widget.
     *  By this Button shows all clients
     */
    private Button showAllClientButton;

    /**
     *  A standard push-button widget.
     *  By this button adds new client in flexTable
     */
    private Button addButton;

    /**
     * A widget that contains arbitrary text
     * Contains name of table
     */
    private Label labelMCD;

    /**
     * A widget that contains arbitrary text.
     * Contains name of project
     */
    private Label lblProjectName;

    /**
     * service for asynchronous service
     */
    private RemServiceAsync remServiceAsync = GWT.create(RemService.class);

    /**
     * main method, it loads all widgets on the page
     */
    public void onModuleLoad() {
        RootPanel rootPanel = RootPanel.get();
        mainPanel = new VerticalPanel();
        rootPanel.add(mainPanel, 500, 100);
        mainPanel.setSize("500px", "300px");

        lblProjectName = new Label("Yushin GWT Test Projet for Rozdoum");
        labelMCD = new Label("Manage customer database");
        labelMCD.setStyleName("gwt-Label-StartRun");

        mainPanel.add(lblProjectName);
        mainPanel.add(labelMCD);

        //Add these lines
        clientsFlexTable = new FlexTable();
        clientsFlexTable.setText(0, 0, "Name");
        clientsFlexTable.setText(0, 1, "Remove");

        //clientsFlexTable.setText(0, 0, "Name");
        //clientsFlexTable.setText(0, 1, "Surname");
        //clientsFlexTable.setText(0, 2, "email");
        //clientsFlexTable.setText(0, 3, "age");
        //clientsFlexTable.setText(0, 4, "sex");
        //clientsFlexTable.setText(0, 5, "Remove");

        // Add styles to elements in the stock list table.
        clientsFlexTable.setCellPadding(6);
        clientsFlexTable.getRowFormatter().addStyleName(0, "watchListHeader");
        clientsFlexTable.addStyleName("watchList");

        clientsFlexTable.getCellFormatter().addStyleName(0, 1, "watchListNumericColumn");
        clientsFlexTable.getCellFormatter().addStyleName(0, 2, "watchListRemoveColumn");

        mainPanel.add(clientsFlexTable);

        addPanel = new HorizontalPanel();
        addPanel.addStyleName("addPanel");
        mainPanel.add(addPanel);

        newSymbolTextBox = new TextBox();
        newSymbolTextBox.addKeyPressHandler(new KeyPressHandler() {
            public void onKeyPress(KeyPressEvent event) {
                if (event.getCharCode() == KeyCodes.KEY_ENTER){
                    //add new Client
                    addNewClient();
                }
            }
        });
        newSymbolTextBox.setFocus(true);
        addPanel.add(newSymbolTextBox);

        // addButton
        addButton = new Button("New button");
        addButton.setStyleName("gwt-Button-Add");
        addButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                //add new Client
                addNewClient();
            }
        });
        addButton.setText("Add new client");
        addPanel.add(addButton);

        //showAllClientsButton
        showAllClientButton = new Button("showAllClientButton");
        showAllClientButton.setStyleName("gwt-Button-Add");
        showAllClientButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                //RemService.App.getInstance().getAllClients(new AsyncCallback<ArrayList>() {
                remServiceAsync.getAllClients(new AsyncCallback<ArrayList<Client>>() {

                    @Override
                    public void onFailure(Throwable caught) {
                        Window.alert("Some error");
                    }

                    @Override
                    public void onSuccess(ArrayList<Client> clients) {
                        Window.alert("Show all clients");
                        for (int i = 0; i < clients.size(); i++) {
                            Window.alert("" + clients.get(i).getName());
                        }
                    }
                });
            }
        });

        showAllClientButton.setText("Show all clients from database");
        addPanel.add(showAllClientButton);
    } // end onModuleLoad method

    /**
     * add new client in flex table and return cursor in textBox
     */
    public void addNewClient () {

        // assign variable newClientName text fromnewSymbolTextBox
        final String newClientName = newSymbolTextBox.getText().trim();
        final Client newClient = new Client (newClientName);

        // set cursor on newSymbolTextBox
        newSymbolTextBox.setFocus(true);

        // validation of the name, clean  newSymbolTextBox if fail
        if (!newClientName.matches("^[A-Za-z]{1,20}$")) {
            Window.alert("'" + newClientName  + "' is not a valid symbol.");
            newSymbolTextBox.selectAll();
            return;
        }
        newSymbolTextBox.setText("");

        // don't add the stock if it's already in the list
        if (clients.contains(newClient))
            return;

        // ********************************************************
        // add client in collection
        clients.add(newClient);
        int row = clientsFlexTable.getRowCount();

        clientsFlexTable.getCellFormatter().addStyleName(row, 1, "watchListNumericColumn");
        clientsFlexTable.getCellFormatter().addStyleName(row, 2, "watchListRemoveColumn");

        // add button to remove this client from the list
        Button removeClient = new Button("x");
        removeClient.addStyleDependentName("remove");
        removeClient.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                int removedIndex = clients.indexOf(newClient);
                clients.remove(removedIndex);
                clientsFlexTable.removeRow(removedIndex + 1);
            }
        });

        clientsFlexTable.setText(row, 0, newClientName);
        clientsFlexTable.setWidget(row, 1, removeClient);
    } // end addNewClient
} // end of class
