package by.epam.film.rating.task04.main;

import by.epam.film.rating.task04.dao.db.ConnectionPool;
import by.epam.film.rating.task04.dao.db.ConnectionPoolFactory;
import by.epam.film.rating.task04.dao.db.DBParameter;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class Main {
    public static void main(String args[]) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, SQLException {

        Class.forName(DBParameter.DB_DRIVER);

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            ConnectionPoolFactory connectionPoolFactory = ConnectionPoolFactory.getInstance();

            ConnectionPool connectionPool = connectionPoolFactory.getConnectionPool();

            connection = connectionPool.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from genre");

            while (resultSet.next()) {
                System.out.println(resultSet.getString(2));
            }
            connectionPool.releaseConnection(connection);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            connection.close();
            statement.close();
            resultSet.close();
        }
    }
}
