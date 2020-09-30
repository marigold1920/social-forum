package app.servlet;

import app.dao.ArticleDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "HomeServlet", urlPatterns = { "/HomeServlet" })
public class HomeServlet extends HttpServlet {
    
    private final String HOME_PAGE = "index.jsp";

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArticleDAO articleDAO = new ArticleDAO();
        String page = request.getParameter("page");
        int pageNumber = page != null ? Integer.parseInt(page) : 1;
        String keyword = request.getParameter("keyword");
        HttpSession session = request.getSession();
        
        keyword = keyword == null ? "" : keyword.trim();
        session.setAttribute("articles", articleDAO.findAllAndPaging(keyword, pageNumber));
        session.setAttribute("totalPage", articleDAO.getTotalPage(keyword));
        session.setAttribute("currentPage", page != null ? page : 1);
        session.setAttribute("keyword", keyword);
        
        response.sendRedirect(HOME_PAGE);
    }
}
