package app.servlet;

import app.dao.NotificationDAO;
import app.entity.Account;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "NotificationServlet", urlPatterns = {"/NotificationServlet"})
public class NotificationServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Account user = (Account) request.getSession().getAttribute("USER");
        NotificationDAO notificationDAO = new NotificationDAO();

        request.getSession().setAttribute("notifications", notificationDAO.findAllByEmail(user.getEmail()));
        response.sendRedirect("notification.jsp");
    }
}
