package by.epam.film.rating.task04.dao;

import by.epam.film.rating.task04.dao.db.ConnectionPool;
import by.epam.film.rating.task04.dao.entity.user.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDAOImpl implements UserDAO{

    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    UserDAOImpl() {}


    @Override
    public List<User> searchByNickname(String nickname) throws SQLException {

        connection = null;
        statement = null;
        resultSet = null;

        try {
            ConnectionPool connectable = ConnectionPool.getInstance();

            connection = connectable.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from genre");

            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
            }
            connectable.releaseConnection(connection);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            connection.close();
            statement.close();
            resultSet.close();
        }


        return null;
    }
}
