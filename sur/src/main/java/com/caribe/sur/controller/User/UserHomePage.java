package com.caribe.sur.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.caribe.sur.enumerators.listFromClass.HtmlFromPages;
import com.caribe.sur.enumerators.listFromClass.UrlFromPages;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserHomePage {

    @GetMapping(UrlFromPages.URL_USER_HOME)
    public String showHomePage() {
        return HtmlFromPages.HTML_USER_HOME;
    }

    @PostMapping(UrlFromPages.URL_USER_TO_SEE_FLIGHT)
    public String postMoveToFlight() {

        return UrlFromPages.toRedirect(UrlFromPages.URL_USER_FLIGHT);
    }

    @PostMapping(UrlFromPages.URL_USER_TO_SEE_TICKETS)
    public String postMoveToTickets() {

        return UrlFromPages.toRedirect(UrlFromPages.URL_USER_SEE_TICKETS);
    }

    @PostMapping(UrlFromPages.URL_USER_TO_CHANGE_PASSWORD)
    public String postMoveToChangePassword() {

        return UrlFromPages.toRedirect(UrlFromPages.URL_USER_CHANGE_PASSWORD);
    }

    @PostMapping(UrlFromPages.URL_USER_TO_HOMEPAGE)
    public String postMoveToHomePage() {

        return UrlFromPages.toRedirect(UrlFromPages.URL_USER_HOME);
    }
}
