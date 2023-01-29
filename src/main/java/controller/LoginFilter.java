package controller;

import dao.UserDAO;
import model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter", urlPatterns = {"/AllUserServlet", "/DeleteServlet", "/LogoutServlet", "/UpdateServlet",
        "/userMenu.jsp",})
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        System.out.println("LOGIN FILTER INVOKED...");
    }

    public void destroy() {
        System.out.println("LOGIN FILTER DESTROYED...");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpSession session = ((HttpServletRequest) request).getSession(false);
        Object o = session.getAttribute("currentUser");
        RequestDispatcher dispatcher = null;
        if (o != null) {
            User u = (User) o;
            if (UserDAO.validateUser(u) != null) {
                chain.doFilter(request, response);
            }
        } else {
            request.setAttribute("errorMsg", "Invalid Username or password...");
            dispatcher = request.getRequestDispatcher("index.jsp");
        }
    }
}
