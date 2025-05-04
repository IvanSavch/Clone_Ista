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
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/userPage")
public class UserPageServlet extends HttpServlet {
    private final PostService postService = new PostService();
    private final UserService userService = new UserService();
    private final ImageUtil util = new ImageUtil();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        Optional<User> byUserName = userService.findByUserName(userName);
        if (byUserName.isEmpty()) {
            req.setAttribute("notFound","user not found");
        }else {
            User user = byUserName.get();
            user.setProfilePhoto(userService.getUserPhotoByUserId(user.getId()));
            user.setPosts(postService.getPostByUserId(user));
            String userPicture = util.convertToBase64(user.getProfilePhoto());
            req.setAttribute("users",user.getPosts());
            req.setAttribute("userPicture",userPicture);
        }
        getServletContext().getRequestDispatcher("/pages/UserPage.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
