/*
    This is the test project for Rozdoum
 */
package ua.yushin.gwt.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import java.util.ArrayList;

/**
 * interface for remote access
 *
 * @author      Yushin Roman
 * @version     04.07.2016
 */
@RemoteServiceRelativePath("RemoteService")
public interface RemService extends RemoteService {

    /**
     * add new client to database
     *
     * @param newClient new client for adding
     */
    void addNewClient (Client newClient);

    /**
     * remove specified client
     *
     * @param removedClient client for removing
     */
    void removeClient (Client removedClient);

    /**
     * get all client from storage
     *
     * @return  all client from storage
     */
    ArrayList<Client> getAllClients();

    /**
     * sorting clients by name
     *
     * @param clientsBeforeSort     arrayList with clients before sorting
     * @return                      arrayList with clients after sorting
     */
    ArrayList<Client> sortByName(ArrayList<Client> clientsBeforeSort);

    /**
     * sorting clients by surname
     *
     * @param clientsBeforeSort     arrayList with clients before sorting
     * @return                      arrayList with clients after sorting
     */
    ArrayList<Client> sortBySurname(ArrayList<Client> clientsBeforeSort);

    /**
     * sorting clients by email
     *
     * @param clientsBeforeSort     arrayList with clients before sorting
     * @return                      arrayList with clients after sorting
     */
    ArrayList<Client> sortByEmail(ArrayList<Client> clientsBeforeSort);

    /**
     * sorting clients by age
     *
     * @param clientsBeforeSort     arrayList with clients before sorting
     * @return                      arrayList with clients after sorting
     */
    ArrayList<Client> sortByAge(ArrayList<Client> clientsBeforeSort);

    /**
     * sorting clients by sex
     *
     * @param clientsBeforeSort     arrayList with clients before sorting
     * @return                      arrayList with clients after sorting
     */
    ArrayList<Client> sortBySex(ArrayList<Client> clientsBeforeSort);
}