package repository;

import model.User;

import java.util.Optional;

public interface UserRepository {
    void addUser(User user);

    Optional<User> getUserById(Long id);

    Optional<User> findByUserName(String userName);

    void uploadProfilePicture(User user);

    byte[] getPhotoByUserId(long id);
}
