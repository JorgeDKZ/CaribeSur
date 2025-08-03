package com.caribe.sur.controller.Admin;

import org.springframework.stereotype.Controller;

@Controller
public class AdminHomePage {
    // only one instance of AdminHomePage should exist
    private static final AdminHomePage adminHomePage = null;

    // private constructor to prevent instantiation
    private AdminHomePage() {
        
    }

    // static method to provide access to the single instance
    public static AdminHomePage getInstance() {
        if (adminHomePage == null) {
            return new AdminHomePage();
        }
        return adminHomePage;
    }
}
