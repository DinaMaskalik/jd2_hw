package it.academy.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateSessionUtil {

    private static SessionFactory sessionFactory;
    private static String xmlFile;

    public HibernateSessionUtil(String xmlFile) {
        this.xmlFile = xmlFile;
    }

    public static SessionFactory getSessionFactory() {

        StandardServiceRegistry registry =
                new StandardServiceRegistryBuilder()
                        .configure(xmlFile)
                        .build();

        sessionFactory =
                new MetadataSources(registry)
                        .buildMetadata()
                        .buildSessionFactory();

        return sessionFactory;
    }

}
