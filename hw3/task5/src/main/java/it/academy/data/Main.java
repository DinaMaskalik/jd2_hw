package it.academy.data;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ValidateNewInformation validateNewInformation = new ValidateNewInformation();


        if (args.length == 4) {
            if (validateNewInformation.verifyNumber(args[0]) &&
                    validateNewInformation.verifyDate(args[1]) &&
                    validateNewInformation.verifyDouble(args[2]) &&
                    validateNewInformation.verifyNumber(args[3])) {

                Class.forName("com.mysql.cj.jdbc.Driver");

                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ListExpenses?serverTimezone=UTC",
                        "root",
                        "root");

                try (PreparedStatement preparedStatement = connection.prepareStatement(
                        "insert into ListExpenses.expenses (num,paydate,payvalue,receiver_num)\n" +
                                "            values (?, ?, ?, ?)")) {
                    preparedStatement.setInt(1, Integer.parseInt(args[0]));
                    preparedStatement.setDate(2, Date.valueOf(args[1]));
                    preparedStatement.setDouble(3, Double.parseDouble(args[2]));
                    preparedStatement.setInt(4, Integer.parseInt(args[3]));
                    System.out.println("create=" + preparedStatement.executeUpdate());

                } catch (SQLException e) {
                    e.printStackTrace();

                }


                try (PreparedStatement statement = connection.prepareStatement(
                        "select expenses.num,expenses.paydate, receivers.rname, expenses.payvalue\n" +
                                "from expenses\n" +
                                "inner join receivers on receivers.num=expenses.receiver_num "
                                + "where expenses.payvalue> ?")) {

                    statement.setDouble(1, 1000);

                    final ResultSet resultSet = statement.executeQuery();
                    while (resultSet.next()) {
                        System.out.println(
                                "num=" + resultSet.getInt("num") +
                                        " paydate=" + resultSet.getDate("paydate") +
                                        " receiver=" + resultSet.getString("rname") +
                                        " payvalue=" + resultSet.getString("payvalue"));
                    }

                    resultSet.close();
                }
                connection.close();

            } else {
                System.out.println("Some information invalid!!");
            }

        } else {
            System.out.println("Input all parameters!!");
        }

    }
}
