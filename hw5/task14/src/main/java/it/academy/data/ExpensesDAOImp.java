package it.academy.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ExpensesDAOImp implements ExpensesDAO {

    private final Connection connection;

    public ExpensesDAOImp(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Expenses> readAll() {

        List<Expenses> expensesList = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "select expenses.num,paydate,payvalue,receivers.rname " +
                             "from expenses "+
                     "inner join receivers on receivers.num=expenses.receiver_num")) {
            while (resultSet.next()) {
                Expenses expenses = new Expenses();
                expenses.setNum(resultSet.getInt("num"));
                expenses.setPayDate(resultSet.getDate("paydate"));
                expenses.setPayValue(resultSet.getDouble("payvalue"));
                expenses.setReceiverName(resultSet.getString("receivers.rname"));

                expensesList.add(expenses);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return expensesList;
    }

}
