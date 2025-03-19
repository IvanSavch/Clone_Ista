package servlet;

import model.User;
import service.ImageUtil;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet("/uploadPicture")
@MultipartConfig()
public class UploadProfilePictureServlet extends HttpServlet {
    private final UserService userService = new UserService();
    private final ImageUtil util = new ImageUtil();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/UploadPicture.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userService.getCurrentUser(req);
        Part photo = req.getPart("photo");

        byte[] bytePhoto = util.convertToByteArray(photo.getInputStream());
        userService.updateAvatar(bytePhoto, user);
        resp.sendRedirect("/profile");
    }
}
