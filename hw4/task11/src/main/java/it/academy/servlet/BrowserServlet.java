package it.academy.servlet;

import eu.bitwalker.useragentutils.UserAgent;
import it.academy.parsing.ParsingHeader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "BrowserServlet", urlPatterns = "/task11")
public class BrowserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("windows-1251");

        PrintWriter writer = resp.getWriter();
        UserAgent userAgent = UserAgent.parseUserAgentString(req.getHeader("User-Agent"));

        ParsingHeader header = new ParsingHeader();
        writer.println("Приветствую пользователя " + header.getBrowser(userAgent.toString()));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
