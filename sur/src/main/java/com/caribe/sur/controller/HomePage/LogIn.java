package com.caribe.sur.controller.HomePage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.caribe.sur.model.DTO.User;
import com.caribe.sur.model.logic.Warehouse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class LogIn {

    @GetMapping("Login")
    public String getMethodName() {
        return "Login"; 
    }
    
    @PostMapping("Login")
    public String postMethodName(@RequestParam String userName,@RequestParam String password) {
    User user = Warehouse.getUser(userName);
    if(user != null && user.getPassword().equals(password)) {
        return "redirect:HomePage";
    } else {
        return "Login";
    }  

        
    }
    

}
