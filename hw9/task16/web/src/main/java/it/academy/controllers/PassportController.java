package it.academy.controllers;

import it.academy.service.PassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PassportController {

    @Autowired
    PassportService passportService;

    @GetMapping("/passport")
    public String viewPassport(Model model){
        model.addAttribute("passportList", passportService.getAllPassport());

        return "defPassport";
    }
}
