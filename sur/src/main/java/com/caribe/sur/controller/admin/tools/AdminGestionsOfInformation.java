package com.caribe.sur.controller.admin.tools;

import org.springframework.stereotype.Controller;

import com.caribe.sur.enumerators.listFromClass.HtmlFromPages;
import com.caribe.sur.enumerators.listFromClass.UrlFromPages;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class AdminGestionsOfInformation {

    @GetMapping(UrlFromPages.URL_ADMIN_SECURITY_COPY)
    public String showSecurityCopy() {
        return HtmlFromPages.HTML_ADMIN_SECURITY;
    }
    
    @PostMapping(UrlFromPages.URL_POST_ADMIN_SECURITY_COPY_BACKUP)
    public String moveToCopyLocal() {
        return UrlFromPages.toRedirect(UrlFromPages.URL_ADMIN_SECURITY_LOCAL_BACKUP_PATH);
    }
    
}
