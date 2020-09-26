package app.servlet;

import app.dao.AccountDAO;
import app.dao.RoleDAO;
import app.entity.Account;
import app.util.Constant;
import app.util.PasswordEncryption;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

    private final String LOGIN_PAGE = "login.jsp";
    private final String REGISTER_PAGE = "register.jsp";

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email").trim();
        String password = request.getParameter("password").trim();
        String name = request.getParameter("name").trim();
        AccountDAO accountDAO = new AccountDAO();
        RoleDAO roleDAO = new RoleDAO();

        try {
            if (!accountDAO.isExistedAccount(email)) {
                Account account = new Account(email, PasswordEncryption.encrypt(password), name);
                account.setRole(roleDAO.getDefaultRole());
                account.setStatus(Constant.DEFAULT_ACCOUNT_STATUS);
                accountDAO.saveAccount(account);
                response.sendRedirect(LOGIN_PAGE);
            } else {
                request.setAttribute("errorMessage", Constant.EMAIL_EXISTED);
                request.setAttribute("email", email);
                request.setAttribute("name", name);
                request.getRequestDispatcher(REGISTER_PAGE).forward(request, response);
            }
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException error) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, error);
        }

    }
}
