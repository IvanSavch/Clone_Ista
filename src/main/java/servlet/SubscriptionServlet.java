package servlet;

import model.User;
import service.SubscriptionService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/subscription")
public class SubscriptionServlet extends HomeServlet{
    private final SubscriptionService subscriptionService = new SubscriptionService();
    private final UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        Optional<User> byUserName = userService.findByUserName(userName);
        if (byUserName.isPresent()) {
            User user = byUserName.get();
            req.setAttribute("subscriptions", subscriptionService.getSubscriptions(user));
        }
        getServletContext().getRequestDispatcher("/pages/Subscription.jsp").forward(req,resp);
    }

}
