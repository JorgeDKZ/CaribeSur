package com.caribe.sur.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class AdminHomePageController {

    private final String URL_ADMIN_HOME_PAGE = "AdminHomePage";

    private final String HTML_ADMIN_HOME_PAGE = "AdminPages/AdminHomePage";


    @GetMapping(URL_ADMIN_HOME_PAGE)
    public String getMethodName(@RequestParam String param) {
        return HTML_ADMIN_HOME_PAGE;
    }

 
    

}
