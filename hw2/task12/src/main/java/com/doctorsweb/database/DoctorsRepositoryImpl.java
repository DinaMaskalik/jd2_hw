package com.doctorsweb.database;

import com.doctorsweb.entities.Doctors;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoctorsRepositoryImpl implements Repository {
    DatabaseHandler dbHandler = new DatabaseHandler();
    @Override
    public List<Doctors> findAll() throws SQLException {
        ResultSet resultSet = dbHandler.getDoctors();
        List<Doctors> doctorsList = new ArrayList<>();
        Doctors doctors;

        while (resultSet.next())
        {
            doctors=new Doctors();
            doctors.setId(resultSet.getString("id"));
            doctors.setName(resultSet.getString("name"));
            doctors.setSurname(resultSet.getString("surname"));
            doctors.setAge(resultSet.getString("age"));
            doctors.setPosition(resultSet.getString("status"));
            doctorsList.add(doctors);
        }
        return doctorsList;
    }

    @Override
    public Object findById(String id) throws SQLException {
        ResultSet resultSet = dbHandler.getDocror(id);
        Doctors doctors = new Doctors();
        while (resultSet.next())
        {
            doctors.setId(resultSet.getString("id"));
            doctors.setName(resultSet.getString("name"));
            doctors.setSurname(resultSet.getString("surname"));
            doctors.setAge(resultSet.getString("age"));
            doctors.setPosition(resultSet.getString("status"));
        }
        return doctors;
    }

    @Override
    public void insert(Object doctor) {
        dbHandler.setDoctor((Doctors) doctor);

    }

    @Override
    public void update(Object doctor) {
        String result = dbHandler.updateDoctors((Doctors) doctor);
        System.out.println("Update was " + result);
    }

    @Override
    public void delete(String id) {
        String result = dbHandler.deleteDoctor(id);
        System.out.println("Delete was "+result);
    }

    @Override
    public Object findByCredentials(String login, String password) throws SQLException {
        return null;
    }
}
