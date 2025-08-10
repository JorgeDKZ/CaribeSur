package com.caribe.sur.controller.homePage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.caribe.sur.enumerators.listFromClass.HtmlFromPages;
import com.caribe.sur.enumerators.listFromClass.UrlFromPages;

@Controller
public class LogIn {

    @GetMapping(UrlFromPages.URL_LOGIN)
    public String getMethodName() {
        return HtmlFromPages.HTML_LOGIN;
    }

}
