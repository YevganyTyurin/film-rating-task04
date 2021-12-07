package by.epam.film.rating.task04.dao;

import by.epam.film.rating.task04.dao.entity.user.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    List<User> searchByNickname(String nickname) throws SQLException;
}
