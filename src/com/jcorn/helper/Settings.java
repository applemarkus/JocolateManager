package com.jcorn.helper;

/**
 * JocolateManager
 * 
 * @author Markus Petritz
 * @version 1.0.0
 * @see http://petritzdesigns.com
 */
public class Settings {
    
    public static final String assetsPath = "src/com/jcorn/assets/";
    public static final String saveFile = "tmp/shopping_car.jdata";
    public static final String splitChar = "|";
    public final static boolean isDebug = true;
    
    public static String getAssetPath(String asset) {
        return assetsPath + asset;
    }

    public static String getSaveFile() {
        return saveFile;
    }

    public static String getSplitChar() {
        return splitChar;
    }
}