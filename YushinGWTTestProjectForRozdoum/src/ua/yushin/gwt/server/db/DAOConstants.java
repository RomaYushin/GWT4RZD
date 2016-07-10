package ua.yushin.gwt.server.db;


/**
 * Some constants for coonect ti database
 *
 * @author      Yushin Roman
 * @version     04.07.2016
 */
public final class DAOConstants {

    // it can be taken from an external configuration file using the ResourceBundle

    /**
     * driver for connection
     */
    public static final String DRIVER_CLASS_NAME = "";

    /**
     * url to connection to database
     */
    public static final String DB_URL = "jdbc:mysql://localhost/yushin_gwt_test_project_for_rozdoum_db2?SSL=false";

    /**
     * dao factory class name
     */
    public static final String DAO_FACTORY_CLASS_NAME = "ua.yushin.gwt.server.db.MySQLDAOFactory";

    /**
     * name of the user
     */
    public static final String LOGIN = "root";

    /**
     * password of the user
     */
    public static final String PASSWORD = "1111";
}
