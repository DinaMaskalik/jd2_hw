package com.doctorsweb.controllers;

import com.doctorsweb.database.Repository;
import com.doctorsweb.database.UserRepositoryImpl;
import com.doctorsweb.entities.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static java.util.Objects.nonNull;

public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest req = (HttpServletRequest) servletRequest;
        final HttpServletResponse resp = (HttpServletResponse) servletResponse;
        try
        {
            final String login = req.getParameter("login");
            final String password = req.getParameter("password");

            final HttpSession session = req.getSession();
            Repository repository = new UserRepositoryImpl();
            if (nonNull(session) && nonNull(session.getAttribute("login")) &&
                    nonNull(session.getAttribute("password")))
            {
                final User.ROLE role = (User.ROLE) session.getAttribute("role");
                moveToMenu(req, resp, role);
            }
            else {
                User user = (User) repository.findByCredentials(login, password);
                if (!user.getLogin().equals("")) {

                    final User.ROLE role = user.getRole();
                    req.getSession().setAttribute("password", password);
                    req.getSession().setAttribute("login", login);
                    req.getSession().setAttribute("role", role);
                    moveToMenu(req, resp, role);

                } else {
                    moveToMenu(req, resp, User.ROLE.UNKNOWN);
                }
        }
        } catch (Exception throwables) {
            resp.sendRedirect("/");
        }
    }

    /**
     * Move user to menu.
     * If access 'admin' move to admin menu.
     * If access 'user' move to user menu.
     */
    private void moveToMenu(final HttpServletRequest req,
                            final HttpServletResponse res,
                            final User.ROLE role)
            throws ServletException, IOException {


        if (role.equals(User.ROLE.ADMIN)|| role.equals(User.ROLE.USER)) {

            res.sendRedirect("/main.jsp");

        } else {

            req.getRequestDispatcher("/register.jsp").forward(req, res);
        }
    }

    @Override
    public void destroy() {

    }
}
