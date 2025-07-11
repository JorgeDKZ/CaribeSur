package com.caribe.sur.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.caribe.sur.model.DTO.User;


@Controller
public class Register {

    HashMap<String, User> users = new HashMap<>();

    @PostMapping("/Register")
    public String postMethodName(@RequestParam User entity) {
        
        if(users.get(entity.getUserName()) == null) {
            users.put(entity.getUserName(), entity);
            return "WelcomePage";
        } else {
            return "Register";

        }
    }
    
}
