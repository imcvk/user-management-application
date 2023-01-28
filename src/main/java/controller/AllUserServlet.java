package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AllUserServlet", value = "/AllUserServlet")
public class AllUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        RequestDispatcher dispatcher = null;
        if (session != null) {
            dispatcher = request.getRequestDispatcher("allUsers.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("errorMsg", "Please try again");
        }
    }

}
