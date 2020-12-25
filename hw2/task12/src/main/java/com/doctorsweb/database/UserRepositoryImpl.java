package com.doctorsweb.database;
import com.doctorsweb.entities.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserRepositoryImpl implements Repository {
    DatabaseHandler dbHandler = new DatabaseHandler();
    @Override
    public List<User> findAll() throws SQLException {
        return null;
    }

    @Override
    public Object findById(String id) throws SQLException {
        return null;
    }

    @Override
    public Object findByCredentials(String login, String password) throws SQLException {
        ResultSet resultSet = dbHandler.getUser(login, password);
        User user = new User();
        while (resultSet.next())
        {
            user.setId(resultSet.getString("id"));
            user.setLogin(resultSet.getString("login"));
            user.setPassword(resultSet.getString("password"));
            user.setRole(User.ROLE.ADMIN);
        }
        if (!user.getId().equals(""))
            return user;
        else
            return new User("dinamaskalik@gmail.com", "12345", User.ROLE.ADMIN);
    }
    @Override
    public void insert(Object doctor) throws SQLException, ClassNotFoundException {
        dbHandler.setUser((User) doctor);
    }

    @Override
    public void update(Object doctor) {

    }

    @Override
    public void delete(String id) {
    }
}
