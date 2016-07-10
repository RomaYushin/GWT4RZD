/*
    This is the test project for Rozdoum
 */
package ua.yushin.gwt.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import ua.yushin.gwt.client.Client;
import ua.yushin.gwt.client.RemService;
import ua.yushin.gwt.server.db.MySQLDAOClient;

import java.util.*;

/**
 * realisation of interfaces RemoteServiceServlet and  RemService
 * get all clients from storage
 *
 * @author      Yushin Roman
 * @version     04.07.2016
 */
public class RemServiceImpl extends RemoteServiceServlet implements RemService {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 2828969610840323756L;

    /**
     * in clients stores all clients
     */
    private static ArrayList <Client> clients = new ArrayList<>();

    /**
     * new instance of MySQLDAOClient class for work with database
     */
    private static MySQLDAOClient mySQLDAOClient = new MySQLDAOClient();

    static {
        clients = mySQLDAOClient.getAllClientsFromDB();
    }


    /**
     * add new client to database
     *
     * @param newClient new client for adding
     */
    @Override
    public void addNewClient(Client newClient) {
        mySQLDAOClient.addNewClientInDB(newClient);
        clients.add(newClient);
    }

    /**
     * remove specified client from database
     *
     * @param removedClient client for removing
     */
    @Override
    public void removeClient(Client removedClient) {
        mySQLDAOClient.removeClientFromDB(removedClient);
        clients.remove(removedClient);
    }

    /**
     * in this method, for example, create two client with name Bob and Joe
     * and put them in clients. In general we can make query to database.
     * At finally return clients.
     *
     * @return
     */
    @Override
    public ArrayList<Client> getAllClients() {
        return clients;
    }

    /**
     * sort clients by name
     *
     * @param clientsBeforeSort     arrayList with clients before sorting
     * @return
     */
    public ArrayList<Client> sortByName (ArrayList <Client> clientsBeforeSort) {
        Collections.sort(clientsBeforeSort, (client1, client2)
                ->  client1.getName().compareTo(client2.getName()));
        return clientsBeforeSort;
    }

    /**
     * sort clients by surname
     *
     * @param clientsBeforeSort     arrayList with clients before sorting
     * @return
     */
    @Override
    public ArrayList<Client> sortBySurname(ArrayList<Client> clientsBeforeSort) {
        Collections.sort(clientsBeforeSort, (client1, client2)
                -> client1.getSurname().compareTo(client2.getSurname()));
        return clientsBeforeSort;
    }

    /**
     * sort clients by email
     *
     * @param clientsBeforeSort     arrayList with clients before sorting
     * @return
     */
    @Override
    public ArrayList<Client> sortByEmail(ArrayList<Client> clientsBeforeSort) {
        Collections.sort(clientsBeforeSort, (client1, client2)
                -> client1.getEmailOrIndefined().compareTo(client2.getEmailOrIndefined()));
        return clientsBeforeSort;
    }

    /**
     * sort clients by age
     *
     * @param clientsBeforeSort     arrayList with clients before sorting
     * @return
     */
    @Override
    public ArrayList<Client> sortByAge(ArrayList<Client> clientsBeforeSort) {
        Collections.sort(clientsBeforeSort, (client1, client2)
                -> client1.getAge() - client2.getAge());
        return clientsBeforeSort;
    }

    /**
     * sort clients by sex
     *
     * @param clientsBeforeSort     arrayList with clients before sorting
     * @return
     */
    @Override
    public ArrayList<Client> sortBySex(ArrayList<Client> clientsBeforeSort) {
        Collections.sort(clientsBeforeSort, (client1, client2)
                -> client1.getSexOrIndefined().compareTo(client2.getSexOrIndefined()));
        return clientsBeforeSort;
    }
}