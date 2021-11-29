package by.epam.film.rating.task04.dao;

import by.epam.film.rating.task04.dao.db.ConnectionPoolFactory;

public class DAOFactory {
    private final static DAOFactory instance = new DAOFactory();
    private final UserDAO userDAO = new UserDAOImpl();


    private DAOFactory(){
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public static DAOFactory getInstance() {
        return instance;
    }
}
