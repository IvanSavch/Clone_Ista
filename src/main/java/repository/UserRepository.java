package repository;

import model.User;

import java.sql.*;
import java.util.Optional;

public class UserRepository {

    public void addUser(User user) {
        try {
            Connection connection = ConnectionImpl.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("insert into user_tb values (default,?,?,?)");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getUserName());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<User> findByUserName(String userNa) {
        try {
            Connection connection = ConnectionImpl.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("select * from user_tb u where u.user_name = ?");
            preparedStatement.setString(1, userNa);

            ResultSet resultSet = preparedStatement.executeQuery();
            Optional<User> user = Optional.empty();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String userN = resultSet.getString(3);
                String password = resultSet.getString(4);
                user = Optional.of(new User((long) id, name, userN, password));
            }

            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
