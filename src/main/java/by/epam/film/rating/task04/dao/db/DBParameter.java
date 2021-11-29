package by.epam.film.rating.task04.dao.db;

public final class DBParameter {
    private DBParameter() {};

    public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/filmRating";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "ETmysql21@";
    public static final int DB_POOL_SIZE = 2;

}
