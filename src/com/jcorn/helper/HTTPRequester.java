package com.jcorn.helper;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * JocolateManager
 *
 * @author Julian Maierl
 * @version 1.0.0
 * @see http://petritzdesigns.com
 */
public class HTTPRequester {

    private static final String USER_AGENT = "JocolateManager/1.0";

    public static String getContentFromUrl(String host) throws IOException {
        URL obj = new URL(host);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        JM.debug("Sending GET request to URL: " + host);
        JM.debug("Response Code: " + responseCode);

        StringBuffer response;
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()))) {
            String inputLine;
            response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
                response.append("\n");
            }
        }
        return response.toString();
    }

    public static String getContentFromUrlWithPost(String host, String postParams) throws IOException {
        URL obj = new URL(host);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        
        con.setDoOutput(true);
        try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
            wr.writeBytes(postParams);
            wr.flush();
        }

        int responseCode = con.getResponseCode();
        JM.debug("Sending 'POST' request to URL : " + host);
        JM.debug("Post parameters : " + postParams);
        JM.debug("Response Code : " + responseCode);

        StringBuffer response;
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()))) {
            String inputLine;
            response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
                response.append("\n");
            }
        }
        return response.toString();
    }
}
