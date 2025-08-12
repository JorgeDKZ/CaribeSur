package com.caribe.sur.controller.admin.tools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.caribe.sur.enumerators.listFromClass.HtmlFromPages;
import com.caribe.sur.enumerators.listFromClass.UrlFromPages;
import com.caribe.sur.service.CheckUser;
import com.caribe.sur.service.UserGestions;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminPassword {

    @Autowired
    private UserGestions userGestions;
    @Autowired
    private CheckUser checkUser;

    @GetMapping(UrlFromPages.URL_ADMIN_CHANGE_PASSWORD)
    public String getChangePassword() {
        return HtmlFromPages.HTML_ADMIN_CHANGE_PASSWORD;
    }

    @PostMapping(UrlFromPages.URL_POST_ADMIN_CHANGE_PASSWORD)
    public String postChangePassword(Model model, @RequestParam String oldPassword, @RequestParam String newPassword) {

        if (userGestions.changePassword(checkUser.getUserName(), oldPassword, newPassword)) {
            return UrlFromPages.toRedirect(UrlFromPages.URL_ADMIN_HOME_PAGE);
        } else {
            return HtmlFromPages.HTML_ADMIN_CHANGE_PASSWORD;
        }

    }

}
