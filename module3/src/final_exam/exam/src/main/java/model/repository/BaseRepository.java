package model.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepository {
    private static final String jdbcUrl = "jdbc:mysql://localhost:3306/benh_an_db?useSSL=false";
    private static final String jdbcUsername = "root";
    private static final String jdbcPassword = "luan12321";

    private static Connection connection;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }
}
