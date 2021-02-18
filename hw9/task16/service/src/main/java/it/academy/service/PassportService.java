package it.academy.service;

import it.academy.PassportDao;
import it.academy.model.Passport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassportService {

    @Autowired
    PassportDao passportDao;

    public List<Passport> getAllPassport(){
        return passportDao.readAll();
    }
}
