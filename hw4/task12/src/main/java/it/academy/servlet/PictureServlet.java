package it.academy.servlet;

import it.academy.file.WorkWithFile;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PictureServlet", urlPatterns = "/picture")
public class PictureServlet extends HttpServlet {

    int numberOfVisits = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        WorkWithFile workWithFile = new WorkWithFile("numberOfVisits.txt");
        //"D:\\jd2_hw\\hw4\\task12\\src\\main\\resources\\numberOfVisits.txt"
        //"numberOfVisits.txt"
        numberOfVisits = workWithFile.getNumberOfVisits();

        numberOfVisits++;

        resp.setContentType("image/jpeg");

        BufferedImage image = new BufferedImage(500, 200, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = image.createGraphics();
        graphics2D.setFont(new Font("Serif", Font.ITALIC, 200));
        graphics2D.setColor(Color.white);
        graphics2D.drawString(String.valueOf(numberOfVisits), 25, 175);

        ServletOutputStream out = resp.getOutputStream();
        ImageIO.write(image, "jpeg", out);

        workWithFile.writeNumberOfVisits(numberOfVisits);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
