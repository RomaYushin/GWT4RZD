/*
    This is the test project for Rozdoum
 */
package ua.yushin.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

import java.util.ArrayList;
import java.util.Date;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 *
 * @author      Yushin Roman
 * @version     04.07.2016
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
     * text box for name in popup panel
     */
    private static TextBox textBoxForName = new TextBox();

    /**
     * text box for surname in popup panel
     */
    private static TextBox textBoxForSurname = new TextBox();

    /**
     * text box for surname in popup panel
     */
    private static TextBox textBoxForEmail = new TextBox();

    /**
     * text box for data of birth in popup panel
     */
    private static TextBox textBoxForDataOfBirth = new TextBox();

    /**
     * text box for sex in popup panel
     */
    private static TextBox textBoxForSex = new TextBox();

    /**
     * for creating new Client, who doesn't have an email
     */
    private static final String NO_EMAIL = "no email";

    /**
     * for creating new Client, who doesn't have a date Of birth
     */
    private static final String NO_DATE_OF_BIRTH = "no dateOfBirth";

    /**
     * for creating new Client, who doesn't have a date Of birth
     */
    private static final String NO_SEX = "no sex";

    /**
     * for creating new Client, who doesn't have a date Of birth
     * age is 10_000
     */
    private static final int NO_AGE = 10_000;

    /**
     * main method, it loads all widgets on the page
     */
    public void onModuleLoad() {

        RootPanel rootPanel = RootPanel.get();
        mainPanel = new VerticalPanel();
        rootPanel.add(mainPanel, 100, 50);
        mainPanel.setSize("1000px", "500px");

        lblProjectName = new Label("Yushin GWT Test Projet for Rozdoum");
        lblProjectName.setStyleName("gwt-Label-ProjectName");
        labelMCD = new Label("Manage customer database");
        labelMCD.setStyleName("gwt-Label-TableName");

        mainPanel.add(lblProjectName);
        mainPanel.add(labelMCD);

        final DialogBox dialogBox = createDialogBox();
        dialogBox.setGlassEnabled(true);
        dialogBox.setAnimationEnabled(true);
        Button openPopup = new Button("Add new Client", new ClickHandler() {
            public void onClick(ClickEvent sender) {
                dialogBox.center();
                dialogBox.show();
            }
        });
        openPopup.setStyleName("gwt-Button-openPopup");
        mainPanel.add(openPopup);

        //Add these lines
        clientsFlexTable = new FlexTable();
        clientsFlexTable.setText(0, 0, "Name");
        clientsFlexTable.setText(0, 1, "Surname");
        clientsFlexTable.setText(0, 2, "email");
        clientsFlexTable.setText(0, 3, "age");
        clientsFlexTable.setText(0, 4, "sex");
        clientsFlexTable.setText(0, 5, "remove");

        Button sortByName = new Button("Sort by name", new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                //Window.alert("clients size" + clients.size());
                remServiceAsync.sortByName(clients, new AsyncCallback<ArrayList<Client>>() {
                    @Override
                    public void onFailure(Throwable caught) {
                        Window.alert("Error in sortByName");
                    }

                    @Override
                    public void onSuccess(ArrayList<Client> result) {
                        sortFlexTable(result);
                    }
                });
            }
        });

        Button sortBySurname = new Button("Sort by surname", new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                remServiceAsync.sortBySurname(clients, new AsyncCallback<ArrayList<Client>>() {
                    @Override
                    public void onFailure(Throwable caught) {
                        Window.alert("Error in sortBySurname");
                    }

                    @Override
                    public void onSuccess(ArrayList<Client> result) {
                        sortFlexTable(result);
                    }
                });
            }
        });
        Button sortByEmail = new Button("Sort by email", new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                remServiceAsync.sortByEmail(clients, new AsyncCallback<ArrayList<Client>>() {
                    @Override
                    public void onFailure(Throwable caught) {
                        Window.alert("Error in sortByEmail");
                    }

                    @Override
                    public void onSuccess(ArrayList<Client> result) {
                        sortFlexTable(result);
                    }
                });
            }
        });
        Button sortByAge = new Button("Sort by age", new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                remServiceAsync.sortByAge(clients, new AsyncCallback<ArrayList<Client>>() {
                    @Override
                    public void onFailure(Throwable caught) {
                        Window.alert("Error in sortByAge");
                    }

                    @Override
                    public void onSuccess(ArrayList<Client> result) {
                        sortFlexTable(result);
                    }
                });
            }
        });
        Button sortBySex = new Button("Sort by sex", new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                remServiceAsync.sortBySex(clients, new AsyncCallback<ArrayList<Client>>() {
                    @Override
                    public void onFailure(Throwable caught) {
                        Window.alert("Error in sortBySex");
                    }

                    @Override
                    public void onSuccess(ArrayList<Client> result) {
                        sortFlexTable(result);
                    }
                });
            }
        });


        clientsFlexTable.setWidget(1, 0, sortByName);
        clientsFlexTable.setWidget(1, 1, sortBySurname);
        clientsFlexTable.setWidget(1, 2, sortByEmail);
        clientsFlexTable.setWidget(1, 3, sortByAge);
        clientsFlexTable.setWidget(1, 4, sortBySex);

        // Add styles to elements in the stock list table.
        clientsFlexTable.setCellPadding(6);
        clientsFlexTable.getRowFormatter().addStyleName(0, "watchListHeader");
        clientsFlexTable.addStyleName("watchList");

        clientsFlexTable.getCellFormatter().addStyleName(0, 0, "watchListNumericColumn");
        clientsFlexTable.getCellFormatter().addStyleName(0, 1, "watchListNumericColumn");
        clientsFlexTable.getCellFormatter().addStyleName(0, 2, "watchListNumericColumn");
        clientsFlexTable.getCellFormatter().addStyleName(0, 3, "watchListNumericColumn");
        clientsFlexTable.getCellFormatter().addStyleName(0, 4, "watchListNumericColumn");
        clientsFlexTable.getCellFormatter().addStyleName(0, 5, "watchListRemoveColumn");

        clientsFlexTable.getCellFormatter().addStyleName(1, 0, "watchListNumericColumn");
        clientsFlexTable.getCellFormatter().addStyleName(1, 1, "watchListNumericColumn");
        clientsFlexTable.getCellFormatter().addStyleName(1, 2, "watchListNumericColumn");
        clientsFlexTable.getCellFormatter().addStyleName(1, 3, "watchListNumericColumn");
        clientsFlexTable.getCellFormatter().addStyleName(1, 4, "watchListNumericColumn");
        clientsFlexTable.getCellFormatter().addStyleName(1, 5, "watchListNumericColumn");

        mainPanel.add(clientsFlexTable);
        showClientsFromDatabase();
    } // end onModuleLoad method

    /**
     * when app starts all client from database must be shown on the page
     */
    public void showClientsFromDatabase() {
        remServiceAsync.getAllClients(new AsyncCallback<ArrayList<Client>>() {
            @Override
            public void onFailure(Throwable caught) {
                Window.alert("Some error in showClientsFromDatabase ");
            }

            @Override
            public void onSuccess(ArrayList<Client> clientsFromDB) {
                // set last id
                for (int i = 0; i < clientsFromDB.size(); i++) {
                    if (clientsFromDB.get(i).getId() > Client.getLastId()) {
                        Client.setLastId(clientsFromDB.get(i).getId());
                    }
                }

                for (int i = 0; i < clientsFromDB.size(); i++) {
                    addToFlexTable(clientsFromDB.get(i));
                    clients.add(clientsFromDB.get(i));
                }
            }
        });
    } // end of showClientsFromDatabase method

    /**
     * create dialog box for add new client
     *
     * @return  new dialog box
     */
    public DialogBox createDialogBox() {

        // Create a dialog box and set the caption text
        final DialogBox dialogBox = new DialogBox();
        dialogBox.setText("Fill the fields for a new client");

        // Create a table to layout the content
        VerticalPanel dialogContents = new VerticalPanel();
        dialogContents.setSpacing(4);
        dialogBox.setWidget(dialogContents);

        // add name
        Label labelForName = new Label("*Name:");
        textBoxForName.setFocus(true);
        textBoxForName.setText("");
        dialogContents.add(labelForName);
        dialogContents.add(textBoxForName);

        // add Surname
        Label labelForSurname = new Label("*Surname:");
        dialogContents.add(labelForSurname);
        dialogContents.add(textBoxForSurname);

        // add email
        Label labelForEmail = new Label("Email:");
        dialogContents.add(labelForEmail);
        dialogContents.add(textBoxForEmail);

        // add DataOfBirth
        Label labelForDataOfBirth = new Label("Data of birth (YYYY-MM-DD):");
        dialogContents.add(labelForDataOfBirth);
        dialogContents.add(textBoxForDataOfBirth);

        // add sex
        Label labelForSex = new Label("Sex (M/F):");
        dialogContents.add(labelForSex);
        dialogContents.add(textBoxForSex);


        // Add a close button at the bottom of the dialog
        Button closeButton = new Button("Add new client", new ClickHandler() {
            public void onClick(ClickEvent event) {
                addClientFromPopUp();
                dialogBox.hide();
            }
        });
        dialogContents.add(closeButton);

        // Return the dialog box
        return dialogBox;
    }

    /**
     * create new client with parameters from popup panel
     */
    private void addClientFromPopUp () {

        final int lastId = Client.getLastId();
        // validate and assign name
        final String newClientName = textBoxForName.getText().trim();
        if (!newClientName.matches("^[A-Za-z]{1,20}$")) {
            Window.alert("'" + newClientName  + "' is not a valid symbol for newClientName.");
            textBoxForName.selectAll();
            return;
        }

        // validate and assign surname
        final String newClientSurname = textBoxForSurname.getText().trim();
        if (!newClientSurname.matches("^[A-Za-z]{1,20}$")) {
            Window.alert("'" + newClientSurname  + "' is not a valid symbol newClientSurname.");
            textBoxForSurname.selectAll();
            return;
        }

        // validate and assign email
        String newClientEmail = textBoxForEmail.getText().trim();
        if (newClientEmail.length() == 0) {
            newClientEmail = NO_EMAIL;
        } else if (!newClientEmail.matches("^[-\\w.]+@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$")) {
            Window.alert("'" + newClientEmail  + "' is not a valid symbol newClientEmail.");
            textBoxForEmail.selectAll();
            return;
        }

        // validate and assign data of birth in next format: YYYY-MM-DD
        String newClientDataOfBirth = textBoxForDataOfBirth.getText().trim();
        if ( newClientDataOfBirth.length() == 0) {
            newClientDataOfBirth = NO_DATE_OF_BIRTH;
        } else if (!newClientDataOfBirth.matches("[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])")) {
            Window.alert("'" +  newClientDataOfBirth  + "' is not a valid symbol newClientDataOfBirth.");
            textBoxForDataOfBirth.selectAll();
            return;
        }

        // validate and assign sex F/M
        String newClientSex = textBoxForSex.getText().trim();
        if ( newClientSex.length() == 0) {
            newClientSex = NO_SEX;
        } else if (!newClientSex .matches("[M|F]")) {
            Window.alert("'" +  newClientSex  + "' is not a valid symbol newClientSex.");
            textBoxForSex.selectAll();
            return;
        }

        // create new client
        Client newClient = new Client (lastId, newClientName, newClientSurname,
                newClientEmail, newClientDataOfBirth, newClientSex, countAge(newClientDataOfBirth));

        // set cursor on newSymbolTextBox
        textBoxForName.setFocus(true);
        textBoxForName.setText("");
        //textBoxForSurname.setText("");
        //textBoxForEmail.setText("");
        //textBoxForSex.setText("");

        // don't add the stock if it's already in the list
        if (clients.contains(newClient)) {
            Window.alert("Client already exist!");
            Client.setLastId( lastId - 1);
            return;
        }

        remServiceAsync.addNewClient(newClient, new AsyncCallback<Void>() {
            @Override
            public void onFailure(Throwable caught) {
                Window.alert("Error in addNewClient add");
            }

            @Override
            public void onSuccess(Void result) {
                //Window.alert("Клинет добавлен");
            }
        });
        addToFlexTable(newClient);
        clients.add(newClient);
    } // end of addClientFromPopUp method

    /**
     * add new client to flexTable
     *
     * @param newClient client for adding
     */
    public void addToFlexTable (Client newClient) {

        final Client finalClient = newClient;
        int row = clientsFlexTable.getRowCount();

        clientsFlexTable.getCellFormatter().addStyleName(row, 1, "watchListNumericColumn");
        clientsFlexTable.getCellFormatter().addStyleName(row, 2, "watchListNumericColumn");
        clientsFlexTable.getCellFormatter().addStyleName(row, 3, "watchListNumericColumn");
        clientsFlexTable.getCellFormatter().addStyleName(row, 4, "watchListNumericColumn");
        clientsFlexTable.getCellFormatter().addStyleName(row, 5, "watchListNumericColumn");
        clientsFlexTable.getCellFormatter().addStyleName(row, 6, "watchListRemoveColumn");

        // add button to remove this client from the list
        Button removeClient = new Button("x");
        removeClient.addStyleDependentName("remove");

        removeClient.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                int removedIndex = clients.indexOf(finalClient);
                clients.remove(removedIndex);
                clientsFlexTable.removeRow(removedIndex + 2);

                remServiceAsync.removeClient(finalClient, new AsyncCallback<Void>() {
                    @Override
                    public void onFailure(Throwable caught) {
                        Window.alert("Error in  addNewClientFromDB  delete");
                    }

                    @Override
                    public void onSuccess(Void result) {
                    }
                });

            }
        });

        clientsFlexTable.setText(row, 0, newClient.getName());
        clientsFlexTable.setText(row, 1, newClient.getSurname());
        clientsFlexTable.setText(row, 2, newClient.getEmailOrIndefined());
        if (newClient.getAge() == NO_AGE) {
            clientsFlexTable.setText(row, 3, NO_DATE_OF_BIRTH);
        } else {
            clientsFlexTable.setText(row, 3, String.valueOf(newClient.getAge()));
        }
        clientsFlexTable.setText(row, 4, newClient.getSexOrIndefined());
        clientsFlexTable.setWidget(row, 5, removeClient);
    } // end of addToFlexTable method

    /**
     * count age by data of birthday or 10_000 if
     * client have "no dataOfBirth"
     *
     * @param dataOfBirth   client data of birthday
     * @return              age
     */
    public int countAge(String dataOfBirth) {

        if (NO_DATE_OF_BIRTH.equals(dataOfBirth)) {
            return NO_AGE;
        }
        Date today = new Date();
        int todayYear = today.getYear()+1900;
        int todayMonth = today.getMonth()+1;
        int todayDay = today.getDate();

        String arr[] = dataOfBirth.split("-");
        int dayOfB = Integer.parseInt(arr[2]);
        int monthOfB = Integer.parseInt(arr[1]);
        int yearOfB = Integer.parseInt(arr[0]);

        int age = todayYear - yearOfB;

        if (todayMonth < monthOfB) {
            --age;
        } else  if ( (todayMonth >= monthOfB) && (todayDay < dayOfB)) {
            --age;
        }
        return age;
    } // end of countAge

    /**
     * remove all rows in flex table and add new
     * by specified way
     *
     * @param sortedClients collection with sored clients
     */
    public void sortFlexTable (ArrayList<Client> sortedClients) {

        int rowCount = clientsFlexTable.getRowCount()-2;
        // удаление всех записей
        for (int i = 0; i < rowCount; i++) {
            clientsFlexTable.removeRow(2);
        }
        //добавление к FlexTable
        for (Client cl : sortedClients) {
            final Client finalClient = cl;
            addToFlexTable(finalClient);
        }
    }// end of sortFlexTable
} // end of class
