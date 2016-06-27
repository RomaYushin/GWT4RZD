/*
    This is the test project for Rozdoum
 */
package consoleVariant;

import consoleVariant.db.ConnectionToMySQL;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class for storing clients in ArrayList and communication with
 * database. There are next methods in class: addNewClient, remove,
 * amountOtClients, getAllClients, getId, override toString.
 *
 * @author      Yushin Roman
 * @version     28.06.2016
 */
public class ClientContainer {

    /**
     * clients store all client from database
     */
    private static ArrayList <Client> clients = new ArrayList<>();

    /**
     * last id for all clients
     */
    private static int id = 0;

    /**
     * initialization clients
     */
    static {
        clients = ConnectionToMySQL.getAllClientsFromDB();

        // find max id
        for (int i = 0;  i < clients.size(); i++) {
            if (clients.get(i).getId() > id) {
                id = clients.get(i).getId();
            }
        }
    }

    /**
     * default constructor
     */
    public ClientContainer() {
    }

    /**
     * add new client in database and rewrite clients
     *
     * @param newClient     client for adding
     */
    public void addNewClient (Client newClient) {

        if (!clients.contains(newClient)) {
            // add new Client in ConnectionToMySQL class
            ConnectionToMySQL.addNewClientInDB(newClient);

            // rewrite clients
            clients = ConnectionToMySQL.getAllClientsFromDB();

            // find max id
            for (int i = 0;  i < clients.size(); i++) {
                if (clients.get(i).getId() > id) {
                    id = clients.get(i).getId();
                }
            }
        } else {
            System.out.println("Client with name: " + newClient.getName() + " already exist in DB");
            --id;
        }
    }

    /**
     * remove client from database and rewrite clients
     *
     * @param client4Remove     client for removing
     */
    public void removeClient ( Client client4Remove ) {
        // remove client from db in ConnectionToMySQL class
        ConnectionToMySQL.removeClientFromDB(client4Remove);

        // rewrite clients
        clients = ConnectionToMySQL.getAllClientsFromDB();
    }

    /**
     * amount value of client in clients
     *
     * @return  amount value of client in clients
     */
    public int amountOtClients() {
        return clients.size();
    }

    /**
     * get collection with all clients
     *
     * @return  clients collection
     */
    public static ArrayList<Client> getAllClients() {
        return clients;
    }

    /**
     * increments and return new id for client
     *
     * @return new id for client
     */
    public static int getId() {
        ++id;
        return id;
    }

    /**
     * override method toString by specified way
     *
     * @return    string, which contains all clients
     */
    @Override
    public String toString() {

        Iterator<Client> iter = clients.iterator();
        StringBuilder sb = new StringBuilder();

        while (iter.hasNext()) {
            Client clientIter = iter.next();
            sb.append(clientIter.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
