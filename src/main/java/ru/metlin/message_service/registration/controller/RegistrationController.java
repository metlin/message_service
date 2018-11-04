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
import java.util.List;


@Controller
public class RegistrationController {

    private RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    public RegistrationController() {
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registration() {
        return new ModelAndView("registration","reg_request", new RegistrationRequest());
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public  String save(@ModelAttribute("reg_request") RegistrationRequest request) {
        User user = registrationService.addUser(request);

        return "redirect:/page/index/" + user.getId();
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody List<User> getAllUsers() {
        return registrationService.getUsers();
    }
}
