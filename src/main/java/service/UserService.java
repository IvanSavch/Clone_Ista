package service;

import model.User;
import storage.UserStorage;

public class UserService {
    private final UserStorage userStorage = new UserStorage();

    public void save(User user){
        userStorage.addUser(user);
    }
}
