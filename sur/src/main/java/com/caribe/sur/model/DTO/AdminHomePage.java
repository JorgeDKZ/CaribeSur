package com.caribe.sur.model.DTO;

import java.util.regex.Pattern;

public class AdminHomePage {
    // ATRIBUTES
    // only one instance of AdminHomePage should exist
    private static final AdminHomePage adminHomePage = null;

    // example password, should be securely managed
    private String password = "admin123"; 

    // CONSTRUCTOR
    // private constructor to prevent instantiation
    private AdminHomePage() {
        
    }
    // METHODS
    // static method to provide access to the single instance
    public static AdminHomePage getInstance() {
        if (adminHomePage == null) {
            return new AdminHomePage();
        }
        return adminHomePage;
    }

    // Validate the password
    public boolean validatePassword(String password) {
        return this.password.equals(password);
    }

    // Change the password
    public boolean setPassword(String password) {
        //Comprobe if
        // the password have 8 or more characters
        // at least one letter and one number
        Pattern passwordPattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-zA-Z]).{8,}$");
        
        if (passwordPattern.matcher(password).matches()) {
            this.password = password;
            return true;
        } else {
            return false;
        }
    }

    
}
