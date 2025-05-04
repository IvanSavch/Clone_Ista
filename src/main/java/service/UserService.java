package service;

import model.User;
import repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

public class UserService {
    private final UserRepository userRepository = new UserRepository();

    public void save(User user) {
        userRepository.addUser(user);
    }

    public Optional<User> findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    public User getCurrentUser(HttpServletRequest request) {
        HttpSession session = request.getSession();

        return (User) session.getAttribute("user");
    }

    public void updateAvatar(byte[] imagePhoto, User user) {
        user.setProfilePhoto(imagePhoto);
        userRepository.uploadProfilePicture(user);
    }

    public byte[] getUserPhotoByUserId(Long id) {
        return userRepository.getPhotoByUserId(id);
    }

}
