/*
    This is the test project for Rozdoum
 */
package consoleVariant.comparators;

import consoleVariant.Client;
import java.util.Comparator;

/**
 * ClientComparatorByName is for sorting client by name in nature sorting
 *
 * @author      Yushin Roman
 * @version     28.06.2016
 */
public class ClientComparatorByName implements Comparator<Client>{

    /**
     * compare two clients and call method compareTo in class String
     *
     * @param client1   client1 instance
     * @param client2   client2 instance
     * @return          value of comparing
     */
    @Override
    public int compare(Client client1, Client client2) {
        return client1.getName().compareTo(client2.getName());
    }
}
