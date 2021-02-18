package it.academy;

import it.academy.model.Passport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PassportDaoImpl implements PassportDao {

    private static List<Passport> passportList;

    static {
        passportList=List.of(
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
    public List<Passport> readAll() {
        return passportList;
    }
}
