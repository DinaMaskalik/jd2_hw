package it.academy.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "newServlet", urlPatterns = "/task8")
public class NewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            final PrintWriter writer = resp.getWriter();
            writer.println("Hello from servlet! " + new Date());
            System.out.println("Hello from servlet! " + new Date());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
