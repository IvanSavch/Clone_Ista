package servlet;

import model.User;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/Registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");

        if (name == null || userName == null || password == null
                || name.equals("") || userName.equals("") || password.equals("")) {
            req.setAttribute("message", "All fields are required");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/pages/Registration.jsp");
            dispatcher.forward(req, resp);
        } else if (userService.findByUserName(userName).isEmpty()) {
            User user = new User(name, userName, password);
            userService.save(user);
            resp.sendRedirect("/");
        } else {
            req.setAttribute("message", "This user already exists");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/pages/Home.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
