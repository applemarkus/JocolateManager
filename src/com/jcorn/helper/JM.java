package com.jcorn.helper;

/**
 * JocolateManager
 *
 * @author Markus Petritz
 * @version 1.0.0
 * @see http://petritzdesigns.com
 */
public class JM {

    public static void debug(Exception ex) {
        if(Settings.isDebug) {
            System.err.println("Message: "+ex.getMessage());
            System.err.println("Exception: "+ex.toString());
            ex.printStackTrace();
        }
    }
    
    public static void debug(String text) {
        if(Settings.isDebug) {
            System.out.println(text);
        }
    }
}
