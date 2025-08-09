package com.caribe.sur.controller.homePage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.caribe.sur.enumerators.listFromClass.HtmlFromPages;
import com.caribe.sur.enumerators.listFromClass.UrlFromPages;
import com.caribe.sur.model.User;
import com.caribe.sur.service.UserGestions;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class Register {

    @Autowired
    UserGestions userGestions;

    /**
     * Get the registration page.
     * 
     * @return the registration page.
     */
    @GetMapping(UrlFromPages.URL_REGISTER)
    public String getMethodName() {
        return HtmlFromPages.HTML_REGISTER;
    }

    /**
     * Get the user from the registration page and save it in the database.
     * 
     * @param user - the user getting from the registration form.
     * @return
     */
    @PostMapping(UrlFromPages.URL_POST_REGISTER)
    public String postMethodName(@ModelAttribute User user) {

        if (userGestions.findUserById(user.getUserName()) == null) {
            userGestions.saveUser(user);
            return UrlFromPages.toRedirect(UrlFromPages.URL_HOME_PAGE);
        } else {
            return HtmlFromPages.HTML_REGISTER;
        }
    }

}
