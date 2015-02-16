package com.jcorn.helper;

import com.jcorn.model.User;

/**
 * JocolateManager
 * 
 * @author Markus Petritz
 * @version 1.0.0
 * @see http://petritzdesigns.com
 */
public class Settings {
    
    public static final String assetsPath = "src/com/jcorn/assets/";
    public static final String tempXmlFile = "tmp/xml.jdata";
    public static final String saveFile = "tmp/shopping_cart_";
    public static final String extension = ".jdata";
    public static final String splitChar = "|";
    public final static boolean isDebug = true;
    
    public static User currentUser;
    
    public static String getAssetPath(String asset) {
        return assetsPath + asset;
    }

    public static String getSaveFile() throws Exception {
        return saveFile + Settings.currentUser.getUsername() + extension;
    }

    public static String getTempXmlFile() {
        return tempXmlFile;
    }

    public static String getSplitChar() {
        return splitChar;
    }

    public static void setCurrentUser(User currentUser) {
        Settings.currentUser = currentUser;
    }
}