package com.caribe.sur.controller.homePage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.caribe.sur.model.User;
import com.caribe.sur.service.UserGestions;

import org.springframework.web.bind.annotation.PostMapping;




@Controller
public class LogIn {

    private final String URL_LOGIN = "/Login";

    private final String HTML_LOGIN = "startPage/Login";
    private final String HTML_USER_HOME_PAGE = "redirect:UserHomePage";

    @Autowired
    private UserGestions userGestions;

    @GetMapping(URL_LOGIN)
    public String getMethodName() {
        return HTML_LOGIN; 
    }
    
    @PostMapping(URL_LOGIN)
    public String postMethodName(Model model, @ModelAttribute User user) {
    User userExist = userGestions.findUserById(user.getUserName());

   if(userExist != null && userExist.getPassword().equals(user.getPassword())) {
       return HTML_USER_HOME_PAGE;
   } else {
       return HTML_LOGIN;
    }  

    }
    

}
