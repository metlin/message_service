package ru.metlin.message_service.index.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ru.metlin.message_service.index.model.Message;
import ru.metlin.message_service.index.request.ChangePassword;
import ru.metlin.message_service.index.request.SendMessage;
import ru.metlin.message_service.index.service.IndexService;
import ru.metlin.message_service.registration.model.User;

@Controller
public class IndexController {

    @Autowired
    private IndexService indexService;

    public IndexController(IndexService indexService) {
        this.indexService = indexService;
    }

    @RequestMapping(value = "/index/{id}", method = RequestMethod.GET)
    public String index(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", indexService.getById(id));
        model.addAttribute("message", new Message());
        model.addAttribute("messageList", indexService.messageList(id));
        model.addAttribute("change_password", new ChangePassword(id));
        model.addAttribute("message_request", new SendMessage());

        return "index";
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public String remove(@PathVariable("id") Long id) {
        User user = indexService.removeMessage(id);

        return "redirect:/page/index/" + user.getId();
    }

    @RequestMapping(value = "/change_password", method = RequestMethod.POST)
    public String changePassword(@ModelAttribute("change_password") ChangePassword request) {

        indexService.changePassword(request.getPassword(), request.getId());

        return "redirect:/page/index/" + request.getId();
    }

    @RequestMapping(value = "/send_message", method = RequestMethod.POST)
    public String sendMessage(@ModelAttribute("message_request") SendMessage request) {

        indexService.sendMessage(request);

        return "redirect:/page/index/" + request.getId();
    }
}
