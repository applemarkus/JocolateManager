package com.jcorn.controller;

import com.jcorn.helper.Settings;
import com.jcorn.model.ShoppingCartItem;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * JocolateManager
 *
 * @author Markus Petritz
 * @version 1.0.0
 * @see http://petritzdesigns.com
 */
public class ShoppingCartController {

    public ShoppingCartController() {
    }

    public void moveToShoppingCart(ShoppingCartItem item) throws Exception {
        BufferedWriter bw = null;

        try {
            new File("tmp/").mkdir();
            bw = new BufferedWriter(new FileWriter(Settings.getSaveFile(), true));
            bw.write(item.toFileString());
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

    public List<ShoppingCartItem> readAll() throws Exception {
        File saveFile;

        List<ShoppingCartItem> tmp = new LinkedList<>();
        BufferedReader br = null;

        try {
            saveFile = new File(Settings.getSaveFile());

            if (!saveFile.exists() || !saveFile.canRead()) {
                saveFile.createNewFile();
            }

            br = new BufferedReader(new FileReader(saveFile));
            while (br.ready()) {
                tmp.add(parseLine(br.readLine()));
            }
        } catch (IOException ex) {
            System.err.println("Oh no... :( " + ex.getLocalizedMessage());
            throw new Exception("I/O Error while writing to shopping car file");
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException ex) {
                    System.err.println("There was really a error on closing... " + ex.getLocalizedMessage());
                    throw new Exception("I/O Error while closing shopping car file.");
                }
            }
        }
        return tmp;
    }

    private ShoppingCartItem parseLine(String line) {
        //Parse
        //%s|%s|%s|%s|%d
        //name, type, size, logo/text, amount
        String[] strings = line.split(Pattern.quote(Settings.getSplitChar()));
        String name = strings[0];
        String type = strings[1];
        String size = strings[2];
        String logo_text = strings[3];
        Integer amount = Integer.parseInt(strings[4]);
        return new ShoppingCartItem(name, type, size, logo_text, amount);
    }

    public void writeAll(List<ShoppingCartItem> list) throws Exception {
        BufferedWriter bw = null;

        try {
            new File("tmp/").mkdir();
            bw = new BufferedWriter(new FileWriter(Settings.getSaveFile(), false));

            for (ShoppingCartItem item : list) {
                bw.write(item.toFileString());
                bw.newLine();
            }

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
}
