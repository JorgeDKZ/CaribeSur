package com.caribe.sur.controller.homePage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import com.caribe.sur.model.User;
import com.caribe.sur.service.UserGestions;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class Register {

    private final String URL_REGISTER = "/register";
    private final String URL_REDIRECT_HOMEPAGE = "redirect:HomePage";

    private final String HTML_REGISTER = "startPage/Register";

    @Autowired
    UserGestions userGestions;

    /**
     * Get the registration page.
     * @return the registration page.
     */
    @GetMapping(URL_REGISTER)
    public String getMethodName() {
        return HTML_REGISTER;
    }
    

    /**
     * Get the user from the registration page and save it in the database.
     * @param user - the user getting from the registration form.
     * @return 
     */
    @PostMapping(URL_REGISTER)
    public String postMethodName(@ModelAttribute User user) {
        
        if(userGestions.findUserById(user.getUserName()) == null) {
            userGestions.saveUser(user);
            return URL_REDIRECT_HOMEPAGE;
      } else {
        return HTML_REGISTER;
       }
    }
    
}
