package by.epam.film.rating.task04.dao.db;

public class ConnectionPoolFactory {
    private static ConnectionPoolFactory instance;

    private ConnectionPool connectionPool = new ConnectionPoolImpl();

    private ConnectionPoolFactory(){
    }

    public static ConnectionPoolFactory getInstance() {
        if (instance == null) {
            instance = new ConnectionPoolFactory();
        }
        return instance;
    }

    public ConnectionPool getConnectionPool()  {
        if (instance.connectionPool == null){
            instance.connectionPool = new ConnectionPoolImpl();
        }
        return instance.connectionPool;
    }
}
