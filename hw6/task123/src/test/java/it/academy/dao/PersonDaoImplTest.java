package it.academy.dao;

import it.academy.dao.PersonDaoImpl;
import it.academy.model.BaseTest;
import it.academy.pojos.Person;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.*;

@FixMethodOrder
public class PersonDaoImplTest extends BaseTest {

    private PersonDaoImpl personDao;
    private Person person;

    @Before
    public void setUp() throws Exception {
        personDao = new PersonDaoImpl("hibernate.cfg.test.xml");
        person = new Person(null, 34, "Ira", "Maskalik");
    }

    @Test
    public void create() {
        Serializable id = personDao.savePersonData(person);

        assertNotNull(id);
    }

    @Test
    public void load() {
        Serializable id = personDao.savePersonData(person);
        Person loadPerson = personDao.loadPersonData((String) id);

        assertEquals(person.toString(), loadPerson.toString());
    }

    @Test
    public void delete() {
        Serializable id = personDao.savePersonData(person);
        personDao.deletePersonData((String) id);

        assertNull(personDao.loadPersonData((String) id));
    }

    @Test
    public void dbUnitLoad() {
        //Given
        cleanInsert("PersonTest.xml");

        //When
        final Person person = personDao.loadPersonData("4028abed775d2c1b01775d2c1d940003");

        //Then
        assertNotNull(person);
        deleteDataset();

    }

    @Test
    public void dbUnitDelete() {
        //Given
        cleanInsert("PersonTest.xml");

        //When
        personDao.deletePersonData("4028abed775d2c1b01775d2c1d940003");

        //Then
        assertNull(personDao.loadPersonData("4028abed775d2c1b01775d2c1d940003"));
        deleteDataset();

    }

    @After
    public void tearDown() throws Exception {

    }
}