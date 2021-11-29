package by.epam.film.rating.task04.dao.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class ConnectionPoolImpl implements ConnectionPool {
    private String databaseURL;
    private String userName;
    private String password;
    private int poolSize;
    private int connectionNumber;
    private BlockingQueue<Connection> freePool;
    private BlockingQueue<Connection> occupiedPool;

    ConnectionPoolImpl() {
        this.freePool = new ArrayBlockingQueue<>(DBParameter.DB_POOL_SIZE);
        this.occupiedPool = new ArrayBlockingQueue<>(DBParameter.DB_POOL_SIZE);
        this.databaseURL = DBParameter.DB_URL;
        this.userName = DBParameter.DB_USER;
        this.password = DBParameter.DB_PASSWORD;
        this.poolSize = DBParameter.DB_POOL_SIZE;
    }

    @Override
    public Connection getConnection() throws SQLException {
        Lock lock = new ReentrantLock();
        Connection connection = null;
        if(lock.tryLock()) {
            try{
                if(isFull()) {
                    throw new SQLException("Connection pool is full");
                }
                connection = getConnectionFromPool();
                if(connection == null) {
                    connection = createConnectionForPool();
                }
                connection = makeAvailable(connection);
            } finally {
                lock.unlock();
            }
        }
        return connection;
    }

    private boolean isFull() {
        return ((freePool.size() == 0) && (connectionNumber >= poolSize));
    }

    @Override
    public boolean releaseConnection(Connection connection) throws SQLException {
        Lock lock = new ReentrantLock();
        try{
            lock.lock();
            if(connection == null) {
                throw new NullPointerException();
            }
            if(!occupiedPool.remove(connection)) {
                throw new SQLException("The connection is returned already or it isn't for this pool");
            }
            return freePool.add(connection);
        } finally {
            lock.unlock();
        }
    }

    private Connection createConnection() throws SQLException {
        Connection connection = null;
        connection = DriverManager.getConnection(databaseURL,userName,password);
        return connection;
    }

    private Connection createConnectionForPool() throws SQLException{
        Connection connection = createConnection();
        connectionNumber++;
        occupiedPool.add(connection);
        return connection;
    }

    private Connection getConnectionFromPool() {
        Connection connection = null;
        if(freePool.size() > 0) {
            connection = freePool.remove();
            occupiedPool.add(connection);
        }
        return connection;
    }

    private Connection makeAvailable(Connection connection) throws SQLException {
        if(isConnectionAvailable(connection)) {
            return connection;
        }
        occupiedPool.remove(connection);
        connectionNumber--;
        connection.close();

        connection = createConnection();
        occupiedPool.add(connection);
        connectionNumber++;
        return connection;
    }

    private boolean isConnectionAvailable(Connection connection) {
        try (Statement statement = connection.createStatement()){
            statement.executeQuery("select 1");
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

}
