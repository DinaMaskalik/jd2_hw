package it.academy.servlet;

import it.academy.data.DAOFactory;
import it.academy.data.Expenses;
import it.academy.data.ExpensesDAO;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;


@WebServlet(name = "JstlServlet", urlPatterns = "/task17")
public class JstlServlet extends HttpServlet {

    DAOFactory daoFactory;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            daoFactory = DAOFactory.getInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletConfig config = getServletConfig();

        PrintWriter writer = resp.getWriter();

        final List<Expenses> expensesList;
        try {

            final String url = config.getServletContext().getInitParameter("url");
            final String user = config.getServletContext().getInitParameter("user");
            final String password = getServletContext().getInitParameter("password");

            ExpensesDAO expensesDAO = daoFactory.getExpensesDao(url, user, password);

            expensesList = expensesDAO.readAll();

            req.setAttribute("expenses", expensesList);
            req.getRequestDispatcher("/jsp/expensesJstl.jsp").forward(req,resp);


        } catch (SQLException e) {
            e.printStackTrace();
            writer.println("Error: " + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
