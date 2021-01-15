package it.academy.servlet;

import it.academy.copy.CopyOfExpensesList;
import it.academy.data.DAOFactory;
import it.academy.data.Expenses;
import it.academy.data.ExpensesDAOImp;

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

@WebServlet(name = "JSPServlet", urlPatterns = "/task15")
public class JSPServlet extends HttpServlet {

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

        try {
            ServletConfig config = getServletConfig();

            final List<Expenses> expensesList;

            final String url = config.getServletContext().getInitParameter("url");
            String user = config.getServletContext().getInitParameter("user");
            String password = getServletContext().getInitParameter("password");

            ExpensesDAOImp expensesDao = daoFactory.getExpensesDao(url, user, password);

            expensesList = expensesDao.readAll();

            CopyOfExpensesList copy = new CopyOfExpensesList();
            String[] expensesArray = copy.getStringArrayFoExpensesList(expensesList);

            req.setAttribute("expenses", expensesArray);

            req.getRequestDispatcher("/jsp/expensesJSP.jsp").forward(req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
