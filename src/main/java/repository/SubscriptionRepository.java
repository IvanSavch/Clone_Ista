package repository;

import model.User;

import java.util.List;

public interface SubscriptionRepository {
    void addSubscription(String userName,long userId);
    List<String> getSubscriptions(User user);
    void deleteSubscription(String userName);
}
