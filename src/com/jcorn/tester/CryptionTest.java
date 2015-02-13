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
            System.out.println(Crypt.bytesToHex(crypt.encrypt("Yololo\n\n\nahfhajksfhkjashf--------ajlsdfh kjsdhfkjalsdh kljfsad gYololo\n\n\nahfhajksfhkjashf--------ajlsdfh kjsdhfkjalsdh kljfsad gYololo\n\n\nahfhajksfhkjashf--------ajlsdfh kjsdhfkjalsdh kljfsad gYololo\n\n\nahfhajksfhkjashf--------ajlsdfh kjsdhfkjalsdh kljfsad gYololo\n\n\nahfhajksfhkjashf--------ajlsdfh kjsdhfkjalsdh kljfsad gYololo\n\n\nahfhajksfhkjashf--------ajlsdfh kjsdhfkjalsdh kljfsad gYololo\n\n\nahfhajksfhkjashf--------ajlsdfh kjsdhfkjalsdh kljfsad gYololo\n\n\nahfhajksfhkjashf--------ajlsdfh kjsdhfkjalsdh kljfsad gYololo\n\n\nahfhajksfhkjashf--------ajlsdfh kjsdhfkjalsdh kljfsad g")));
        } catch (Exception ex) {
            Logger.getLogger(CryptionTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
