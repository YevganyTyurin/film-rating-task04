package by.epam.film.rating.task04.dao;

import by.epam.film.rating.task04.dao.entity.User;

import java.util.List;

public interface UserDAO {
    List<User> searchByRating(double rating);
}
