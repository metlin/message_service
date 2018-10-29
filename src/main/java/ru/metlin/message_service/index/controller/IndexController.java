package ru.metlin.message_service.index.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.metlin.message_service.index.model.Message;
import ru.metlin.message_service.index.service.IndexService;

@Controller
public class IndexController {

    @Autowired
    private IndexService indexService;

    public IndexController(IndexService indexService) {
        this.indexService = indexService;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("message", new Message());
        model.addAttribute("messageList", indexService.messageList());

        return "index";
    }
}
