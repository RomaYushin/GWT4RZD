/*
    This is the test project for Rozdoum
 */
package consoleVariant.comparators;

import consoleVariant.Client;
import java.util.Comparator;

/**
 * ClientComparatorByAge is for sorting client by age from
 * older to more younger
 *
 * @author      Yushin Roman
 * @version     28.06.2016
 */
public class ClientComparatorByAge implements Comparator <Client> {

    /**
     * compate two clients and return 0 if ages are the same
     * -value if client1 older than client2 and +value if
     * client1 younger than client2
     *
     * @param client1   client1 instance
     * @param client2   client2 instance
     * @return          value of comparing
     */
    @Override
    public int compare(Client client1, Client client2) {
        return client2.getAge() - client1.getAge();
    }
}
