package it.academy;

import it.academy.model.Passport;

import java.util.List;

public interface PassportDao {

    List<Passport> readAll();
}
