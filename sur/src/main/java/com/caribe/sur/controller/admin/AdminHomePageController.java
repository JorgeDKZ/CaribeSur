package com.caribe.sur.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.caribe.sur.enumerators.listFromClass.HtmlFromPages;
import com.caribe.sur.enumerators.listFromClass.UrlFromPages;

@Controller
public class AdminHomePageController {

    @GetMapping(UrlFromPages.URL_ADMIN_HOME_PAGE)
    public String getMethodName() {
        return HtmlFromPages.HTML_ADMIN_HOME;
    }

    

}
