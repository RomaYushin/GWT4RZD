package ua.yushin.gwt.server.db;

/**
 * realisation for abstract class DAOFactory
 *
 * @author      Yushin Roman
 * @version     04.07.2016
 */
public class MySQLDAOFactory extends DAOFactory {

    @Override
    public DAOClient getDAOClient() {
        return new MySQLDAOClient();
    }
}
