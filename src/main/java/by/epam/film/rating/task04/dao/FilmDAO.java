package by.epam.film.rating.task04.dao;

import java.sql.SQLException;

public interface FilmDAO {
    int addTrailer (int trailerId, String trailerPath, int filmId) throws SQLException;
}
