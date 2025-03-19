package servlet;

import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private final UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/Login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");

        if (userService.findByUserName(userName).isEmpty()){
            req.setAttribute("message","wrong user name or password");
            getServletContext().getRequestDispatcher("/pages/Login.jsp").forward(req,resp);
        } else {
            User user = userService.findByUserName(userName).get();
            if (user.getPassword().equals(password)){
                req.getSession().setAttribute("user",user);
                resp.sendRedirect("/profile");
            }else {
                req.setAttribute("message","wrong user name or password");
                getServletContext().getRequestDispatcher("/pages/Login.jsp").forward(req,resp);
            }
        }
    }
}
