package command.impl;

import command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CubeCommand implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        double side = Double.parseDouble(req.getParameter("side"));
        String answer = String.valueOf(side * side * side);
        req.setAttribute("cubeAnswer", answer);
    }
}
