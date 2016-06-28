/*
    This is the test project for Rozdoum
 */
package ua.yushin.gwt.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 *  interface for remote asynchronous access
 *
 * @author      Yushin Roman
 * @version     28.06.2016
 */
public interface RemServiceAsync {

    /**
     * get all client from storage
     *
     * @return  all client from storage
     */
    void getAllClients (AsyncCallback asyncCallback);
}
