package by.epam.film.rating.task04.main;

import by.epam.film.rating.task04.dao.db.ConnectionPool;
import by.epam.film.rating.task04.dao.db.DBParameter;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class Main {
//    public static String ADD_POSTER = "insert into genre (id, genre) values(?, ?);";
    public static String ADD_GENRE = "insert into genre (genre) values(?);";
    public static String ADD_COUNTRY = "insert into country_of_origin (production_country) values(?);";
    public static String ADD_AGE_RATING = "insert into film_age_rating (age_rating) values(?);";
    public static String ADD_TYPE = "insert into film_type (type) values(?);";
//    public static String ADD_FILM = "insert into film (id, production_year, name, description, film_rating, review_amount, type_id, age_rating_id) values(?, ?, ?, ?, ?, ?, ?, ?);";
    public static String ADD_FILM = "insert into film (production_year, name, film_rating, review_amount, type_id, age_rating_id) values(?, ?, ?, ?, ?, ?);";
    public static void main(String args[]) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, SQLException {

        Class.forName(DBParameter.DB_DRIVER);

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;




        try {
            ConnectionPool connectable = ConnectionPool.getInstance();

    //        connection = connectable.getConnection();
    //        statement = connection.createStatement();
//            resultSet = statement.executeQuery("select * from film where id=2");
    //         preparedStatement = connection.prepareStatement(ADD_FILM);
//            PreparedStatement preparedStatement = connection.prepareStatement("insert into genre values (7, 'some shit')");
//            resultSet = statement.executeUpdate("insert into genre values (4, 'war')");



            connection = connectable.getConnection();
            statement = connection.createStatement();
//            PreparedStatement preparedStatement = connection.prepareStatement(ADD_FILM);
//            preparedStatement.setInt(1, 1);
//            preparedStatement.setInt(2, 2000);
//            preparedStatement.setString(3, "film");
//            preparedStatement.setString(4, "ff");
//            preparedStatement.setDouble(5, 0);
//            preparedStatement.setInt(6, 0);
//            preparedStatement.setInt(7, 2);
//            preparedStatement.setInt(8, 2);

//            PreparedStatement preparedStatement = connection.prepareStatement(ADD_GENRE);
//            preparedStatement.setString(1, "war");

//              PreparedStatement preparedStatement = connection.prepareStatement(ADD_COUNTRY);
//              preparedStatement.setString(1, "poland");

//            PreparedStatement preparedStatement = connection.prepareStatement(ADD_AGE_RATING);
//            preparedStatement.setString(1, "R6");

//            PreparedStatement preparedStatement = connection.prepareStatement(ADD_TYPE);
//            preparedStatement.setString(1, "film");



//            while (resultSet.next()) {
//                System.out.print(resultSet.getInt(1) + " | " +
//                        resultSet.getInt(2) + " | ");
//            }

            PreparedStatement preparedStatement = connection.prepareStatement(ADD_FILM);
            preparedStatement.setInt(1, 2000);
            preparedStatement.setString(2, "film");
            preparedStatement.setDouble(3, 0);
            preparedStatement.setInt(4, 0);
            preparedStatement.setInt(5, 1);
            preparedStatement.setInt(6, 1);

            preparedStatement.executeUpdate();

            connectable.releaseConnection(connection);



        } catch (SQLException | InterruptedException throwables) {
            throwables.printStackTrace();
        } finally {
            connection.close();
            statement.close();
//            resultSet.close();

        }





    }


}
