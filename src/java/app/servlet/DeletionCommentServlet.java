package app.servlet;

import app.dao.CommentDAO;
import app.entity.Account;
import app.entity.Article;
import app.entity.Comment;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DeletionCommentServlet", urlPatterns = {"/DeletionCommentServlet"})
public class DeletionCommentServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Account account = (Account) request.getSession().getAttribute("USER");
        int commentId = Integer.parseInt(request.getParameter("commentId"));
        int articleId = Integer.parseInt(request.getParameter("articleId").trim());
        String path = "ProcessServlet?action=getArticleDetails&aritcleId=" + articleId;
        CommentDAO commentDAO = new CommentDAO();
        
        commentDAO.removeComment(new Comment(commentId, account, Article.builder().articleId(articleId).build()));
        request.getRequestDispatcher(path).forward(request, response);
    }
}
