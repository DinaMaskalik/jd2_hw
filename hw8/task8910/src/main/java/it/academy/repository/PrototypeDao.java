package it.academy.repository;

import it.academy.model.Passport;
import it.academy.model.Person;

import java.util.List;

public interface PrototypeDao {

    List<Person> getAllPerson();

    List<Passport> getAllPassport();
}
