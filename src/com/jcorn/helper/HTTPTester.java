package com.jcorn.helper;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Julian
 */
public class HTTPTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            System.out.println(HTTPRequester.getContentFromUrl("http://google.at"));
        } catch (IOException ex) {
            System.out.println("Didn't work");
        }
    }
    
}
