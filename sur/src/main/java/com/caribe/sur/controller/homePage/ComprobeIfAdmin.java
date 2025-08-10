package com.caribe.sur.controller.homePage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.caribe.sur.enumerators.listFromClass.UrlFromPages;
import com.caribe.sur.service.CheckUser;

@Controller
public class ComprobeIfAdmin {

    @Autowired
    private CheckUser checkUser;

    @GetMapping(UrlFromPages.URL_COMPROBE_IF_ADMIN)
    public String getMethodName() {
        if (checkUser.isUserAdmin()) {
            return UrlFromPages.toRedirect(UrlFromPages.URL_ADMIN_HOME_PAGE);
        } else {
            return UrlFromPages.toRedirect(UrlFromPages.URL_USER_HOME);
        }
    }

}
