package servlet;

import model.Post;
import model.User;
import service.ImageUtil;
import service.PostService;
import service.SubscriptionService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    private final UserService userService = new UserService();
    private final PostService postService = new PostService();
    private final SubscriptionService subscriptionService = new SubscriptionService();
    private final ImageUtil util = new ImageUtil();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userService.getCurrentUser(req);
        user.setProfilePhoto(userService.getUserPhotoByUserId(user.getId()));
        user.setPosts(postService.getPostByUserId(user));
        user.setSubscriptions(subscriptionService.getSubscriptions(user));

        if (user.getProfilePhoto() != null) {
            String profilePhoto = util.convertToBase64(user.getProfilePhoto());
            req.setAttribute("profilePhoto", profilePhoto);
        }

            req.setAttribute("user", user);


        getServletContext().getRequestDispatcher("/pages/Profile.jsp").forward(req, resp);
    }
}
