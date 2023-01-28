package controller;

import dao.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

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
