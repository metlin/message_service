package ru.metlin.message_service.registration.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ru.metlin.message_service.registration.model.User;
import ru.metlin.message_service.registration.request.RegistrationRequest;
import ru.metlin.message_service.registration.service.RegistrationService;

import java.util.Set;

@Controller
public class RegistrationController {

    private RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    public RegistrationController() {
    }

    @RequestMapping(value = "/hello")
    public String hello() {

        return "index";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registration() {
        return new ModelAndView("registration","command", new RegistrationRequest());
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@ModelAttribute RegistrationRequest request) {
        System.out.println(request.getFirstName());
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody Set<User> getAllUsers() {
        return registrationService.getUsers();
    }
}
