package it.academy.service;

import it.academy.PhoneNumberDao;
import it.academy.model.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PhoneNumberService {

    @Autowired
    PhoneNumberDao phoneNumberDao;

    public List<PhoneNumber> getAllPhoneNumber(){
        return phoneNumberDao.readAll();
    }
}
