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
 * @version     04.07.2016
 * @see         consoleVariant.Client
 */
public class Client implements Serializable {

    /**
     * name of the client
     */
    private String name;

    /**
     * surname of the client
     */
    private String surname;

    /**
     * email of the client
     */
    private String email;

    /**
     * data of birth
     */
    private String dataOfBirth;

    /**
     * sex of the client
     */
    private String sex;

    /**
     * id of the client
     */
    private int id;

    /**
     * age of the client
     */
    private int age;

    /**
     * last non duplicating id for new client
     */
    private static int lastId = 0;

    /**
     * default constructor
     */
    public Client() {
    }

    /**
     * this constructor is for creating client when we read information
     * from database
     *
     * @param id            id of the client
     * @param name          name of the client
     * @param surname       surname of the client
     * @param email         email of the client
     * @param dataOfBirth   data of birth of the client
     * @param sex           sex of the client
     * @param age           age of the client
     */
    public Client(int id, String name, String surname,  String email, String dataOfBirth, String sex, int age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.dataOfBirth = dataOfBirth;
        this.sex = sex;
        this.age = age;
    }

    /**
     * get method for name
     *
     * @return  name of the client
     */
    public String getName() {
        return name;
    }

    /**
     * get method for surname
     *
     * @return  surname of the client
     */
    public String getSurname() {
        return surname;
    }

    /**
     * get method for email
     *
     * @return  email of the client or "no email" if
     *          client have not email
     */
    public String getEmailOrIndefined() {
        return email;
    }

    /**
     * get method for data of birth
     *
     * @return  data of birth or "no dataOfBirth" if
     *          client have not data of birth
     */
    public String getDataOfBirthOrIndefined() {
        return dataOfBirth;
    }

    /**
     * get method for sex of the client
     *
     * @return  sex of the client or "no sex" if
     *          client have not sex
     */
    public String getSexOrIndefined() {
        return sex;
    }

    /**
     * get method for id of the client
     *
     * @return  id of the client
     */
    public int getId() {
        return id;
    }

    /**
     * get method for lastId.
     *
     * @return  return unique number for
     *          every new client
     */
    public static int getLastId() {
        return ++lastId;
    }

    /**
     * set method for LastId
     *
     * @param lastId    new lastId for class variable
     */
    public static void setLastId(int lastId) {
        Client.lastId = lastId;
    }

    /**
     * get method for age of the client
     *
     * @return  age of the client
     */
    public int getAge() {
        return age;
    }

    /**
     * set method for age of the client
     *
     * @param age  new age for client
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * override equals(Object o) by specified way
     *
     * @param   o   object for comparing
     * @return      true if o equal to object who called equals
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;

        Client client = (Client) o;

        if (!getName().equals(client.getName())) return false;
        if (!getSurname().equals(client.getSurname())) return false;
        if (!email.equals(client.email)) return false;
        if (!dataOfBirth.equals(client.dataOfBirth)) return false;
        return sex.equals(client.sex);

    }

    /**
     * override hashCode by specified way
     *
     * @return  hashCode for new Client
     */
    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getSurname().hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + dataOfBirth.hashCode();
        result = 31 * result + sex.hashCode();
        return result;
    }

    /**
     * override toString method
     *
     * @return  client in string in next view:
     *          Client[[name='someName'], [[surname='someSurname']], [email='someEmail'],
     *          [age='someAge'], [sex='someSex'], [id='someId']]
     */
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Client[");
        sb.append("[name='").append(name).append("\']");
        sb.append(", [surname='").append(surname).append("\']");
        sb.append(", [email='").append(email).append("\']");
        sb.append(", [age='").append(getAge()).append("\']");
        sb.append(", [sex=").append(sex).append("\']");
        sb.append(", [id=").append(id).append("\']");
        sb.append(']');
        return sb.toString();
    }
}