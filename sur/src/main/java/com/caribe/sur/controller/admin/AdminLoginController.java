package com.caribe.sur.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.caribe.sur.model.DTO.Admin;
import com.caribe.sur.tools.PasswordTimer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class AdminLoginController {
    // Singleton instance of Admin
    private Admin admin = Admin.getInstance();
    
    //URLs for the admin pages
    private final String ADMIN_LOGIN = "AdminPages/AdminLogin";

    // Redirect URLs for the admin pages
    private final String ADMIN_LOGIN_REDIRECT = "redirect:/AdminLogin";
    private final String ADMIN_HOME_PAGE_REDIRECT = "redirect:/AdminHomePage";
    
    // Limit the number of attempts to login
    // If the user exceeds the limit, they must wait a certain time before trying again
    private int tryCount = 3;
    private final int MAX_TRY_COUNT = 3;

    // The password timer
    // If the user exceeds the limit, they must wait a certain time before trying again
    private PasswordTimer passwordTimer;
    

    // Method to show the admin home page
    // If the administrator makes a mistake he will see the attempts he has left 
    @GetMapping("AdminLogin")
    public String adminLogin(Model model) {
        
        // If the first time the user tries to log in don´t show the attempts left
        if(tryCount == MAX_TRY_COUNT){
            return ADMIN_LOGIN;
        }

        // If the user has exceeded the maximum number of attempts
        // show the time left to try again
        if(tryCount == 0){
                tryCount--;
                passwordTimer = new PasswordTimer();
            }
            
            // show the information for the administrator
            if(tryCount <= 0) {
                model.addAttribute("badPassword", "You have exceeded the maximum number of attempts."
                + " Please wait " + passwordTimer.getWaitTime() + " before trying again.");
            }else{
                model.addAttribute("badPassword", "Invalid password. You have " + tryCount + " attempts left.");
            }
        
        
        return ADMIN_LOGIN;
    }





    // Method to check if the password is correct
    @PostMapping("AdminLogin")
    public String postMethodName(@RequestParam String adminPassword) {
        
        // Check if the password is correct
        if(admin.validatePassword(adminPassword) && tryCount > 0) {
            tryCount = MAX_TRY_COUNT; // Reset try count on successful login
            return ADMIN_HOME_PAGE_REDIRECT;
        }else{
            tryCount--;
            return ADMIN_LOGIN_REDIRECT;

        }
            
    }
    
    

    

}
