package com.kisannetwork.smsservice.smsservice.controller;

import com.kisannetwork.smsservice.smsservice.domain.JsonData;
import com.kisannetwork.smsservice.smsservice.domain.Record;
import com.kisannetwork.smsservice.smsservice.repository.RecordRepository;
import com.kisannetwork.smsservice.smsservice.repository.UserDetailsRepository;
import com.kisannetwork.smsservice.smsservice.service.DbService;
import com.kisannetwork.smsservice.smsservice.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class EntryController {

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Autowired
    RecordRepository recordRepository;

    @GetMapping("/")
    public RedirectView index() {
        return new RedirectView("/home");
    }

    @GetMapping("/home")
    public String index(Model model) {
        model.addAttribute("jsonData", new JsonData());
        model.addAttribute("messageData", new Record());
        model.addAttribute("users", userDetailsRepository.findAll());
        return "index";
    }

    @GetMapping("/activity")
    public String activity(Model model) {
        model.addAttribute("allRecords", recordRepository.findAll());
        return "activity";
    }

    @RequestMapping(value = "/processForm", method= RequestMethod.POST)
    public RedirectView processForm(@ModelAttribute(value="jsonData") JsonData jsonData) {
        new DbService().pushJsonToDB(jsonData.getContent());
        return new RedirectView("/home");
    }

    @RequestMapping(value = "/sendMessage", method= RequestMethod.POST)
    public RedirectView sendMessage(@ModelAttribute(value="messageData") Record record) {
        new DbService().pushMessageToDB(record);
        new SmsService().sendOtp(record.getContactNo(), record.getBody());
        System.out.println("MESSAGE SENT");
        return new RedirectView("/home");
    }
}
