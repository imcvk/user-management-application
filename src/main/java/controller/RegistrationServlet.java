package controller;

import dao.UserDAO;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "RegistrationServlet", value = "/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String emailAddress = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String address = request.getParameter("address");
        String password = request.getParameter("password");
        String passwordConfirm = request.getParameter("passwordConfirm");
        String gender = request.getParameter("gender");
        String DOBString = request.getParameter("birthday");
        Date DOB = null;
        RequestDispatcher dispatcher;
        try {
            DOB = new SimpleDateFormat("yyyy-MM-dd").parse(DOBString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        User u = new User(UserDAO.generateRandomUserId(), name, emailAddress, phoneNumber, address, password, DOB, gender);
        if (password.equals(passwordConfirm)) {
            try {
                if (UserDAO.createUser(u) == 1) {
                    request.setAttribute("currentUser", u);
                    dispatcher = request.getRequestDispatcher("profile.jsp");
                    dispatcher.forward(request, response);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            request.setAttribute("error", "Entered password and confirm password does not match...");
        }
    }
}
