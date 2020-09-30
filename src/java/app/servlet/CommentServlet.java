package app.servlet;

import app.dao.CommentDAO;
import app.dao.NotificationDAO;
import app.entity.Account;
import app.entity.Article;
import app.entity.Comment;
import app.entity.Notification;
import app.util.Constant;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CommentServlet", urlPatterns = {"/CommentServlet"})
public class CommentServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Account user = (Account) request.getSession().getAttribute("USER");
        int articleId = Integer.parseInt(request.getParameter("articleId"));
        String comment = request.getParameter("comment").trim();
        String owner = request.getParameter("owner");
        String path = "ProcessServlet?action=getArticleDetails&aritcleId=" + articleId;
        Article article = Article.builder().articleId(articleId).build();
        CommentDAO commentDAO = new CommentDAO();
        NotificationDAO notificationDAO = new NotificationDAO();

        commentDAO.saveComment(new Comment(comment, user, article));
        if (!user.getEmail().equals(owner)) {
            notificationDAO.saveNotification(
                    Notification.builder()
                            .content(String.format("%s%s\n%s", user.getName(), Constant.COMMENT_NOTIFICATION, comment))
                            .owner(user)
                            .article(article)
                            .isRead(false)
                            .build()
            );
        }

        request.getRequestDispatcher(path).forward(request, response);
    }
}
