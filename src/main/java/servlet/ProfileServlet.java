package servlet;

import model.Post;
import model.User;
import service.ImageUtil;
import service.PostService;
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
    private final ImageUtil util = new ImageUtil();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userService.getCurrentUser(req);
        user.setProfilePhoto(userService.getUserPhotoByUserId(user.getId()));
        user.setPosts(postService.getPostByUserId(user));

        if (user.getProfilePhoto() != null){
            String profilePhoto = util.convertToBase64(user.getProfilePhoto());
            req.setAttribute("profilePhoto",profilePhoto);
        }
        // TODO: 22.03.2025 отобразить пост и создать поиск поста через user id
        if (user.getPosts() != null) {
            List<String> postPicture = new ArrayList<>();
            for (Post post:user.getPosts()) {
                postPicture.add(util.convertToBase64(post.getPicture()));
            }
            req.setAttribute("postPicture",postPicture);
            req.setAttribute("posts", user.getPosts());
        }

        getServletContext().getRequestDispatcher("/pages/Profile.jsp").forward(req, resp);
    }
}
