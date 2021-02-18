package it.academy;

import it.academy.model.Person;

import java.util.List;

public interface PersonDao {

    List<Person> readAll();
}
