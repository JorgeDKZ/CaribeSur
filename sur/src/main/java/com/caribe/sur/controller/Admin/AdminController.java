package com.caribe.sur.controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.caribe.sur.model.DTO.Admin;
import com.caribe.sur.tools.PasswordTimer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AdminController {
    // Singleton instance of Admin
    private Admin admin;
    
    //URLs for the admin pages
    private final String ADMIN_HOME_PAGE = "AdminPages/AdminHomePage";
    private final String ADMIN_LOGIN = "AdminPages/AdminLogin";
    
    // Limit the number of attempts to login
    // If the user exceeds the limit, they must wait a certain time before trying again
    private int tryCount = 3;

    // The password timer
    // If the user exceeds the limit, they must wait a certain time before trying again
    private PasswordTimer passwordTimer;
    

    @GetMapping("Admin")
    public String adminLogin() {
        return ADMIN_LOGIN;
    }
    @PostMapping("Admin")
    public String postMethodName(Model model, @RequestBody String password) {
        
        if(admin.validatePassword(password)){
            tryCount = 3; // Reset try count on successful login
            return ADMIN_HOME_PAGE;
        }else{
            tryCount--;
            if(tryCount <= 0) {
                model.addAttribute("badPassword", "You have exceeded the maximum number of attempts."
                + "Please wait " + passwordTimer.getWaitTime() + " before trying again.");
                return ADMIN_LOGIN;
            }
            model.addAttribute("badPassword", "Invalid password. You have " + tryCount + " attempts left.");
            return ADMIN_LOGIN;
        }
            
    }
    
    

    

}
