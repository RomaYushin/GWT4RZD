package ua.yushin.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.user.client.Window;
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
import com.google.gwt.user.client.Timer;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */

public class StartRun implements EntryPoint {

    private ArrayList<Client> clients = new ArrayList<Client>();

    private VerticalPanel mainPanel;
    private FlexTable stocksFlexTable;
    private HorizontalPanel addPanel;
    private TextBox newSymbolTextBox;
    private Button addButton;
    //private Label lastUpdatedLabel;
    private ArrayList <String> stocks = new ArrayList<String>();
    private static final int REFRESH_INTERVAL = 5000;
    //private Image image;
    private Label lblStockWatcher;
    private Label lblProjectName;

    public void onModuleLoad() {
        RootPanel rootPanel = RootPanel.get();
        {
            mainPanel = new VerticalPanel();
            rootPanel.add(mainPanel, 500, 100);
            mainPanel.setSize("500px", "300px");

            {
                lblStockWatcher = new Label("Manage customer database");

                lblStockWatcher.setStyleName("gwt-Label-StartRun");

                lblProjectName = new Label("Yushin GWT Test Projet for Rozdoum");
                //lblStockWatcher.setStyleName("gwt-Label-ProjectName");

                mainPanel.add(lblProjectName);
                mainPanel.add(lblStockWatcher);
            }
            {
                stocksFlexTable = new FlexTable();
                //Add these lines
                stocksFlexTable.setText(0, 0, "Name");
                stocksFlexTable.setText(0, 1, "Remove");

                //stocksFlexTable.setText(0, 0, "Symbol");
                //stocksFlexTable.setText(0, 1, "Price");
                //stocksFlexTable.setText(0, 2, "Change");
                //stocksFlexTable.setText(0, 3, "Remove");

                // Add styles to elements in the stock list table.
                stocksFlexTable.setCellPadding(6);
                //stocksFlexTable.getRowFormatter().addStyleName(0, "watchListHeader");
                stocksFlexTable.addStyleName("watchList");

                stocksFlexTable.getCellFormatter().addStyleName(0, 1, "watchListNumericColumn");
                stocksFlexTable.getCellFormatter().addStyleName(0, 2, "watchListRemoveColumn");

                //stocksFlexTable.getCellFormatter().addStyleName(0, 1, "watchListNumericColumn");
                //stocksFlexTable.getCellFormatter().addStyleName(0, 2, "watchListNumericColumn");
                //stocksFlexTable.getCellFormatter().addStyleName(0, 3, "watchListRemoveColumn");

                mainPanel.add(stocksFlexTable);
            }
            {
                addPanel = new HorizontalPanel();
                addPanel.addStyleName("addPanel");
                mainPanel.add(addPanel);
                {
                    newSymbolTextBox = new TextBox();
                    newSymbolTextBox.addKeyPressHandler(new KeyPressHandler() {
                        public void onKeyPress(KeyPressEvent event) {
                            if (event.getCharCode() == KeyCodes.KEY_ENTER){
                                //addStock();
                            }
                        }
                    });
                    newSymbolTextBox.setFocus(true);
                    addPanel.add(newSymbolTextBox);
                }
                {
                    addButton = new Button("New button");
                    addButton.setStyleName("gwt-Button-Add");
                    addButton.addClickHandler(new ClickHandler() {
                        public void onClick(ClickEvent event) {

                            //addStock();
                            addNewClient();
                        }
                    });
                    addButton.setText("Add new client");
                    addPanel.add(addButton);
                }
            }
            {
                //lastUpdatedLabel = new Label("New label");
                //mainPanel.add(lastUpdatedLabel);
            }
        }

        // setup timer to refresh list automatically
        Timer refreshTimer = new Timer() {
            public void run()
            {
                refreshWatchList();
            }
        };
        refreshTimer.scheduleRepeating(REFRESH_INTERVAL);


    }
    private void refreshWatchList() {

        Client [] clientsArr = new Client[clients.size()];
        for (int i = 0; i < clients.size(); i++) {
            clientsArr[i] = new Client (clients.get(i).getName());
            updateClientsTable(clientsArr);
        }


    }

    public void updateClientsTable (Client [] clientsArr) {
        if (clientsArr == null) {
            return;
        }
        for (int i = 0; i < clientsArr.length; i++) {
            updateTable(clientsArr[i]);
        }
    }

    public void updateTable (Client client) {
        if (!clients.contains(client.getName())) {
            return;
        }

        int row = clients.indexOf(client.getName()) + 1;
    }


    public void addNewClient () {

        // присваиваем переменной newClientName текст из newSymbolTextBox
        final String newClientName = newSymbolTextBox.getText().trim();
        final Client newClient = new Client (newClientName);

        // устанавливаем курсор обратно на newSymbolTextBox
        newSymbolTextBox.setFocus(true);

        // валидация имени если не проходит, отчистить поле newSymbolTextBox
        if (!newClientName.matches("^[A-Za-z]{1,20}$")) {
            Window.alert("'" + newClientName  + "' is not a valid symbol.");
            newSymbolTextBox.selectAll();
            return;
        }
        newSymbolTextBox.setText("");

        // don't add the stock if it's already in the watch list
        if (clients.contains(newClient))
            return;

        // ********************************************************
        // add the stock to the list
        int row = stocksFlexTable.getRowCount();
        clients.add(newClient);
        stocksFlexTable.setText(row, 0, newClientName);
        //stocksFlexTable.setWidget(row, 2, new Label());
        stocksFlexTable.getCellFormatter().addStyleName(row, 1, "watchListNumericColumn");

        //stocksFlexTable.getCellFormatter().addStyleName(row, 2, "watchListNumericColumn");
        stocksFlexTable.getCellFormatter().addStyleName(row, 2, "watchListRemoveColumn");

        // add button to remove this stock from the list
        Button removeClient = new Button("x");
        removeClient.addStyleDependentName("remove");
        removeClient.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {

                int removedIndex = clients.indexOf(newClient);
                Window.alert(String.valueOf(removedIndex));

                clients.remove(removedIndex);
                stocksFlexTable.removeRow(removedIndex + 1);
            }
        });
        stocksFlexTable.setWidget(row, 1, removeClient);


    }
}
