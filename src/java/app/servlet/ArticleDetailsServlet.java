package app.servlet;

import app.dao.ArticleDAO;
import app.dao.CommentDAO;
import app.dao.EmotionDAO;
import app.dto.ArticleDetailsDTO;
import app.entity.Account;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ArticleDetailsServlet", urlPatterns = {"/ArticleDetailsServlet"})
public class ArticleDetailsServlet extends HttpServlet {

    private final String DETAILS_PAGE = "details.jsp";

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Account user = (Account) request.getSession().getAttribute("USER");
        int articleId = Integer.parseInt(request.getParameter("articleId"));
        ArticleDAO articleDAO = new ArticleDAO();
        CommentDAO articleInteractionDAO = new CommentDAO();
        EmotionDAO emotionDAO = new EmotionDAO();
        ArticleDetailsDTO article = articleDAO.getArticleDetails(articleId, user.getEmail());
        
        article.setLikeNumber(emotionDAO.countLike(articleId));
        article.setDislikeNumber(emotionDAO.countDislike(articleId));

        request.setAttribute("article", article);
        request.setAttribute("comments", articleInteractionDAO.getComments(articleId));
        request.setAttribute("isLiked", emotionDAO.isLiked(user.getEmail(), articleId));
        request.setAttribute("isDisliked", emotionDAO.isDisliked(user.getEmail(), articleId));
        request.getRequestDispatcher(DETAILS_PAGE).forward(request, response);
    }
}
