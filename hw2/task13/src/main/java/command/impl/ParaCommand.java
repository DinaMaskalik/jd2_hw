package command.impl;

import command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ParaCommand implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        double length = Double.parseDouble(req.getParameter("length"));
        double width = Double.parseDouble(req.getParameter("width"));
        double height = Double.parseDouble(req.getParameter("height"));
        String answer = String.valueOf(length * width * height);
        req.setAttribute("paraAnswer", answer);
    }
}
