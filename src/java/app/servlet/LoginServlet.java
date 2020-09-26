package app.servlet;

import app.dao.AccountDAO;
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

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    private final String HOME_PAGE = "index.jsp";
    private final String LOGIN_PAGE = "login.jsp";

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email").trim();
        String password = request.getParameter("password").trim();
        AccountDAO accountDAO = new AccountDAO();

        try {
            Account account = accountDAO.findAccountByEmailAndPassword(email, PasswordEncryption.encrypt(password));
            if (account != null) {
                request.getSession().setAttribute("USER", account);
                response.sendRedirect(HOME_PAGE);
            } else {
                request.setAttribute("errorMessage", Constant.LOGIN_FAIL);
                request.setAttribute("email", email);
                request.getRequestDispatcher(LOGIN_PAGE).forward(request, response);
            }
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException error) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, "Fail to encrypt the password!", error);
        }
    }
}
