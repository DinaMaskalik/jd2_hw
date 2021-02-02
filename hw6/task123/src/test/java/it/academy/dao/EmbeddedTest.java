package it.academy.dao;

import it.academy.model.BaseTest;
import it.academy.pojos.Address;
import it.academy.pojos.Person;
import org.hibernate.Transaction;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.*;

public class EmbeddedTest extends BaseTest {

    @Test
    public void createPersonWithAddress(){
        //Given
        Person person_1 = new Person("111", 34,"Dina","Maskalik",
                new Address("Gikalo", "Minsk","123456"));

        Person person_2 = new Person("222", 29,"Ira","Maskalik",
                new Address("Medicinskaya", "Vitebsk","200989"));

        //When
        Transaction transaction = session.beginTransaction();
        final Serializable save_1 = session.save(person_1);
        final Serializable save_2 = session.save(person_2);
        transaction.commit();

        //Then
        assertNotNull(save_1);
        assertNotNull(save_2);

    }
}