package servlet;

import model.User;
import service.ImageUtil;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    private final UserService userService = new UserService();
    private final ImageUtil util = new ImageUtil();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userService.getCurrentUser(req);

        if (user.getProfilePhoto() != null){
            String profilePhoto = util.convertToBase64(user.getProfilePhoto());
            req.setAttribute("photo",profilePhoto);
        }
        getServletContext().getRequestDispatcher("/pages/Profile.jsp").forward(req, resp);
    }
}
