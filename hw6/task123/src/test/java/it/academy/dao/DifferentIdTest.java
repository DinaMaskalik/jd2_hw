package it.academy.dao;

import it.academy.model.BaseTest;
import it.academy.pojos.Person;
import it.academy.pojos.PhoneNumber;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class DifferentIdTest extends BaseTest {

    @Test
    public void phoneId(){
        //Given
        cleanInsert("PhoneNumberTest.xml");

        //When
        final List<PhoneNumber> phoneNumbers =
                session.createQuery("from PhoneNumber ")
                        .list();

        System.out.println("PhoneNumber use generator increment");
        phoneNumbers.forEach(
                phoneNumber -> System.out.println(session.getIdentifier(phoneNumber)));

        //Then
        assertEquals(4, phoneNumbers.size());
        deleteDataset();
    }

    @Test
    public void personId(){

        //Given
        cleanInsert("PersonTest.xml");

        //When
        final List<Person> persons =
                session.createQuery("from Person ")
                        .list();

        persons.forEach(
                person -> System.out.println(session.getIdentifier(person)));

        //Then
        assertEquals(4, persons.size());
        deleteDataset();

    }

}