package ua.yushin.gwt.server.db;

import ua.yushin.gwt.client.Client;
import java.util.ArrayList;

/**
 * DAO interface for client
 *
 * @author      Yushin Roman
 * @version     04.07.2016
 */
public interface DAOClient {
    /**
     * add new client to database
     *
     * @param newClient client for adding
     */
    void addNewClientInDB(Client newClient);

    /**
     * remove client from database
     *
     * @param removedClient client for removing
     */
    void removeClientFromDB(Client removedClient);

    /**
     * get all clients from database
     *
     * @return  arrayList with all clients from database
     */
    ArrayList<Client> getAllClientsFromDB();
}
