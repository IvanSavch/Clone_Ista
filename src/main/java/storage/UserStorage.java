package storage;

import model.User;

import java.sql.*;

public class UserStorage {
    public void addUser(User user) {
        try {
            Connection connection =
                    DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","root");
            PreparedStatement preparedStatement = connection.prepareStatement("insert into 'Account' values (default,?,?,?)");
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getUserName());
            preparedStatement.setString(3,user.getPassword());
            preparedStatement.execute();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
