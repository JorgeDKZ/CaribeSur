package com.caribe.sur.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AdminHomePageController {

    private final String ADMIN_HOME_PAGE = "AdminPages/AdminHomePage";


    @GetMapping("AdminHomePage")
    public String getMethodName(@RequestParam String param) {
        return ADMIN_HOME_PAGE;
    }

}
