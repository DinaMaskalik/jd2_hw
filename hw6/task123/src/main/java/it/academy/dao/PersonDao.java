package it.academy.dao;

import it.academy.pojos.Person;

import java.io.Serializable;

public interface PersonDao {

    Serializable savePersonData(Person person);

    void deletePersonData(int id);

    void deletePersonData(Person person);

    Person loadPersonData(int id);

}
