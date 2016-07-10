package ua.yushin.gwt.server.db;

import ua.yushin.gwt.client.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * execute queries to database MySQL
 *
 * @author      Yushin Roman
 * @version     04.07.2016
 */
public class MySQLDAOClient implements DAOClient {

    /**
     * return all clients from database
     */
    private static final String SELECT_ALL_CLIENTS_FROM_DB =
            "SELECT * FROM clients;";

    /**
     * put new client to database
     */
    private static final String INSERT_NEW_CLIENT_IN_DB =
            "INSERT INTO `yushin_gwt_test_project_for_rozdoum_db2`.`clients`(`id`,`Name`, `surname`, `email`, `dataOfBirth`, `sex`, `age`) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?);";

    /**
     * delete specified client from database
     */
    private static final String DELETE_CLIENT_FROM_DB_BY_NAME =
            "DELETE FROM yushin_gwt_test_project_for_rozdoum_db2.clients WHERE (id = ?);";
    /**
     * variable for connection with database
     */
    private static Connection conn;

    /**
     * An object that represents a precompiled SQL statement.
     */
    private static PreparedStatement preparedStatement;

    /**
     * add new client to database
     *
     * @param newClient client for adding
     */
    @Override
    public void addNewClientInDB(Client newClient) {

        String SQLQuery = "INSERT INTO `yushin_gwt_test_project_for_rozdoum_db2`.`clients` " +
                "(`id`,`Name`, `surname`, `email`, `dataOfBirth`, `sex`, `age`)" +
                " VALUES ('"+ newClient.getId() + "', '" + newClient.getName() + "', '"+ newClient.getSurname() + "', '"
                + newClient.getEmailOrIndefined() + "', '"+ newClient.getDataOfBirthOrIndefined() + "', '"
                + newClient.getSexOrIndefined()+"', '" + newClient.getAge() + "');";

        try {
            conn = DAOFactory.getConnection();
            preparedStatement = conn.prepareStatement(SQLQuery);
            //preparedStatement.setInt(1, newClient.getId());
            //preparedStatement.setString(2, newClient.getName());

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // close connection
            try {conn.close();} catch (SQLException e) {}
            try {preparedStatement.close();} catch (SQLException e) {}
        }
    }

    /**
     * remove specified client from database by id
     *
     * @param removedClient client for removing
     */
    @Override
    public void removeClientFromDB(Client removedClient) {
        try {
            conn = DAOFactory.getConnection();
            preparedStatement = conn.prepareStatement(DELETE_CLIENT_FROM_DB_BY_NAME);
            preparedStatement.setInt(1, removedClient.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // close connection
            try {conn.close();} catch (SQLException e) {}
            try {preparedStatement.close();} catch (SQLException e) {}
        }
    }

    /**
     * return all clients from database
     *
     * @return
     */
    @Override
    public ArrayList<Client> getAllClientsFromDB() {
        ArrayList<Client> clientsFromDB = new ArrayList<>();
        ResultSet resultSet = null;
        int i = 0;
        try {
            conn = DAOFactory.getConnection();
            preparedStatement = conn.prepareStatement(SELECT_ALL_CLIENTS_FROM_DB);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                clientsFromDB.add(i++, new Client(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4), resultSet.getString(5),
                        resultSet.getString(6),resultSet.getInt(7)));
            }
        } catch (SQLException e ){
            e.printStackTrace();
        } finally {
            //close connection
            try {conn.close();} catch (SQLException e) {}
            try {preparedStatement.close();} catch (SQLException e) {}
            try {resultSet.close();} catch (SQLException e) {}
        }
        return clientsFromDB;
    }
}
