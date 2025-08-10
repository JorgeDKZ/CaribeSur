package com.caribe.sur.controller.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.caribe.sur.enumerators.listFromClass.HtmlFromPages;
import com.caribe.sur.enumerators.listFromClass.UrlFromPages;


@Controller
public class Error {

    
    @GetMapping(UrlFromPages.URL_ERROR_ACCESS_DENIED)
    public String getErrorAccessDenied() {
        return HtmlFromPages.HTML_ERROR_ACCESS_DENIED;
    }

    @PostMapping(UrlFromPages.URL_POST_ERROR_ACCESS_DENIED)
    public String postErrorAccessDenied() {
        return UrlFromPages.toRedirect(UrlFromPages.URL_HOME_PAGE);
    }
    
}
