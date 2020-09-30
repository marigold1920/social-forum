package app.servlet;

import app.dao.ArticleDAO;
import app.entity.Account;
import app.entity.Article;
import app.entity.ArticleStatus;
import app.util.Constant;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CreateArticleServlet", urlPatterns = {"/CreateArticleServlet"})
@MultipartConfig
public class CreateArticleServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Account user = (Account) request.getSession().getAttribute("USER");
        String title = request.getParameter("title").trim();
        String description = request.getParameter("description").trim();
        String content = request.getParameter("content").trim();
        ArticleDAO articleDAO = new ArticleDAO();
        Article article = Article.builder()
                .title(title)
                .description(description)
                .content(content)
                .owner(user)
                .status(ArticleStatus.builder().statusId(Constant.DEFAULT_ARTICLE_STATUS).build())
                .build();

        if (articleDAO.saveArticle(article)) {
            request.setAttribute("success", Constant.CREATE_ARTICLE_SUCCESS);
        } else {
            request.setAttribute("fail", Constant.CREATE_ARTICLE_FAIL);
        }
        
        request.getRequestDispatcher("createArticle.jsp").forward(request, response);
    }
}
