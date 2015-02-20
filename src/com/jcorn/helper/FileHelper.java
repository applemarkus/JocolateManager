package com.jcorn.helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * JocolateManager
 *
 * @author Markus Petritz
 * @version 1.0.0
 * @see http://petritzdesigns.com
 */
public class FileHelper {

    public static String readAllFrom(String file) throws Exception {
        BufferedReader br = null;
        StringBuilder buffer = new StringBuilder();
        try {
            br = new BufferedReader(new FileReader(file));
            while (br.ready()) {
                buffer.append(br.readLine());
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
        return buffer.toString();
    }

    public static void clearFile(String file) throws Exception {
        try (PrintWriter out = new PrintWriter(file)) {
            out.print("");
            out.flush();
        }
    }

    public static void makeIfNotExist(String file) throws Exception {
        File file_io = new File(file);
        if (!file_io.exists()) {
            String dir = file.substring(0, file.indexOf("/"));
            File dirf = new File(dir);
            dirf.mkdirs();
            file_io.createNewFile();
        }
    }
}
