package com.caribe.sur.controller.homePage;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;



@Controller
public class HomePage {

    @GetMapping("/HomePage")
    public String getMethod(Model model) {
        return "HomePage";
    }
    
}
