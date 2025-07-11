package com.caribe.sur.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;



@Controller
public class WelcomePage {

    @GetMapping("/WelcomePage")
    public String getMethod(Model model) {
        model.addAttribute("Introduction", "Welcome to Caribe Sur");
        model.addAttribute("Login", "Log in");
        model.addAttribute("Register", "Register");
        return "WelcomePage";
    }

    @GetMapping("/NewUser")
    public String getRegister() {
        return "Register";
    }
    
}
