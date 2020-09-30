package app.servlet;

import app.dao.EmotionDAO;
import app.dao.NotificationDAO;
import app.entity.Account;
import app.entity.Article;
import app.entity.Emotion;
import app.entity.Notification;
import app.util.Constant;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EmotionServlet", urlPatterns = {"/EmotionServlet"})
public class EmotionServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Account user = (Account) request.getSession().getAttribute("USER");
        int articleId = Integer.parseInt(request.getParameter("articleId"));
        boolean isLike = Boolean.parseBoolean(request.getParameter("isLike"));
        boolean isDislike = Boolean.parseBoolean(request.getParameter("isDislike"));
        String owner = request.getParameter("owner");
        String path = "ProcessServlet?action=getArticleDetails&aritcleId=" + articleId;
        Article article = Article.builder().articleId(articleId).build();
        EmotionDAO emotionDAO = new EmotionDAO();
        NotificationDAO notificationDAO = new NotificationDAO();
        Emotion emotion = emotionDAO.findByEmailAndArticleId(user.getEmail(), articleId);

        if (!user.getEmail().equals(owner)) {
            Notification notification = Notification.builder()
                    .owner(user)
                    .article(article)
                    .isRead(false)
                    .build();

            if (isLike) {
                notification.setContent(user.getName() + Constant.LIKE_NOTIFICATION);
                notificationDAO.saveNotification(notification);
            }

            if (isDislike) {
                notification.setContent(user.getName() + Constant.DISLIKE_NOTIFICATION);
                notificationDAO.saveNotification(notification);
            }
        }

        if (emotion != null) {
            emotion.setLike(isLike);
            emotion.setDislike(isDislike);
            emotionDAO.updateEmotion(emotion);
        } else {
            emotion = new Emotion(isLike, isDislike, user, article);

            emotionDAO.saveEmotion(emotion);
        }

        request.getRequestDispatcher(path).forward(request, response);
    }
}
