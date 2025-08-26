package com.caribe.sur.enumerators.listFromClass;

public class UrlFromPages {
    // Url from the home pages
    public static final String URL_HOME_PAGE = "/home";
    public static final String URL_REGISTER = "/register";
    public static final String URL_LOGIN = "/login";
    public static final String URL_COMPROBE_IF_ADMIN = "/user/comprobeIfAdmin";
    public static final String URL_LOGOUT = "/logout";
    // Post from the home pages
    public static final String URL_POST_MOVE_TO_REGISTER = "/moveToRegister";
    public static final String URL_POST_MOVE_TO_LOGIN = "/moveToLogin";
    public static final String URL_POST_REGISTER = "/register";
    public static final String URL_POST_LOGIN = "/login";
    public static final String URL_POST_LOGOUT = "/logout";
    // Url from the admin pages
    public static final String URL_ADMIN_HOME_PAGE = "/admin/home";
    public static final String URL_ADMIN_CHANGE_PASSWORD = "/admin/changePassword";
    public static final String URL_ADMIN_SECURITY_COPY = "/admin/security";
    public static final String URL_ADMIN_API_SECURITY_COPY = "/admin/api/security";
    public static final String URL_ADMIN_SECURITY_LOCAL_BACKUP = "/backup";
    public static final String URL_ADMIN_SECURITY_LOCAL_BACKUP_PATH = URL_ADMIN_API_SECURITY_COPY
            + URL_ADMIN_SECURITY_LOCAL_BACKUP;
    public static final String URL_ADMIN_PLANES_NEW_PLANES = "/admin/newPlanes";
    public static final String URL_ADMIN_PLANES_INFORMATION_PLANES = "/admin/informationPlanes";
    public static final String URL_ADMIN_PLANES_ = "/admin/post/planes";
    // Post from the admin pages
    public static final String URL_POST_MOVE_TO_ADMIN_CHANGE_PASSWORD = "/admin/post/moveToChangePassword";
    public static final String URL_POST_MOVE_TO_ADMIN_NEW_PLANE = "/admin/post/newPlane";
    public static final String URL_POST_MOVE_TO_ADMIN_CREATE_NEW_PLANE = "/admin/post/createNewPlane";
    public static final String URL_POST_MOVE_TO_ADMIN_INFORMATION_PLANE = "/admin/post/informationPlanes";
    public static final String URL_POST_MOVE_TO_ADMIN_VIEW_INFORMATION_PLANE = "/admin/post/viewInformationPlanes";
    public static final String URL_POST_MOVE_TO_ADMIN_SECURITY_COPY_LOCAL = "/admin/post/security";
    public static final String URL_POST_MOVE_TO_ADMIN_DELETE_ALL_DATA = "/admin/post/deleteAllData";
    public static final String URL_POST_ADMIN_CHANGE_PASSWORD = "/admin/changePassword";
    public static final String URL_POST_ADMIN_SECURITY_COPY_BACKUP = "/admin/security/backup";
    public static final String URL_POST_ADMIN_SECURITY_COPY_RESTORE = "/restore";
    public static final String URL_ADMIN_SECURITY_COPY_RESTORE_PATH = URL_ADMIN_API_SECURITY_COPY
            + URL_POST_ADMIN_SECURITY_COPY_RESTORE;
    public static final String URL_POST_ADMIN_SECURITY_LOCAL_RESTORE = URL_ADMIN_API_SECURITY_COPY + "/restore";
    // Url from the user pages
    public static final String URL_USER_HOME = "/user/home";

    // Post from the user pages

    // Url from the error pages
    public static final String URL_ERROR_ACCESS_DENIED = "/accessDenied";

    // Post from the error pages
    public static final String URL_POST_ERROR_ACCESS_DENIED = "/accessDenied";

    UrlFromPages() {
    }

    public static String toRedirect(String url) {
        return "redirect:" + url;
    }
}
