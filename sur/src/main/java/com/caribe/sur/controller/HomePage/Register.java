package com.caribe.sur.controller.homePage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.caribe.sur.model.DTO.User;
import com.caribe.sur.model.logic.Warehouse;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Register {

    


    @GetMapping("/Register")
    public String getMethodName() {
        return "Register";
    }
    


    @PostMapping("/Register")
    public String postMethodName(Model model,@RequestParam String userName, @RequestParam String password, @RequestParam int phone) {
        User entity = new User(userName, password, phone);
        
        if(Warehouse.addUser(entity)) {
            model.addAttribute("userName", entity.getUserName());
            return "redirect:HomePage";
        } else {
            return "Register";
        }
    }
    
}
