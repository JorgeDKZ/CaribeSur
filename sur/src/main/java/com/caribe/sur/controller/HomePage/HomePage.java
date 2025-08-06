package com.caribe.sur.controller.homePage;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;



@Controller
public class HomePage {

    private final String URL_HOMEPAGE = "/HomePage";

    private final String HTML_HOMEPAGE = "startPage/HomePage";

    @GetMapping(URL_HOMEPAGE)
    public String getMethod(Model model) {
        return HTML_HOMEPAGE;
    }
    
}
