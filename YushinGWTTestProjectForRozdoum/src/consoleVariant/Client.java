/*
    This is the test project for Rozdoum
 */
package consoleVariant;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Describes the client, who can be stored in database.
 * One client have name, surname, email, data of birth,
 * sex , id
 *
 * @author      Yushin Roman
 * @version     28.06.2016
 */
public class Client {

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
     * sex of birth
     */
    private String sex;

    /**
     * id of the client
     */
    private int id;

    /**
     * constructor for creating client from main method, without id.
     * id gets from ClientContainer after reading database
     *
     * @param name          name of the client
     * @param surname       surname of the client
     * @param email         email of the client
     * @param dataOfBirth   data of birth of the client
     * @param sex           sex of the client
     */
    public Client(String name, String surname,  String email, String dataOfBirth, String sex) {

        this.name = name;
        this.surname = surname;
        this.email = email;
        this.dataOfBirth = dataOfBirth;
        this.sex = sex;
        this.id = ClientContainer.getId();
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
     */
    public Client(int id, String name, String surname,  String email, String dataOfBirth, String sex) {

        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.dataOfBirth = dataOfBirth;
        this.sex = sex;
    }

    /**
     * get age of the client
     *
     * @return age of the client
     */
    public int getAge() {

        // return 0 age if dataOfBirth == "no dateOfBirth"
        if (Main.getNoDateOfBirth().equals(dataOfBirth)) {
            return 0;
        }

        int age= 0;
        // get today date
        Calendar today = Calendar.getInstance();

        // get date of birth
        Calendar dob = Calendar.getInstance();

        // convert from string to new GregorianCalendar instance
        String arr[] = dataOfBirth.split("/");
        int days = Integer.parseInt(arr[0]);
        int month = Integer.parseInt(arr[1]);
        int years = Integer.parseInt(arr[2]);
        dob.setTime(new GregorianCalendar(years, month, days).getTime());
        dob.add(Calendar.DAY_OF_MONTH, -1);

        // find age
        age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
        if (today.get(Calendar.DAY_OF_YEAR) <= dob.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }
        return age;
    }

    /**
     * get method for name
     *
     * @return  name of the client
     */
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmailOrIndefined() {
        return email;
    }

    public String getDataOfBirthOrIndefined() {
        return dataOfBirth;
    }

    public String getSexOrIndefined() {
        return sex;
    }

    public int getId() {
        return id;
    }
        /*
        Пример валидации даты

        Pattern pattern = Pattern.compile("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((18|20)\\d\\d)");
        Matcher matcher = pattern.matcher(newDataOfBirth);

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
