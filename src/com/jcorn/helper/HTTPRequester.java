package com.jcorn.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * JocolateManager
 *
 * @author Julian Maierl
 * @version 1.0.0
 * @see http://petritzdesigns.com
 */
public class HTTPRequester {

    private static final String USER_AGENT = "Mozilla/5.0";

    public static String getContentFromUrl(String host) throws MalformedURLException, IOException {
        URL obj = new URL(host);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
//        System.out.println("\nSending 'GET' request to URL : " + host);
//        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
            response.append("\n");
        }
        in.close();
        return response.toString();
    }
}
