/*
    This is the test project for Rozdoum
 */
package ua.yushin.gwt.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.google.gwt.core.client.GWT;

import java.util.ArrayList;

/**
 * interface for remote access
 *
 * @author      Yushin Roman
 * @version     28.06.2016
 */
@RemoteServiceRelativePath("RemoteService")
public interface RemService extends RemoteService {
    /*
    /*
     * Utility/Convenience class.
     * Use RemService.App.getInstance() to access static instance of RemServiceAsync


    public static class App {
        private static final RemServiceAsync ourInstance = (RemServiceAsync) GWT.create(RemService.class);

        public static RemServiceAsync getInstance() {
            return ourInstance;
        }
    }
*/

    /**
     * get all client from storage
     *
     * @return  all client from storage
     */
    ArrayList<Client> getAllClients();
}
