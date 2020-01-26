package io.delivery.controller;

import io.delivery.model.Answer;
import io.delivery.model.Message;
import io.delivery.model.TableCreator;
import io.delivery.service.CreateTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
    @Autowired
    private Answer answer;
    @Autowired
    private Message message;
//    @Autowired
//    private CreateTable tableCreator;
    @Autowired
    private TableCreator tableCreator;

    @RequestMapping("/")
    public String hello(Model model) {
        answer.setInfoAnswer("something");
        model.addAttribute("info", message.getInfoMessage());
        model.addAttribute("answ", answer.getInfoAnswer());
        return "hello";
    }

    @RequestMapping("/create")
    public String create(Model model) {
        model.addAttribute("status", tableCreator.createCompany());
        return "create";
    }

    @RequestMapping("/secure")
    public String secure() {
        return "secure";
    }
}
