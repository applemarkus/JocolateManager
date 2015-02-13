package com.jcorn.tester;

import com.jcorn.helper.Crypt;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * JocolateManager
 * 
 * @author Markus Petritz
 * @version 1.0.0
 * @see http://petritzdesigns.com
 */
public class CryptionTest {

    public static void main(String[] args) {
        Crypt crypt = new Crypt();
        try {
            System.out.println(Crypt.bytesToHex(crypt.encrypt("admin@me.com")));
            System.out.println(Crypt.bytesToHex(crypt.encrypt("hack4fun")));
        } catch (Exception ex) {
            Logger.getLogger(CryptionTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
