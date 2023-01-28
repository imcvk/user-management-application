package controller;

import dao.UserDAO;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userid = request.getParameter("userid");
        String password = request.getParameter("password");
        User u = new User();
        u.setPassword(password);
        u.setEmailAddress(userid);
        RequestDispatcher dispatcher;
        HttpSession session;
        User u2 = UserDAO.validateUser(u);
        if (u2 != null) {
            session = request.getSession(true);
            session.setAttribute("currentUser", u2);
            request.setAttribute("currentUser", u2);
            dispatcher = request.getRequestDispatcher("userMenu.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("errorMsg", "Login failed due to incorrect details...");
            dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }
    }
}
