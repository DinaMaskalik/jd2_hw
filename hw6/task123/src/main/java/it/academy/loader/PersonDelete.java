package it.academy.loader;

import it.academy.dao.PersonDaoImpl;

public class PersonDelete {

    public static void main(String[] args) {

        PersonDaoImpl personDao = new PersonDaoImpl();
        personDao.deletePersonData(1);

    }

}
