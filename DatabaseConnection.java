
/**import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static DatabaseConnection instance;
    private Connection connection;

    private final String URL = "jdbc:mysql://54.226.252.121:3306/testdb";
    private final String USER = "root";
    private final String PASSWORD = "password";

    private DatabaseConnection() {
        try {
            connection = DriverManager.getConnection(db_URL, USER, PASSWORD);
            System.out.println("Database connected successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Database connection failed!");
        }
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
**/

import javax.swing.*;
import java.sql.*;

public class DatabaseConnection {

    private static final String DB_URL = "jdbc:mysql://54.226.252.121:3306/testdb";
    private static final String DB_USER = "newuser";
    private static final String DB_PASSWORD = "password";
    private static DatabaseConnection instance;
    private Connection connection;

    private DatabaseConnection() {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to connect to the database.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
//This is a test comment
    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
