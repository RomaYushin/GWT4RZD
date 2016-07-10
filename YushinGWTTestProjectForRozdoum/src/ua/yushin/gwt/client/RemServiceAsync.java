/*
    This is the test project for Rozdoum
 */
package ua.yushin.gwt.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.ArrayList;

/**
 *  interface for remote asynchronous access
 *
 * @author      Yushin Roman
 * @version     04.07.2016
 */
public interface RemServiceAsync {

    /**
     * get all client from database
     *
     * @param asyncCallback
     */
    void getAllClients (AsyncCallback<java.util.ArrayList<Client>> asyncCallback);

    /**
     * add new client to database
     *
     * @param async
     */
    void addNewClient(Client newClient, AsyncCallback<Void> async);

    /**
     * remove specified client from database
     *
     * @param removedClient
     * @param async
     */
    void removeClient(Client removedClient, AsyncCallback<Void> async);

    /**
     * sort clients by name
     *
     * @param clientsBeforeSort
     * @param async
     */
    void sortByName(ArrayList<Client> clientsBeforeSort, AsyncCallback<ArrayList<Client>> async);

    /**
     * sort clients by surname
     *
     * @param clientsBeforeSort
     * @param async
     */
    void sortBySurname(ArrayList<Client> clientsBeforeSort, AsyncCallback<ArrayList<Client>> async);

    /**
     * sort clients by email
     *
     * @param clientsBeforeSort
     * @param async
     */
    void sortByEmail(ArrayList<Client> clientsBeforeSort, AsyncCallback<ArrayList<Client>> async);

    /**
     * sort clients by age
     *
     * @param clientsBeforeSort
     * @param async
     */
    void sortByAge(ArrayList<Client> clientsBeforeSort, AsyncCallback<ArrayList<Client>> async);

    /**
     * sort clients by sex
     *
     * @param clientsBeforeSort
     * @param async
     */
    void sortBySex(ArrayList<Client> clientsBeforeSort, AsyncCallback<ArrayList<Client>> async);
}