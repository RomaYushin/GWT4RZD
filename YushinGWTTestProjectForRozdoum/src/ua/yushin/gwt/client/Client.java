/*
    This is the test project for Rozdoum
 */
package ua.yushin.gwt.client;

import java.io.Serializable;

/**
 * Describes the client, who can be stored in database.
 * One client have name
 *
 * @author      Yushin Roman
 * @version     28.06.2016
 * @see         consoleVariant.Client
 */
public class Client implements Serializable {

    /**
     * name of the client
     */
    private String name;

    /**
     * default constructor
     */
    public Client() {
    }

    /**
     * initialization instance with name
     *
     * @param name  name of the client
     */
    public Client(String name) {
        this.name = name;
    }

    /**
     * return name of the client
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * set name of the client
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
}
