package com.caribe.sur.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.caribe.sur.enumerators.listFromClass.HtmlFromPages;
import com.caribe.sur.enumerators.listFromClass.UrlFromPages;

@Controller
public class AdminHomePageController {

    @GetMapping(UrlFromPages.URL_ADMIN_HOME_PAGE)
    public String getAdminHome() {
        return HtmlFromPages.HTML_ADMIN_HOME;
    }

    @PostMapping(UrlFromPages.URL_POST_MOVE_TO_ADMIN_CHANGE_PASSWORD)
    public String postPassword() {
        return UrlFromPages.toRedirect(UrlFromPages.URL_ADMIN_CHANGE_PASSWORD);
    }

    @PostMapping(UrlFromPages.URL_POST_MOVE_TO_ADMIN_SECURITY_COPY_LOCAL)
    public String postSecurity() {
        return UrlFromPages.toRedirect(UrlFromPages.URL_ADMIN_SECURITY_COPY);
    }

    @PostMapping(UrlFromPages.URL_POST_MOVE_TO_ADMIN_NEW_PLANE)
    public String postNewPlanes() {
        return UrlFromPages.toRedirect(UrlFromPages.URL_ADMIN_PLANES_NEW_PLANES);
    }

    @PostMapping(UrlFromPages.URL_POST_MOVE_TO_ADMIN_INFORMATION_PLANE)
    public String postInformationPlane() {
        return UrlFromPages.toRedirect(UrlFromPages.URL_ADMIN_PLANES_INFORMATION_PLANES);
    }

}
