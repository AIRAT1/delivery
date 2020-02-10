package io.delivery.controller;

import io.delivery.model.Answer;
import io.delivery.model.Message;
import io.delivery.service.CreateTable;
import net.yandex.speller.services.spellservice.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.soap.SOAPException;
import java.io.IOException;

@Controller
public class AppController {
    @Autowired
    private Answer answer;
    @Autowired
    private Message message;
    @Autowired
    private CreateTable tableCreator;
//    @Autowired
//    private TableCreator tableCreator;
    @Autowired
    private Client client;

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

    @RequestMapping(value = {"/password/{password}"}, method = RequestMethod.GET)
    public ModelAndView passwordEncode(@PathVariable("password") String password) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("password");
        modelAndView.addObject("crypt", new BCryptPasswordEncoder().encode(password));
        return modelAndView;
    }

    @RequestMapping(value = "/documentApi")
    public String getDocumentInfo() {
        return "document";
    }

    @RequestMapping(value = {"/word/{check}"}, method = RequestMethod.GET)
    public ModelAndView checkWord(@PathVariable("check") String check) throws IOException, SOAPException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("spell");
        modelAndView.addObject("info", client.result(check));
        return modelAndView;
    }
}
