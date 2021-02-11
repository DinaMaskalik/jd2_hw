package it.academy.repository;

import it.academy.model.Address;
import it.academy.model.IPhoneNumber;
import it.academy.model.Passport;
import it.academy.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("personDaoImpl")
public class PrototypeDaoImpl implements PrototypeDao {

    private static List<Person> persons;

    @Autowired
    private Address address;

    @Autowired
    @Qualifier("firstPhone")
    private IPhoneNumber number;

    @Override
    public List<Person> getAllPerson() {
        persons=List.of(
                Person.builder()
                        .personId("1")
                        .name("Dina")
                        .age(19)
                        .surname("Maskalik")
                        .address(address)
                        .number(number)
                        .build(),
                Person.builder()
                        .personId("2")
                        .name("Ira")
                        .age(35)
                        .surname("Ivanova")
                        .address(address)
                        .number(number)
                        .build(),
                Person.builder()
                        .personId("3")
                        .name("Karina")
                        .age(23)
                        .surname("Ivanova")
                        .address(address)
                        .number(number)
                        .build()
        );
        return persons;
    }

    @Override
    public List<Passport> getAllPassport() {
        return null;
    }
}
