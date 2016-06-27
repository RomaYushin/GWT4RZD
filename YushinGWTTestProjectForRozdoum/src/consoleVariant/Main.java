/*
    This is the test project for Rozdoum
 */
package consoleVariant;

import consoleVariant.comparators.*;

import java.util.*;

/**
 * This variant of Task works only in console.
 * This class is for starting run application.
 *
 * @author      Yushin Roman
 * @version     28.06.2016
 */
public class Main {

    /**
     * for creating new Client, who doesn't have an email
     */
    private static final String NO_EMAIL = "no email";

    /**
     * for creating new Client, who doesn't have a date Of birth
     */
    private static final String NO_DATE_OF_BIRTH = "no dateOfBirth";

    /**
     * for creating new Client, who doesn't have a date Of birth
     */
    private static final String NO_SEX = "no sex";

    /**
     * entry-point for this application
     *
     * @param args  array of Strings from outside this app or null
     * @throws      IllegalAccessException
     * @throws      InstantiationException
     */
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {

        // Создание 5 клиентов
        //Предпологаем, что на клиенте прошла валидация входных данных и null не может быть
/*
        Client client1 = new Client("Albert", "Einschtein",  NO_EMAIL, NO_DATE_OF_BIRTH, NO_SEX);
        Client client2 = new Client("Albert", "Einschtein",  NO_EMAIL, NO_DATE_OF_BIRTH, NO_SEX);

        Client client2 = new Client("Robert", "De Niro","no email", "17/8/1943",  "no sex");
        Client client3 = new Client("Enzo", "Ferrari", "ferrari@google.com",  "18/2/1898", "no sex");
        Client client4 = new Client("Barack", "Obama", "USAPresident@google.usa", "4/8/1961",  "MALE");
        Client client5 = new Client("Michel", "Obama", "FiveOfUSAPresident@google.com", "17/1/1964", "FEMALE");
*/

        ClientContainer clientContainer = new ClientContainer();

        // suppose that validation on client side was done
        // add new clients in database
        clientContainer.addNewClient(new Client("Albert", "Einschtein",  NO_EMAIL, NO_DATE_OF_BIRTH, NO_SEX));
        clientContainer.addNewClient(new Client("Albert", "Einschtein",  NO_EMAIL, NO_DATE_OF_BIRTH, NO_SEX));

        clientContainer.addNewClient(new Client("Robert", "De Niro","no email", "17/8/1943",  "no sex"));
        clientContainer.addNewClient(new Client("Robert", "De Niro","no email", "17/8/1943",  "no sex"));

        clientContainer.addNewClient(new Client("Enzo", "Ferrari", "ferrari@google.com",  "18/2/1898", "no sex"));
        clientContainer.addNewClient(new Client("Barack", "Obama", "USAPresident@google.usa", "4/8/1961",  "MALE"));
        clientContainer.addNewClient(new Client("Michel", "Obama", "FiveOfUSAPresident@google.com", "17/1/1964", "FEMALE"));


        // show all clients
        System.out.println(clientContainer.toString());

        // remove client from database
        clientContainer.removeClient(ClientContainer.getAllClients().get(0));

        // show all clients
        System.out.println(clientContainer.toString());

        // show age
        System.out.println(ClientContainer.getAllClients().get(0).getName()+ " is "+  ClientContainer.getAllClients().get(0).getAge() + " year old.");
        System.out.println(ClientContainer.getAllClients().get(2).getName()+ " is "+  ClientContainer.getAllClients().get(2).getAge() + " year old.");


        // show clients
        System.out.println(" Натуральная сортировка: ");
        System.out.println(clientContainer.toString());

        // sort by name and show clients
        //Collections.sort(ClientContainer.getAllClients(), ClientComparatorByName.class.newInstance());
        Collections.sort(ClientContainer.getAllClients(), (client1, client2)
                -> client1.getName().compareTo(client2.getName()));

        System.out.println(" Сортировка по имени: ");
        System.out.println(clientContainer.toString());

        // sort by surname and show clients
        //Collections.sort(ClientContainer.getAllClients(), ClientComparatorBySurname.class.newInstance());
        Collections.sort(ClientContainer.getAllClients(), (client1, client2)
                -> client1.getSurname().compareTo(client2.getSurname()));
        System.out.println(" Сортировка по фамилии: ");
        System.out.println(clientContainer.toString());

        // sort by email and show clients
        //Collections.sort(ClientContainer.getAllClients(), ClientComparatorByEmail.class.newInstance());
        Collections.sort(ClientContainer.getAllClients(), (client1, client2)
                -> client1.getEmailOrIndefined().compareTo(client2.getEmailOrIndefined()));
        System.out.println(" Сортировка по почте: ");
        System.out.println(clientContainer.toString());

        // sort by age and show clients
        //Collections.sort(ClientContainer.getAllClients(), ClientComparatorByAge.class.newInstance());
        Collections.sort(ClientContainer.getAllClients(), (client1, client2)
                -> client1.getAge() - client2.getAge());
        System.out.println(" Сортировка по возрасту: ");
        System.out.println(clientContainer.toString());

        // sort by sex and show clients
        //Collections.sort(ClientContainer.getAllClients(), ClientComparatorBySex.class.newInstance());
        Collections.sort(ClientContainer.getAllClients(), (client1, client2)
                -> client1.getSexOrIndefined().compareTo(client2.getSexOrIndefined()));
        System.out.println(" Сортировка по полу: ");
        System.out.println(clientContainer.toString());

    }

    public static String getNoSex() {
        return NO_SEX;
    }

    public static String getNoDateOfBirth() {
        return NO_DATE_OF_BIRTH;
    }

    public static String getNoEmail() {
        return NO_EMAIL;
    }
}
