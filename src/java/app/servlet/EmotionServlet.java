package app.servlet;

import app.dao.EmotionDAO;
import app.entity.Account;
import app.entity.Article;
import app.entity.Emotion;
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
        String path = "ProcessServlet?action=getArticleDetails&aritcleId=" + articleId;
        EmotionDAO emotionDAO = new EmotionDAO();
        Emotion emotion = emotionDAO.findByEmailAndArticleId(user.getEmail(), articleId) ;
        
        if (emotion != null) {
            emotion.setDislike(!isLike);
            emotion.setLike(isLike);
            emotionDAO.updateEmotion(emotion);
        } else {
            emotion = new Emotion(isLike, !isLike, user, new Article(articleId));
 
            emotionDAO.saveEmotion(emotion);
        }
        
        request.getRequestDispatcher(path).forward(request, response);
    }
}
