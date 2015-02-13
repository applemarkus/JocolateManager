package com.jcorn.helper;

/**
 * JocolateManager
 * 
 * @author Markus Petritz
 * @version 1.0.0
 * @see http://petritzdesigns.com
 */
public class WebApiLinks {
    
    public static final String api = "http://jocolate:25001/index.php/api/";
    public static final String loginAction = "login/?email=%s&pwd=%s";
    
    public static String getLoginApiLink(String username, String password) throws Exception {
        Crypt crypt = new Crypt();
        username = Crypt.bytesToHex(crypt.encrypt(username));
        password = Crypt.bytesToHex(crypt.encrypt(password));
        return String.format(api + loginAction, username, password);
    }
}