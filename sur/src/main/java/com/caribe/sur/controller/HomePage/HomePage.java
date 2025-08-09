package com.caribe.sur.controller.homePage;

import org.springframework.web.bind.annotation.GetMapping;

import com.caribe.sur.enumerators.listFromClass.HtmlFromPages;
import com.caribe.sur.enumerators.listFromClass.UrlFromPages;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomePage {

    @GetMapping(UrlFromPages.URL_HOME_PAGE)
    public String getMethod(Model model) {
        return HtmlFromPages.HTML_HOME_PAGE;
    }

    @PostMapping(UrlFromPages.URL_POST_MOVE_TO_REGISTER)
    public String moveToRegister() {

        return UrlFromPages.toRedirect(UrlFromPages.URL_REGISTER);
    }

    @PostMapping(UrlFromPages.URL_POST_MOVE_TO_LOGIN)
    public String moveToLogin() {

        return UrlFromPages.toRedirect(UrlFromPages.URL_LOGIN);
    }
}
