package it.academy.utils.output;

import it.academy.repository.PrototypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PrintInfo {

    @Autowired
    @Qualifier("personDaoImpl")
    private PrototypeDao personPrototypeDao;

    @Qualifier("prototypeDaoNewImpl")
    @Autowired
    private PrototypeDao passportPrototypeDao;

    public void print(){

        personPrototypeDao.getAllPerson().forEach(System.out::println);

        passportPrototypeDao.getAllPassport().forEach(System.out::println);
    }
}
