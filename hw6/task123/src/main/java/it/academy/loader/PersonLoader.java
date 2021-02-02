package it.academy.loader;

import it.academy.pojos.Person;
import it.academy.util.HibernateUtil;

import javax.persistence.EntityManager;

public class PersonLoader {
    public static void main(String[] args) {
        Person person = new Person(null, 35, "Yuli", "Slabko", null);
        EntityManager em = HibernateUtil.getEntityManager();

        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();

        HibernateUtil.close();
    }
}
