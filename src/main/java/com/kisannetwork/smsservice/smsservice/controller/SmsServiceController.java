package com.kisannetwork.smsservice.smsservice.controller;

import com.kisannetwork.smsservice.smsservice.domain.UserDetails;
import com.kisannetwork.smsservice.smsservice.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SmsServiceController {

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @GetMapping("/all-user")
    public List<UserDetails> retrieveAllUserDetails(){
        List<UserDetails> userDetails = (List<UserDetails>) userDetailsRepository.findAll();
        for(UserDetails user : userDetails){
            System.out.println(user.getId() + "/" + user.getName() + "/" + user.getContactNo());
        }
        return userDetails;
    }

}
