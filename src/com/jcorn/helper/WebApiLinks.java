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
    public static final String postLogin = api + "login/";
    public static final String postLoginParam = "email=%s&pwd=%s";
    public static final String postBill = api + "incomingBill/";
    public static final String postBillParam = postLoginParam + "&bill=%s";
    
    public static String getLoginApiLink(String username, String password) throws Exception {
        Crypt crypt = new Crypt();
        username = Crypt.bytesToHex(crypt.encrypt(username));
        password = Crypt.bytesToHex(crypt.encrypt(password));
        return String.format(api + loginAction, username, password);
    }
    
    public static String getPostLoginParam(String username, String password) throws Exception {
        Crypt crypt = new Crypt();
        username = Crypt.bytesToHex(crypt.encrypt(username));
        password = Crypt.bytesToHex(crypt.encrypt(password));
        return String.format(postLoginParam, username, password);
    }
    
    public static String getPostBillParam(String bill) throws Exception {
        Crypt crypt = new Crypt();
        bill = Crypt.bytesToHex(crypt.encrypt(bill));
        String username = Crypt.bytesToHex(crypt.encrypt(Settings.currentUser.getUsername()));
        String password = Crypt.bytesToHex(crypt.encrypt(Settings.currentUser.getPassword()));
        return String.format(postBillParam, username, password, bill);
    }
}