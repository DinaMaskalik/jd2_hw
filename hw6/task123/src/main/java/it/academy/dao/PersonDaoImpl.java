package it.academy.dao;

import it.academy.pojos.Person;
import it.academy.util.HibernateSessionUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;

public class PersonDaoImpl implements PersonDao {

    private String xmlFile;

    public PersonDaoImpl(String xmlFile) {
        this.xmlFile = xmlFile;
    }

    public PersonDaoImpl() {
        xmlFile = "hibernate.cfg.xml";
    }

    @Override
    public Serializable savePersonData(Person person) {
        Session session = new HibernateSessionUtil(xmlFile).getSessionFactory().openSession();

        session.beginTransaction();
        Serializable id = session.save(person);
        session.getTransaction().commit();

        session.close();

        return id;
    }

    @Override
    public void deletePersonData(int id) {
        Session session = new HibernateSessionUtil(xmlFile).getSessionFactory().openSession();
        session.beginTransaction();
        Person person = session.get(Person.class, id);
        session.delete(person);
        session.getTransaction().commit();

        session.close();
    }

    @Override
    public void deletePersonData(Person person) {
        Session session = new HibernateSessionUtil(xmlFile).getSessionFactory().openSession();
        session.getTransaction();
        session.delete(person);
        session.getTransaction().commit();

        session.close();
    }

    @Override
    public Person loadPersonData(int id) {
        Session session = new HibernateSessionUtil(xmlFile).getSessionFactory().openSession();
        Person person = session.load(Person.class, id);
        System.out.println(person);

        session.close();

        return person;
    }
}
