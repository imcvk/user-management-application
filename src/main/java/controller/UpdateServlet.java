package controller;

import dao.UserDAO;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "UpdateServlet", value = "/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {

            String nameUpdate = request.getParameter("name");
            String emailAddressUpdate = request.getParameter("email");
            String phoneNumberUpdate = request.getParameter("phoneNumber");
            String addressUpdate = request.getParameter("address");
            String genderUpdate = request.getParameter("gender");
            String DOBStringUpdate = request.getParameter("birthday");
            int currentUserId = Integer.parseInt(request.getParameter("userid"));
            Date DOB = null;
            RequestDispatcher dispatcher;
            String password = request.getParameter("password");
            try {
                DOB = new SimpleDateFormat("yyyy-MM-dd").parse(DOBStringUpdate);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            User u = new User();
            u.setUserid(currentUserId);
            u.setName(nameUpdate);
            u.setDOB(DOB);
            u.setGender(genderUpdate);
            u.setAddress(addressUpdate);
            u.setPhoneNumber(phoneNumberUpdate);
            u.setEmailAddress(emailAddressUpdate);
            u.setPassword(password);

            if (UserDAO.updateUser(u) == 1) {
                request.setAttribute("currentUser", u);
                request.setAttribute("updateMsg",
                        "User updated successfully..Please logout and login again to check updated.");
                dispatcher = request.getRequestDispatcher("profile.jsp");
                dispatcher.forward(request, response);
            } else {
                request.setAttribute("errorMsg", "Update Failed,Please try again");
            }
        }
    }
}
