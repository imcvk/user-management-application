package controller;

import dao.UserDAO;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteServlet", value = "/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("currentUser");
        int i = UserDAO.deleteUser(u.getUserid());
        RequestDispatcher dispatcher = null;
        if (i == 1) {
            session.invalidate();
            response.sendRedirect("index.jsp");
            session.setAttribute("errorMsg", "User deleted.");
        } else {
            request.setAttribute("errorMsg", "Delete profile failed...Please try after sometime.");
            dispatcher = request.getRequestDispatcher("profile.jsp");
            dispatcher.forward(request, response);
        }

    }
}
