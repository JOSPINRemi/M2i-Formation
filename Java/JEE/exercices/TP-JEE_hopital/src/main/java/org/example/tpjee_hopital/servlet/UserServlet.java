package org.example.tpjee_hopital.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.tpjee_hopital.entities.User;
import org.example.tpjee_hopital.services.UserService;

import java.io.IOException;


@WebServlet(name = "user", value = "/user")
public class UserServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("logged") != null || session.getAttribute("logged").equals(false)) {
            session.removeAttribute("logged");
            session.removeAttribute("username");
        }
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String username = req.getParameter("username");

        if (email != null && password != null && username != null) {
            User user1 = new User();
            user1.setEmail(email);
            user1.setUsername(username);
            user1.setPassword(password);
            if (userService.createOrUpdate(user1)) {
                resp.sendRedirect("login.jsp");
            } else {
                resp.sendRedirect("register.jsp");
            }

        } else if (email != null && password != null) {
            User user2 = new User();
            user2.setEmail(email);
            user2.setPassword(password);
            User user3 = userService.findByEmailAndPassword(user2);
            if (user3 != null) {
                HttpSession session = req.getSession();
                session.setAttribute("logged", true);
                session.setAttribute("username", user3.getUsername());
                resp.sendRedirect("list");
            } else {
                HttpSession session = req.getSession();
                session.setAttribute("loginError", "Identifiants invalides.");
                resp.sendRedirect("login.jsp");
            }

        } else {
            resp.sendRedirect("login.jsp");
        }


    }

}
