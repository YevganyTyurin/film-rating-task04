package by.epam.film.rating.task04.dao;

import by.epam.film.rating.task04.dao.builder.InstanceBuilder;
import by.epam.film.rating.task04.dao.db.ConnectionPool;
import by.epam.film.rating.task04.dao.entity.film.*;
import by.epam.film.rating.task04.dao.entity.user.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmDAOImpl implements FilmDAO{

    public static String ADD_POSTER = "insert into poster values (id, poster_image, film_id) values(?, ?, ?);";
    public static String GET_USERS = "select * from user;";

    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    private PreparedStatement preparedStatement = null;

    FilmDAOImpl() {}

    @Override
    public int addTrailer (int trailerId, String trailerPath, int filmId) throws SQLException {
        ConnectionPool connectable = ConnectionPool.getInstance();

        connection = connectable.getConnection();
        statement = connection.createStatement();
        preparedStatement = connection.prepareStatement(ADD_POSTER);
        preparedStatement.setInt(1, trailerId);
        preparedStatement.setString(2, trailerPath);
        preparedStatement.setInt(3, filmId);
        return preparedStatement.executeUpdate();
    }

    public int addPoster (int posterId, String posterPath, int filmId) throws SQLException {
        ConnectionPool connectable = ConnectionPool.getInstance();

        connection = connectable.getConnection();
        statement = connection.createStatement();
        preparedStatement = connection.prepareStatement(ADD_POSTER);
        preparedStatement.setInt(1, posterId);
        preparedStatement.setString(2, posterPath);
        preparedStatement.setInt(3, filmId);
        return preparedStatement.executeUpdate();
    }

    public int addFilm () throws SQLException {
        ConnectionPool connectable = ConnectionPool.getInstance();
        String ADD_FILM = "insert into film values (production_year, name, type_id, age_rating_id,film_id) values(?, ?, ?, ?, ?);";

        connection = connectable.getConnection();
        statement = connection.createStatement();
        preparedStatement = connection.prepareStatement(ADD_FILM);
        preparedStatement.setInt(1, 2000);
        preparedStatement.setString(2, "film");
        preparedStatement.setDouble(5, 0);
        preparedStatement.setInt(6, 0);
        preparedStatement.setInt(7, 2);
        preparedStatement.setInt(8, 2);
        return preparedStatement.executeUpdate();
    }

    public List<User> getAllUsers() throws SQLException {

        try {
            List<User> users = new ArrayList<>();

            ConnectionPool connectable = ConnectionPool.getInstance();
            connection = connectable.getConnection();
            statement = connection.createStatement();
            preparedStatement = connection.prepareStatement(GET_USERS);

            InstanceBuilder builder = new InstanceBuilder();
            while (resultSet.next()) {
                users.add(builder.buildUser(resultSet));
            }
            return users;
        }catch (SQLException sqlE) {
            throw new SQLException();
        } finally {
            resultSet.close(); //TODO
            statement.close();
            preparedStatement.close();
            connection.close();
        }
    }

    public List<User> getUsersByNickname(String nickname) throws SQLException {

        try {
            List<User> users = new ArrayList<>();

            ConnectionPool connectable = ConnectionPool.getInstance();
            connection = connectable.getConnection();
            statement = connection.createStatement();
            preparedStatement = connection.prepareStatement(GET_USERS);

            InstanceBuilder builder = new InstanceBuilder();
            while (resultSet.next()) {
                users.add(builder.buildUser(resultSet));
            }
            return users;
        }catch (SQLException sqlE) {
            throw new SQLException();
        } finally {
            resultSet.close(); //TODO
            statement.close();
            preparedStatement.close();
            connection.close();
        }
    }

    private final static String GET_FILM_BY_PRODUCTION_YEAR = "SELECT film.id, film.production_year, film.name, film.description, film.film_rating, film.type_id, film_type.type, film_age_rating.age_rating FROM film LEFT JOIN film_type ON film.id=film_type.id LEFT JOIN film_age_rating ON film.id=film_age_rating.id WHERE film.production_year=?;";


}
