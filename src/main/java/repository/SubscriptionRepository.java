package repository;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubscriptionRepository {
    public void addSubscription(String userName,long userId) {
        Connection connection = ConnectionImpl.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into subscriptions_tb values (default,?,?)");
            preparedStatement.setString(1,userName);
            preparedStatement.setLong(2,userId);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<String> getSubscriptions(User user) {
        Connection connection = ConnectionImpl.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select user_name from subscriptions_tb where user_id = ?");
            preparedStatement.setLong(1,user.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            List<String> userNameList = new ArrayList<>();
            while (resultSet.next()){
                String userName = resultSet.getString(1);
                userNameList.add(userName);
            }
            return userNameList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteSubscription(String userName){
        Connection connection = ConnectionImpl.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from subscriptions_tb where user_name = ?");
            preparedStatement.setString(1,userName);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
