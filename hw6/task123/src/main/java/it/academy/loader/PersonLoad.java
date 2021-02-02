package it.academy.loader;

import it.academy.dao.PersonDaoImpl;

public class PersonLoad {

    public static void main(String[] args) {
        PersonDaoImpl personDao = new PersonDaoImpl("hibernate.cfg.xml");
        personDao.loadPersonData("4028abed775d2c1b01775d2c1d940000");
    }
}
