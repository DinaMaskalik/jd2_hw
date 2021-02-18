package it.academy.controllers;

import it.academy.PhoneNumberDao;
import it.academy.service.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PhoneNumberController {

    @Autowired
    PhoneNumberService phoneNumberService;

    @GetMapping("/phone-number")
    public String viewPhoneNumber(Model model){
        model.addAttribute("phoneNumberList", phoneNumberService.getAllPhoneNumber());

        return "defPhoneNumber";
    }
}
