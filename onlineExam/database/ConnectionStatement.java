package onlineExam.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class  ConnectionStatement{

    public static PreparedStatement getPreparedStatement(String query) {
        PreparedStatement statement = null;
        try {
            Connection connection = DatabaseConnection.getConnection();
            statement = connection.prepareStatement(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }
}
