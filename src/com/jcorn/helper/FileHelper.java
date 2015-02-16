package com.jcorn.helper;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * JocolateManager
 * 
 * @author Markus Petritz
 * @version 1.0.0
 * @see http://petritzdesigns.com
 */
public class FileHelper {
    public static String readAllFrom(String file) throws IOException {
        return new String(Files.readAllBytes(Paths.get(file)), StandardCharsets.UTF_8);
    }

    public static void clearFile(String file) throws Exception {
        try (PrintWriter out = new PrintWriter(file)) {
            out.print("");
            out.flush();
        }
    }
    
    public static void makeIfNotExist(String file) throws Exception {
        File file_io = new File(file);
        if(!file_io.exists()) {
            String dir = file.substring(0, file.indexOf("/"));
            File dirf = new File(dir);
            dirf.mkdirs();
            file_io.createNewFile();
        }
    }
}
