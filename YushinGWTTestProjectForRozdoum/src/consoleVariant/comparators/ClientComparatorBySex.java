/*
    This is the test project for Rozdoum
 */
package consoleVariant.comparators;

import consoleVariant.Client;
import java.util.Comparator;

/**
 * ClientComparatorBySex is for sorting client by sex. First FEMALE,
 * second MALE, third no sex
 *
 * @author      Yushin Roman
 * @version     28.06.2016
 */
public class ClientComparatorBySex  implements Comparator<Client> {

    /**
     * compare two clients and call method compareTo in class String
     *
     * @param client1   client1 instance
     * @param client2   client2 instance
     * @return          value of comparing
     */
    @Override
    public int compare(Client client1, Client client2) {
        return client1.getSexOrIndefined().compareTo(client2.getSexOrIndefined());
    }
}
