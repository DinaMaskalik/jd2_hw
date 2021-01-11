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

@WebServlet(name = "ExpensesServlet", urlPatterns = "/task14")
public class ExpensesServlet extends HttpServlet {

    DAOFactory daoFactory;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            daoFactory = DAOFactory.getInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ServletConfig config = getServletConfig();

            final List<Expenses> expensesList;

            final String url = config.getServletContext().getInitParameter("url");
            String user = config.getServletContext().getInitParameter("user");
            String password = getServletContext().getInitParameter("password");

            ExpensesDAO expensesDAO = daoFactory.getExpensesDao(url, user, password);
            expensesList=expensesDAO.readAll();

            PrintWriter writer = resp.getWriter();

            for (Expenses expenses : expensesList) {
                writer.println("num=" + expenses.getNum() + " pay date=" + expenses.getPayDate() + " receiver=" + expenses.getReceiverName()+" pay value = "+ expenses.getPayValue());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

//        PrintWriter writer = resp.getWriter();
//
//        writer.println(url);
//        writer.println(user);
//        writer.println(password);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
