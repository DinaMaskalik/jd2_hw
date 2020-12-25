package command.impl;

import command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SphereCommand implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        double radius = Double.parseDouble(req.getParameter("radius"));
        String answer = String.valueOf(4 * 3.14 * radius * radius * radius / 3);
        req.setAttribute("sphereAnswer", answer);
    }
}
