package app.servlet;

import app.dao.AccountDAO;
import app.dao.RoleDAO;
import app.entity.Account;
import app.util.Constant;
import app.util.ErrorMessage;
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

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email").trim();
        String password = request.getParameter("password").trim();
        String confirmPassword = request.getParameter("confirmPassword").trim();
        String name = request.getParameter("name").trim();
        ErrorMessage errorObj = new ErrorMessage();
        AccountDAO accountDAO = new AccountDAO();
        RoleDAO roleDAO = new RoleDAO();

        if (!confirmPassword.equals(password)) {
            errorObj.setPasswordNotMatch(Constant.PASSWORD_NON_MATCH);
        }

        if (accountDAO.isExistedAccount(email)) {
            errorObj.setMailExisted(Constant.EMAIL_EXISTED);
        }

        try {
            if (!errorObj.hasError()) {
                Account account = new Account(email, PasswordEncryption.encrypt(password), name);
                account.setRole(roleDAO.getDefaultRole());
                account.setStatus(Constant.DEFAULT_ACCOUNT_STATUS);
                accountDAO.saveAccount(account);
                request.setAttribute("isSuccess", true);
            } else {
                request.setAttribute("errorObj", errorObj);
                request.setAttribute("registerEmail", email);
                request.setAttribute("registerName", name);
            }
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException error) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, error);
        }

        request.getRequestDispatcher(LOGIN_PAGE).forward(request, response);
    }
}
