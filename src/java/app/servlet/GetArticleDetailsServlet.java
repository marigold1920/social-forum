package app.servlet;

import app.dao.ArticleDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "GetArticleDetailsServlet", urlPatterns = {"/GetArticleDetailsServlet"})
public class GetArticleDetailsServlet extends HttpServlet{
    
    private final String DETAILS_PAGE = "details.jsp";

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int articleId = Integer.parseInt(request.getParameter("articleId"));
        ArticleDAO articleDAO = new ArticleDAO();
        
        request.setAttribute("article", articleDAO.getArticleDetails(articleId));
        request.getRequestDispatcher(DETAILS_PAGE).forward(request, response);
    }
}
