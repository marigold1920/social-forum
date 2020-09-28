package app.servlet;

import app.dao.ArticleDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SearchServlet", urlPatterns = {"/SearchServlet"})
public class SearchServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = request.getParameter("keyword").trim();
        HttpSession session = request.getSession();
        ArticleDAO articleDAO = new ArticleDAO();
        
        session.setAttribute("keyword", keyword);
        session.setAttribute("articles", articleDAO.searchByContentAndPaging(keyword, 1));

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
