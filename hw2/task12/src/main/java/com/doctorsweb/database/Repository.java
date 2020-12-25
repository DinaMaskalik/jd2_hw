package com.doctorsweb.database;

import java.sql.SQLException;
import java.util.List;

public interface Repository<T> {
    List<T> findAll() throws SQLException;
    T findById(String id) throws SQLException;
    void insert(T doctor) throws SQLException, ClassNotFoundException;
    void update(T doctor);
    void delete(String id);
    T findByCredentials(String login, String password) throws SQLException;
}
