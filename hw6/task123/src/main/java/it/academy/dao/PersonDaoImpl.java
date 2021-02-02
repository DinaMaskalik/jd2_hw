package it.academy.dao;

import it.academy.pojos.Person;
import it.academy.util.HibernateSessionUtil;
import org.hibernate.*;
import org.jboss.logging.Logger;

import java.io.Serializable;

public class PersonDaoImpl implements PersonDao {

    private final String xmlFile;
    final static Logger LOGGER = Logger.getLogger(PersonDaoImpl.class);

    public PersonDaoImpl(String xmlFile) {
        this.xmlFile = xmlFile;
    }

    public PersonDaoImpl() {
        xmlFile = "hibernate.cfg.xml";
    }

    @Override
    public Serializable savePersonData(Person person) {
        Session session = new HibernateSessionUtil(xmlFile).getSessionFactory().openSession();
        Serializable id = null;
        Transaction transaction = null;
        try {
            if (session.isDirty())
                session.flush();
            transaction = session.beginTransaction();
            id = session.save(person);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            LOGGER.error("Could not save the object " + e);
        } finally {
            session.close();
            return id;
        }

    }

    @Override
    public void deletePersonData(String id) {
        Session session = new HibernateSessionUtil(xmlFile).getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            session.setFlushMode(FlushMode.ALWAYS);
            transaction = session.beginTransaction();
            Person person = session.get(Person.class, id);
            session.delete(person);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            LOGGER.error("Could not delete the object " + e);
        } finally {
            session.close();
        }
    }

    @Override
    public void deletePersonData(Person person) {
        Session session = new HibernateSessionUtil(xmlFile).getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            if (session.isDirty())
                session.flush();
            transaction = session.getTransaction();
            session.delete(person);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            LOGGER.error("Could not delete the object " + e);
        } finally {
            session.close();
        }
    }

    @Override
    public Person loadPersonData(String id) {
        Session session = new HibernateSessionUtil(xmlFile).getSessionFactory().openSession();
        if (session.isDirty())
            session.flush();
        Person person = null;
        try {
            person = session.load(Person.class, id);
            System.out.println(person);

            session.close();
        } catch (ObjectNotFoundException e) {
            LOGGER.error("Could not found person " + e);
            person = null;
        } finally {
            return person;
        }

    }
}
