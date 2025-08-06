package com.caribe.sur.controller.user;

import org.springframework.stereotype.Controller;

@Controller
public class UserHomePage {

    private static final UserHomePage userHomePage = null;

    private UserHomePage() {
        
    }

    public static UserHomePage getInstance() {
        if (userHomePage == null) {
            return new UserHomePage();
        }
        return userHomePage;
    }

}
