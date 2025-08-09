package com.caribe.sur.controller.homePage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.caribe.sur.enumerators.listFromClass.HtmlFromPages;
import com.caribe.sur.enumerators.listFromClass.UrlFromPages;
import com.caribe.sur.model.User;
import com.caribe.sur.service.UserGestions;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LogIn {

    @Autowired
    private UserGestions userGestions;

    @GetMapping(UrlFromPages.URL_LOGIN)
    public String getMethodName() {
        return HtmlFromPages.HTML_LOGIN; 
    }
    
    @PostMapping(UrlFromPages.URL_LOGIN)
    public String postMethodName(Model model, @ModelAttribute User user) {
    User userExist = userGestions.findUserById(user.getUserName());

   if(userExist != null && userExist.getPassword().equals(user.getPassword())) {
       return UrlFromPages.toRedirect(UrlFromPages.URL_USER_HOME);
   } else {
       return HtmlFromPages.HTML_LOGIN;
    }  

    }
    

}
