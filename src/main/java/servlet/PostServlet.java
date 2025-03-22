package servlet;

import model.Post;
import model.User;
import service.ImageUtil;
import service.PostService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet("/post")
@MultipartConfig()
public class PostServlet extends HttpServlet {
    private final PostService postService = new PostService();
    private final UserService userService = new UserService();
    private final ImageUtil util = new ImageUtil();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/Post.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userService.getCurrentUser(req);
        String description = req.getParameter("description");

        Part photo = req.getPart("photo");
        byte[] bytes = util.convertToByteArray(photo.getInputStream());

        Post post = new Post(description,bytes,user);
        postService.addPost(post);
        resp.sendRedirect("/profile");
    }
}
