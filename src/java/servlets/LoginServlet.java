package servlets;

import domain.AccountService;
import domain.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        String logout = (String) session.getAttribute("logout");
        
        if (logout != null){
            session.invalidate();
            request.setAttribute("log", "You have successfully logged out");
        }
        
        User user = (User) session.getAttribute("user");
        
        if (user != null){
            response.sendRedirect("/WEB-INF/home.jsp");
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        User user = new User();
        
        AccountService as = new AccountService();
        
        if (username != null && password != null){
            user = as.login(username, password);
        }
        
        if (user != null){
            getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
        } else{
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            request.setAttribute("log", "Invalid");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }
}
