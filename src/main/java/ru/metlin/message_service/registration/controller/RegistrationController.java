package ru.metlin.message_service.registration.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.metlin.message_service.registration.RegistrationRequest;
import ru.metlin.message_service.registration.model.User;
import ru.metlin.message_service.registration.service.RegistrationService;

@Controller
public class RegistrationController {

    private RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    public RegistrationController() {
    }

    @PostMapping(value = "/registration")
    public String registration(@RequestBody RegistrationRequest request) {

        return registrationService.save(request);
       // return "webapp/pages/registration.jsp";
    }
}
