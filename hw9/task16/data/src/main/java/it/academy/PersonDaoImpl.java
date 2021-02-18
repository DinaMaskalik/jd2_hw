package it.academy;

import it.academy.model.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDaoImpl implements PersonDao {

    private static List<Person> personList;

    static {
        personList = List.of(
                Person.builder()
                        .personId("1")
                        .name("Ira")
                        .surname("Ivanova")
                        .age(21)
                        .build(),
                Person.builder()
                        .personId("2")
                        .name("Vika")
                        .surname("Gavrilova")
                        .age(20)
                        .build(),
                Person.builder()
                        .personId("3")
                        .name("Ivan")
                        .surname("Ivanov")
                        .age(32)
                        .build()
                );
    }

    @Override
    public List<Person> readAll(){
        return personList;
    }
}
