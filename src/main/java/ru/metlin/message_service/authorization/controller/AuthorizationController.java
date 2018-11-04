package ru.metlin.message_service.authorization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.metlin.message_service.authorization.request.AuthorizationRequest;
import ru.metlin.message_service.authorization.service.AuthorizationService;
import ru.metlin.message_service.registration.model.User;

@Controller
public class AuthorizationController {

    @Autowired
    private AuthorizationService authorizationService;

    public AuthorizationController(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @RequestMapping(value = "/authorization", method = RequestMethod.GET)
    public ModelAndView authorization() {
        return new ModelAndView("authorization","auth_request", new AuthorizationRequest());
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(@ModelAttribute("auth_request") AuthorizationRequest request) {
        User user = authorizationService.searchByLoginAndPassword(request);

        return "redirect:/page/index/" + user.getId();
    }
}
