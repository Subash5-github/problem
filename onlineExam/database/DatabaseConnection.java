package onlineExam.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection;

    private DatabaseConnection() { }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/onlineexam","postgres", "1234");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
    }

