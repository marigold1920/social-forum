package app.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProcessServlet", urlPatterns = {"/ProcessServlet"})
public class ProcessServlet extends HttpServlet {
    private final String LOGIN_ACTION = "login";
    private final String REGISTER_ACTION = "register";
    
    private final String LOGIN_SERVLET = "LoginServlet";
    private final String REGISTER_SERVLET = "RegisterServlet";
    private final String HOME = "HomeServlet";

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String url;
        
        switch(action) {
            case LOGIN_ACTION: {
                url = LOGIN_SERVLET;
            }
            break;
            
            case REGISTER_ACTION: {
                url = REGISTER_SERVLET;
            }
            break;
            
            default: url = HOME;
        }
        
        request.getRequestDispatcher(url).forward(request, response);
    }  
}
