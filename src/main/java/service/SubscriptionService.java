package service;

import model.User;
import repository.SubscriptionRepository;
import repository.SubscriptionRepositoryImpl;

import java.util.List;

public class SubscriptionService {
    private final SubscriptionRepository subscriptionRepository = new SubscriptionRepositoryImpl();
    public void addSubscription(String userName,long userId){
        subscriptionRepository.addSubscription(userName,userId);
    }
    public List<String> getSubscriptions(User user){
        return subscriptionRepository.getSubscriptions(user);
    }
    public void deleteSubscription(String userName){
        subscriptionRepository.deleteSubscription(userName);
    }
}
