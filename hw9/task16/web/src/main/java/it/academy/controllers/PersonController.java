package it.academy.controllers;

import it.academy.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("/")
    public String viewPerson(Model model){

        model.addAttribute("personList", personService.readAllPerson());

        return "defPerson";
    }
}
