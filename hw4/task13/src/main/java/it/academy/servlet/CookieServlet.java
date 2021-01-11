package it.academy.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "cookieServlet", urlPatterns = "/task13")
public class CookieServlet extends HttpServlet {

    int numberOfVisits = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int k = 0;
        PrintWriter writer = resp.getWriter();
        String cookieName = "firstCookie";
        String cookieValue = "1";

        Cookie[] cookies = req.getCookies();

        if (cookies != null) {
            numberOfVisits = cookies.length;
        } else {
            numberOfVisits = 0;
        }

        for (int i = 0; i < numberOfVisits; i++) {

            Cookie cookie = cookies[i];

            if (cookieName.equals(cookie.getName())) {
                k = 1;
                break;
            }
        }

        if (k == 0) {
            Cookie newCookie = new Cookie(cookieName, cookieValue);
            newCookie.setMaxAge(24 * 60 * 60);
            resp.addCookie(newCookie);
            numberOfVisits++;
        }

        writer.println("Visits: " + numberOfVisits);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
