package com.jcorn.controller;

import com.jcorn.model.ShoppingCartItem;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * JocolateManager
 *
 * @author Markus Petritz
 * @version 1.0.0
 * @see http://petritzdesigns.com
 */
public class ShoppingCartController {

    private final String saveFile = "tmp/shopping_car.jdata";

    public ShoppingCartController() {
    }

    public void moveToShoppingCart(ShoppingCartItem item) throws Exception {
        BufferedWriter bw = null;

        try {
            new File("tmp/").mkdir();
            bw = new BufferedWriter(new FileWriter(saveFile, true));
            bw.write(item.toString());
            bw.newLine();
            bw.flush();
        } catch (IOException ex) {
            System.err.println("Oh no... :( " + ex.getLocalizedMessage());
            throw new Exception("I/O Error while writing to shopping car file");
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException ex) {
                    System.err.println("There was really a error on closing... " + ex.getLocalizedMessage());
                    throw new Exception("I/O Error while closing shopping car file.");
                }
            }
        }
    }
    
    public List<ShoppingCartItem> readAll() {
        return null;
    }
}
