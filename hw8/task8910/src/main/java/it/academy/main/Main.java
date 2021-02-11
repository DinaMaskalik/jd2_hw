package it.academy.main;

import it.academy.repository.PrototypeDao;
import it.academy.repository.PrototypeDaoImpl;
import it.academy.repository.PrototypeDaoNewImpl;
import it.academy.scan.ScanConfig;
import it.academy.utils.output.PrintInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context
                = new AnnotationConfigApplicationContext(ScanConfig.class);

        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);

//        PrototypeDao personPrototypeDao = context.getBean(PrototypeDaoImpl.class);
//        personPrototypeDao.getAllPerson().forEach(System.out::println);
//
//        PrototypeDao passportPrototypeDao = context.getBean(PrototypeDaoNewImpl.class);
//        passportPrototypeDao.getAllPassport().forEach(System.out::println);

        PrintInfo printInfo = context.getBean(PrintInfo.class);
        printInfo.print();
    }
}
