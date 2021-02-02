package it.academy.loader;

import it.academy.dao.PersonDao;
import it.academy.dao.PersonDaoImpl;
import it.academy.pojos.Person;
import it.academy.util.HibernateSessionUtil;
import it.academy.util.HibernateUtil;
import org.hibernate.Session;

import java.io.Serializable;

public class PersonSave {
    public static void main(String[] args) {

        PersonDaoImpl personDao = new PersonDaoImpl("hibernate.cfg.xml");
        Person person = new Person(null, 35, "Dina", "Maskalik", null);

        personDao.savePersonData(person);

    }
}
