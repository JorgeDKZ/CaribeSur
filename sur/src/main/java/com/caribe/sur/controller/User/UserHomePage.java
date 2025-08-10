package com.caribe.sur.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.caribe.sur.enumerators.listFromClass.UrlFromPages;


@Controller
public class UserHomePage {

    
 
    @GetMapping(UrlFromPages.URL_USER_HOME)
    public String getMethodName() {
        return "";
    }
    

}
