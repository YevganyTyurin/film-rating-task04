package by.epam.film.rating.task04.dao.db;

import java.sql.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class ConnectionPool {
    private String databaseURL;
    private String userName;
    private String password;
    private int poolSize;
    private int connectionNumber;
    private BlockingQueue<Connection> freePool;
    private BlockingQueue<Connection> occupiedPool;

    private ConnectionPool() {
        this.freePool = new ArrayBlockingQueue<>(DBParameter.DB_POOL_SIZE);
        this.occupiedPool = new ArrayBlockingQueue<>(DBParameter.DB_POOL_SIZE);
        this.databaseURL = DBParameter.DB_URL;
        this.userName = DBParameter.DB_USER;
        this.password = DBParameter.DB_PASSWORD;
        this.poolSize = DBParameter.DB_POOL_SIZE;

        initFreePool();
    }

    private static class ConnectionPoolHolder {
        public static final ConnectionPool INSTANCE = new ConnectionPool();
    }

    public static ConnectionPool getInstance() {
        return ConnectionPoolHolder.INSTANCE;
    }

    public Connection getConnection() throws SQLException, InterruptedException {
        Lock lock = new ReentrantLock();
        Connection connection = null;
        lock.lock();
        try{
            connection = freePool.poll(1500, TimeUnit.MILLISECONDS);
            if(connection != null) {
                occupiedPool.add(connection);
                connectionNumber++;
                return connection;
            } else {
                throw new SQLException("Connection pool is full");
            }
        } finally {
            lock.unlock();
        }
    }

    private void initFreePool() {
        try {
            for (int i = 0; i < poolSize; i++) {
                freePool.add(createConnection());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean releaseConnection(Connection connection) throws SQLException {
        Lock lock = new ReentrantLock();
        lock.lock();
        try{
            if(connection == null) {
                throw new NullPointerException();
            }
            if(!occupiedPool.remove(connection)) {
                throw new SQLException("The connection is returned already");
            }
            connectionNumber--;
            return freePool.add(connection);
        } finally {
            lock.unlock();
        }
    }

    private Connection createConnection() throws SQLException {
        Connection connection = null;
        connection = DriverManager.getConnection(databaseURL,userName,password);
        connection.setAutoCommit(true);
        return connection;
    }

    public void closeConnection (Connection connection, ResultSet resultSet, Statement statement) {
        try {
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnectionQueue() throws SQLException {
        Connection connection = null;

        for (Connection occupiedConnection : occupiedPool) {
            releaseConnection(occupiedConnection);
        }
        while ((connection = freePool.poll()) != null) {
            if(!connection.getAutoCommit()) {
                connection.commit();
            }
            connection.close();
        }
    }

}

