package it.academy.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FormServlet", urlPatterns = "/form-servlet")
public class FormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final PrintWriter writer = resp.getWriter();

        String name = req.getParameter("name");
        String phoneNumber=req.getParameter("phoneNumber");
        String email = req.getParameter("email");

        if("".equals(name) || ("".equals(phoneNumber) && "".equals(email))){
            //resp.sendRedirect("http://localhost:8080/task10/index.html");

            writer.println("Error! Input all data!");
        }
        else{
            ValidateInformation validateInformation = new ValidateInformation();
            if((validateInformation.verifyName(name) && validateInformation.verifyEmail(email)) ||
                    (validateInformation.verifyName(name) && validateInformation.verifyPhoneNumber(phoneNumber))||
                    (validateInformation.verifyName(name) && validateInformation.verifyEmail(email) && validateInformation.verifyPhoneNumber(phoneNumber))) {
                writer.println("Name: " + name);
                if ("".equals(phoneNumber)) {
                    writer.println("Email: " + email);
                } else {
                    if ("".equals(email)) {
                        writer.println("Phone number: " + phoneNumber);
                    } else {
                        writer.println("Email: " + email);
                        writer.println("Phone number: " + phoneNumber);
                    }
                }
            }
        }

    }
}
