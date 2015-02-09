package com.jcorn.helper;

/**
 * JocolateManager
 * 
 * @author Markus Petritz
 * @version 1.0.0
 * @see http://petritzdesigns.com
 */
public class WebApiLinks {
    
    public static final String api = "http://jocolate.petritzdesigns.at/webapi/index.php";
    public static final String loginAction = "?action=login";
    
    public static String getLoginApiLink(String username, String password) {
        return api + loginAction + "&username=" + username + "&password" + password;
    }
}