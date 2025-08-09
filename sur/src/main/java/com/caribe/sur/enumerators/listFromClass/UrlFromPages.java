package com.caribe.sur.enumerators.listFromClass;

public class UrlFromPages {

    public static final String URL_HOME_PAGE = "/home";
    public static final String URL_REGISTER = "/register";
    public static final String URL_LOGIN = "/login";

    public static final String URL_POST_MOVE_TO_REGISTER = "/post/moveToRegister";
    public static final String URL_POST_MOVE_TO_LOGIN = "/post/moveToLogin";
    public static final String URL_POST_REGISTER = "/post/register";
    public static final String URL_POST_LOGIN = "/post/login";

    public static final String URL_USER_HOME = "/user/home";

    public static final String URL_ADMIN_HOME_PAGE = "/admin/home";



    UrlFromPages() { }

    public static String toRedirect(String url) {
        return "redirect:" + url;
    }
}
