package it.academy;

import it.academy.model.PhoneNumber;

import java.util.List;

public interface PhoneNumberDao {

    List<PhoneNumber> readAll();
}
