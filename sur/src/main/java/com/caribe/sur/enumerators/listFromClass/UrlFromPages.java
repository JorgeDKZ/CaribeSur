package com.caribe.sur.enumerators.listFromClass;

public class UrlFromPages {

    public static final String URL_HOME_PAGE = "/home";
    public static final String URL_REGISTER = "/register";
    public static final String URL_LOGIN = "/login";
    public static final String URL_COMPROBE_IF_ADMIN = "/user/comprobeIfAdmin";
    public static final String URL_LOGOUT = "/logout";

    public static final String URL_POST_MOVE_TO_REGISTER = "/moveToRegister";
    public static final String URL_POST_MOVE_TO_LOGIN = "/moveToLogin";
    public static final String URL_POST_REGISTER = "/register";
    public static final String URL_POST_LOGIN = "/login";
    public static final String URL_POST_LOGOUT= "/logout";

    public static final String URL_ADMIN_HOME_PAGE = "/admin/home";
    public static final String URL_ADMIN_CHANGE_PASSWORD = "/admin/changePassword";
    public static final String URL_ADMIN_SECURITY_COPY = "/admin/security";
    public static final String URL_ADMIN_API_SECURITY_COPY = "/admin/api/security";
    public static final String URL_ADMIN_SECURITY_LOCAL_BACKUP = "/backup";
    public static final String URL_ADMIN_SECURITY_LOCAL_BACKUP_PATH = URL_ADMIN_API_SECURITY_COPY + URL_ADMIN_SECURITY_LOCAL_BACKUP;

    public static final String URL_POST_MOVE_TO_ADMIN_CHANGE_PASSWORD = "/admin/post/moveToChangePassword";
    public static final String URL_POST_MOVE_TO_ADMIN_CREATE_NEW_PLANE = "/admin/post/createNewPlane";
    public static final String URL_POST_MOVE_TO_ADMIN_INFORMATION_PLANES = "/admin/post/informationPlanes";
    public static final String URL_POST_MOVE_TO_ADMIN_SECURITY_COPY_LOCAL = "/admin/post/security";
    public static final String URL_POST_MOVE_TO_ADMIN_DELETE_ALL_DATA = "/admin/post/deleteAllData";
    public static final String URL_POST_ADMIN_CHANGE_PASSWORD = "/admin/changePassword";
    public static final String URL_POST_ADMIN_SECURITY_COPY_BACKUP = "/admin/security/backup";
    public static final String URL_POST_ADMIN_SECURITY_COPY_RESTORE = "/restore";
    public static final String URL_ADMIN_SECURITY_COPY_RESTORE_PATH = URL_ADMIN_API_SECURITY_COPY + URL_POST_ADMIN_SECURITY_COPY_RESTORE;  
 

    public static final String URL_POST_ADMIN_SECURITY_LOCAL_RESTORE = URL_ADMIN_API_SECURITY_COPY + "/restore";


    public static final String URL_USER_HOME = "/user/home";

    public static final String URL_POST_ERROR_ACCESS_DENIED = "/accessDenied";

    public static final String URL_ERROR_ACCESS_DENIED = "/accessDenied";

    UrlFromPages() {
    }

    public static String toRedirect(String url) {
        return "redirect:" + url;
    }
}
