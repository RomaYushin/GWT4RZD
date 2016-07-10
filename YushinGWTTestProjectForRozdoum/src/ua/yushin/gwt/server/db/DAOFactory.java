package ua.yushin.gwt.server.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * abstract DAO factory
 *
 * @author      Yushin Roman
 * @version     04.07.2016
 */
public abstract class DAOFactory {

    /**
     * new DAOFactory object
     */
    private static DAOFactory instance;

    /**
     * new Connection object
     */
    private static Connection connection;

    /**
     * connect to database
     *
     * @return  new connection
     * @throws SQLException
     */
    public static Connection getConnection () throws SQLException {
        try {
            connection = DriverManager.getConnection(DAOConstants.DB_URL, DAOConstants.LOGIN, DAOConstants.PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    /**
     * return DAOClient object
     *
     * @return
     */
    public abstract DAOClient getDAOClient();
}
