package com.doctorsweb.database;

import com.doctorsweb.entities.Doctors;
import com.doctorsweb.entities.User;

import java.sql.*;

public class DatabaseHandler extends Configs{
    Connection dbConnection;
    private Connection getDbConnection() throws ClassNotFoundException, SQLException
    {
        String connectionString = "jdbc:mysql://"+ dbHost + ":" + dbPort + "/" + dbName+"?serverTimezone=UTC";
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }
    public ResultSet getDocror(String id)
    {
        ResultSet resultSet = null;
        String select = "SELECT * FROM " + Const.DOCTORS_TABLE +" WHERE "+ Const.DOC_ID +"=?";
        try
        {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
            preparedStatement.setString(1, id);
            resultSet = preparedStatement.executeQuery();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    public ResultSet getUser(String login, String password)
    {
        ResultSet resultSet = null;
        String select = "SELECT * FROM " + Const.USERS_TABLE+" WHERE "+ Const.USER_LOGIN+"=?" +
                " AND "+Const.USER_PASSWORD+"=?";
        try
        {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    public ResultSet getDoctors()
    {
        ResultSet resultSet = null;
        String select = "SELECT * FROM " + Const.DOCTORS_TABLE;
        try
        {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
            resultSet = preparedStatement.executeQuery();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public void setDoctor(Doctors doctors)
    {
        String set = "INSERT INTO "+Const.DOCTORS_TABLE + "("+Const.DOC_NAME +","+ Const.DOC_SURNAME +","+ Const.DOC_AGE +","+ Const.DOC_POSITION +")"+
                "VALUES (?,?,?,?)";
        try
        {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(set);
            preparedStatement.setString(1, doctors.getName());
            preparedStatement.setString(2, doctors.getSurname());
            preparedStatement.setString(3, doctors.getAge());
            preparedStatement.setString(4, doctors.getPosition());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void setUser(User user) throws SQLException, ClassNotFoundException {
        String set = "INSERT INTO "+Const.USERS_TABLE+ "("+Const.USER_LOGIN+","+ Const.USER_PASSWORD+","+ Const.USER_ROLE+")"+
                "VALUES('" + user.getLogin() + "', '" + user.getPassword() + "', '"+user.getRole().toString()+"')";

            PreparedStatement preparedStatement = getDbConnection().prepareStatement(set);
            preparedStatement.execute(set);


    }

    public String updateDoctors(Doctors doctors)
    {
        String update= "UPDATE "+Const.DOCTORS_TABLE +" SET `"+Const.DOC_NAME +"`='"+doctors.getName()+"', `"+
                Const.DOC_SURNAME +"`='"+doctors.getSurname()+"', `"+
                Const.DOC_AGE +"`='"+doctors.getAge()+"', `"+
                Const.DOC_POSITION +"`='"+doctors.getPosition()+"' WHERE `"+ Const.DOC_ID +"`='"+doctors.getId()+"'";
        try
        {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(update);
            preparedStatement.executeUpdate();
            return "Success";
        }
        catch (SQLException|ClassNotFoundException e)
        {
            System.out.println("Unable to update a record");
            return "Error";
        }

    }

    public String deleteDoctor(String id)
    {
        String delete = "DELETE FROM "+Const.DOCTORS_TABLE +" WHERE "+ Const.DOC_ID +"=?";
        try
        {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(delete);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
            return "Success";
        } catch (SQLException|ClassNotFoundException e) {
            return "Error";
        }
    }


}
