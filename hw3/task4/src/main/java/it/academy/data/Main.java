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
                        "Dina05082001");

                Statement statement = connection.createStatement();
                String query = "insert into " +
                        "ListExpenses.expenses (num,paydate,payvalue,receiver_num) " +
                        "value (" + args[0] + ",'" + args[1] + "', " + args[2] + "," + args[3] + ")";

                statement.executeUpdate(query);

                ResultSet resultSet = statement.executeQuery("select expenses.num,expenses.paydate, receivers.rname, expenses.payvalue\n" +
                        "from expenses\n" +
                        "inner join receivers on receivers.num=expenses.receiver_num");

                while (resultSet.next()) {
                    System.out.println("num=" + resultSet.getInt("num") +
                            " paydate=" + resultSet.getDate("paydate") +
                            " receiver=" + resultSet.getString("rname") +
                            " payvalue=" + resultSet.getString("payvalue"));
                }

                connection.close();
                statement.close();
                resultSet.close();
            }
            else{
                System.out.println("Some information invalid!!");
            }

        } else {
            System.out.println("Input all parameters!!");
        }

    }
}
