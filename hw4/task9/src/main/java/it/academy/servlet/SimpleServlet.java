package it.academy.servlet;

import it.academy.file.WorkWithFile;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(name = "simpleServlet", urlPatterns = "/task9")
public class SimpleServlet extends HttpServlet {

    int numberOfVisits = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        WorkWithFile workWithFile = new WorkWithFile("numberOfVisits.txt");
        //"D:\\jd2_hw\\hw4\\task9\\src\\main\\resources\\numberOfVisits.txt"

        numberOfVisits = workWithFile.getNumberOfVisits();

        numberOfVisits++;

        PrintWriter writer = resp.getWriter();
        writer.println("Visits: " + numberOfVisits);

        workWithFile.writeNumberOfVisits(numberOfVisits);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
