package it.academy.service;

import it.academy.PersonDao;
import it.academy.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonDao personDao;

    public List<Person> readAllPerson(){
        return personDao.readAll();
    }
}
