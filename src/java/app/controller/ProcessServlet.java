package app.controller;

import app.entity.Account;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProcessServlet", urlPatterns = {"/ProcessServlet"})
public class ProcessServlet extends HttpServlet {

    private final String LOGIN_ACTION = "login";
    private final String LOGOUT_ACTION = "logout";
    private final String REGISTER_ACTION = "register";
//    private final String GET_ARTICLE_ACTION = "getArticles";
    private final String GET_ARTICLE_DETAILS_ACTION = "getArticleDetails";
    private final String POST_COMMENT_ACTION = "postComment";
    private final String DELETE_COMMENT_ACTION = "deleteComment";
    private final String MAKE_EMOTION_ACTION = "makeEmotion";
    private final String SEARCH_ACTION = "search";

    private final String LOGIN_SERVLET = "LoginServlet";
    private final String LOGOUT_SERVLET = "LogoutServlet";
    private final String REGISTER_SERVLET = "RegisterServlet";
    private final String HOME_SERVLET = "HomeServlet";
//    private final String ARTICLE_SERVLET = "ArticleServlet";
    private final String ARTICLE_DETAILS_SERVLET = "ArticleDetailsServlet";
    private final String COMMENT_SERVLET = "CommentServlet";
    private final String DELETE_COMMENT_SERVLET = "DeletionCommentServlet";
    private final String EMOTION_SERVLET = "EmotionServlet";
    private final String SEARCH_SERVLET = "SearchServlet";

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Account user = (Account) request.getSession().getAttribute("USER");
        String action = request.getParameter("action");
        String url;

        if (action == null) {
            action = "";
        }

        if (!(action.isEmpty() || action.equals(LOGIN_ACTION) || action.equals(REGISTER_ACTION)) && user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        switch (action) {
            case MAKE_EMOTION_ACTION: {
                url = EMOTION_SERVLET;
            }
            break;

            case LOGIN_ACTION: {
                url = LOGIN_SERVLET;
            }
            break;

            case LOGOUT_ACTION: {
                url = LOGOUT_SERVLET;
            }
            break;

            case REGISTER_ACTION: {
                url = REGISTER_SERVLET;
            }
            break;

            case GET_ARTICLE_DETAILS_ACTION: {
                url = ARTICLE_DETAILS_SERVLET;
            }
            break;

            case POST_COMMENT_ACTION: {
                url = COMMENT_SERVLET;
            }
            break;

            case DELETE_COMMENT_ACTION: {
                url = DELETE_COMMENT_SERVLET;
            }
            break;

            case SEARCH_ACTION: {
                url = SEARCH_SERVLET;
            }
            break;

            default:
                url = HOME_SERVLET;
        }

        request.getRequestDispatcher(url).forward(request, response);
    }
}
