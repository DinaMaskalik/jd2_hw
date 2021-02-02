package it.academy.dao;

import it.academy.model.BaseTest;
import it.academy.pojos.Passport;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PassportTest extends BaseTest {


    @Test
    public void readAll() {
        //Given
        cleanInsert("PassportTest.xml");

        //When

        final List<Passport> passports =
                session.createQuery("from Passport")
                .list();

        //Then
        assertEquals(4, passports.size());
        deleteDataset();

    }

    @Test
    public void delete() {
        //Given
        cleanInsert("PassportTest.xml");

        //When
        Transaction transaction = session.beginTransaction();
        session.delete(session.get(Passport.class, "4028abed775d2c1b01775d2c1d940011"));
        transaction.commit();

        //When
        assertNull(session.get(Passport.class, "4028abed775d2c1b01775d2c1d940011"));
        deleteDataset();
    }

    @Test
    public void load() {
        //Given
        cleanInsert("PassportTest.xml");

        //When
        Transaction transaction = session.beginTransaction();
        final Passport passport = session.get(Passport.class, "4028abed775d2c1b01775d2c1d940011");
        transaction.commit();

        //When
        assertNotNull(passport);
        deleteDataset();
    }

}