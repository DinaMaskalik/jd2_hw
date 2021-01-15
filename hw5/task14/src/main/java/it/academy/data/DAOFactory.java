package it.academy.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOFactory {
    private static DAOFactory daoFactory;

    public DAOFactory() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    public ExpensesDAOImp getExpensesDao(String url, String user, String password) throws SQLException {
        Connection connection = DriverManager.getConnection(
                url, user, password);
        return new ExpensesDAOImp(connection);
    }

    public static DAOFactory getInstance() throws ClassNotFoundException {

        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;

    }
}
