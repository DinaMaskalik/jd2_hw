package it.academy.dao;

import it.academy.pojos.Person;
import org.hibernate.ObjectNotFoundException;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.*;

@FixMethodOrder
public class PersonDaoImplTest {

    private PersonDaoImpl personDao;
    private Person person;

    @Before
    public void setUp() throws Exception {
        personDao = new PersonDaoImpl("hibernate.cfg.test.xml");
        person = new Person(null, 34, "Ira", "Maskalik");
    }

    @Test
    public void create(){
        Serializable id = personDao.savePersonData(person);

        assertNotNull(id);
    }

    @Test
    public void load(){
        Serializable id = personDao.savePersonData(person);
        Person loadPerson = personDao.loadPersonData((Integer) id);

        assertEquals(person.toString(), loadPerson.toString());
    }

    @Test
    public void delete(){
        Serializable id = personDao.savePersonData(person);
        personDao.deletePersonData((Integer) id);

        assertNull(personDao.loadPersonData((Integer) id));
    }


    @After
    public void tearDown() throws Exception {
    }
}