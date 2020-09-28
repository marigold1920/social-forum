package app.servlet;

import app.dao.ArticleDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "HomeServlet", urlPatterns = { "/HomeServlet" })
public class HomeServlet extends HttpServlet {
    
    private final String HOME_PAGE = "index.jsp";

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArticleDAO articleDAO = new ArticleDAO();
        
        request.getSession().setAttribute("articles", articleDAO.findAllAndPaging(1));
        response.sendRedirect(HOME_PAGE);
    }
}
