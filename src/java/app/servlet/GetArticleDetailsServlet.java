package app.servlet;

import app.dao.ArticleDAO;
import app.dao.ArticleInteractionDAO;
import app.dto.Comment;
import app.entity.Account;
import java.io.IOException;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "GetArticleDetailsServlet", urlPatterns = {"/GetArticleDetailsServlet"})
public class GetArticleDetailsServlet extends HttpServlet {

    private final String DETAILS_PAGE = "details.jsp";

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int articleId = Integer.parseInt(request.getParameter("articleId"));
        ArticleDAO articleDAO = new ArticleDAO();
        ArticleInteractionDAO articleInteractionDAO = new ArticleInteractionDAO();
        Account user = (Account) request.getSession().getAttribute("USER");
        Collection<Comment> comments = articleInteractionDAO.getComments(articleId);

        boolean isLiked = comments.stream()
                .filter(c -> c.isLike() && c.getEmail().equals(user.getEmail()))
                .findFirst()
                .isPresent();
        boolean isDisliked = comments.stream()
                .filter(c -> c.isDislike() && c.getEmail().equals(user.getEmail()))
                .findFirst()
                .isPresent();

        request.setAttribute("article", articleDAO.getArticleDetails(articleId, user.getEmail()));
        request.setAttribute("comments", articleInteractionDAO.getComments(articleId));
        request.setAttribute("isLiked", isLiked);
        request.setAttribute("isDisliked", isDisliked);
        request.getRequestDispatcher(DETAILS_PAGE).forward(request, response);
    }
}
