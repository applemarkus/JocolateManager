package com.jcorn.helper;

/**
 * JocolateManager
 * 
 * @author Markus Petritz
 * @version 1.0.0
 * @see http://petritzdesigns.com
 */
public class Settings {
    
    public static String assetsPath = "src/com/jcorn/assets/";
    public final static boolean isDebug = true;
    
    public static String getAssetPath(String asset) {
        return assetsPath + asset;
    }
}