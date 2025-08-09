package com.caribe.sur.controller.homePage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.caribe.sur.enumerators.listFromClass.HtmlFromPages;
import com.caribe.sur.enumerators.listFromClass.UrlFromPages;
import com.caribe.sur.service.UserGestions;


@Controller
public class LogIn {

    @Autowired
    private UserGestions userGestions;

    @GetMapping(UrlFromPages.URL_LOGIN)
    public String getMethodName() {
        return HtmlFromPages.HTML_LOGIN;
    }

}
