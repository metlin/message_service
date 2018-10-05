package ru.metlin.message_service.registration.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.metlin.message_service.registration.request.RegistrationRequest;
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

    @RequestMapping(value = "/")
    public String registration(RegistrationRequest request) {

        return "registration";
      //  return registrationService.save(request);
       // return "webapp/pages/registration.jsp";
    }
}
