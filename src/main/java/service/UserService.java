package service;

import model.User;
import repository.UserRepository;

import java.util.Optional;

public class UserService {
    private final UserRepository userRepository = new UserRepository();

    public void save(User user){
        userRepository.addUser(user);
    }
    public Optional<User> findByUserName(String userName){
       return userRepository.findByUserName(userName);
    }
}
