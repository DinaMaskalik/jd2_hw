package com.doctorsweb.controllers;

import com.doctorsweb.database.Repository;
import com.doctorsweb.database.UserRepositoryImpl;
import com.doctorsweb.entities.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class SignupServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String login = req.getParameter("login");
        final String password = req.getParameter("password");
        final HttpSession session = req.getSession();
        final User.ROLE role;

        if (!login.equals("")&&!password.equals(""))
        {
            Repository repository = new UserRepositoryImpl();
            User user = new User(login, password, User.ROLE.ADMIN);
            try {
                repository.insert(user);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            req.getSession().setAttribute("password", password);
            req.getSession().setAttribute("login", login);
            req.getSession().setAttribute("role", User.ROLE.ADMIN);
        }
        resp.sendRedirect("/main.jsp");
    }
}
