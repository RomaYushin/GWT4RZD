/*
    This is the test project for Rozdoum
 */
package ua.yushin.gwt.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import ua.yushin.gwt.client.Client;
import ua.yushin.gwt.client.RemService;

import java.util.ArrayList;

/**
 * realisation of interfaces RemoteServiceServlet and  RemService
 * get all clients from storage
 *
 * @author      Yushin Roman
 * @version     28.06.2016
 */
public class RemServiceImpl extends RemoteServiceServlet implements RemService {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 2828969610840323756L;

    /**
     * in clients stores all clients
     */
    private ArrayList <Client> clients = new ArrayList<>();

    /**
     * in this method, for example, create two client with name Bob and Joe
     * and put them in clients. In general we can make query to database.
     * At finally return clients.
     *
     * @return
     */
    @Override
    public ArrayList<Client> getAllClients() {

        // here we can connect to db
        // create client1, client2
        Client client1 = new Client("Bob");
        Client client2 = new Client("John");

        //put them in collection
        clients.add(client1);
        clients.add(client2);

        return clients;
    }
}