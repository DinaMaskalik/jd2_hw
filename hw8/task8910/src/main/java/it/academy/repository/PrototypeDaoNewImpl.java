package it.academy.repository;

import it.academy.model.Passport;
import it.academy.model.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PrototypeDaoNewImpl implements PrototypeDao {

    private static List<Passport> passports;

    static {
        passports=List.of(
                Passport.builder()
                        .passportId("1")
                        .passportNumber("1234564")
                        .passportSeries("WE")
                        .visaType("USA").build(),
                Passport.builder()
                        .passportId("2")
                        .passportNumber("98765432")
                        .passportSeries("UI")
                        .visaType("ES").build()
                );
    }

    @Override
    public List<Person> getAllPerson() {
        return null;
    }

    @Override
    public List<Passport> getAllPassport() {
        return passports;
    }
}
