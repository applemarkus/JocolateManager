package com.jcorn.controller;

import com.jcorn.helper.HTTPRequester;
import com.jcorn.helper.Settings;
import com.jcorn.helper.WebApiLinks;
import java.io.PrintWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

/**
 * JocolateManager
 *
 * @author Markus Petritz
 * @version 1.0.0
 * @see http://petritzdesigns.com
 */
public class LoginController {

    public String login(String username, String password) throws Exception {
        String url = WebApiLinks.getLoginApiLink(username, password);
        String response = HTTPRequester.getContentFromUrl(url);
        //XML Parser
        String parsedResponse = parseXml(response);
        return parsedResponse;
    }
    
    private String parseXml(String xmlData) throws Exception {
        String status = "";
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        
        //temp file
        try (
            PrintWriter out = new PrintWriter(Settings.getTempXmlFile())) {
            out.print(xmlData);
        }
        
        Document document = builder.parse(Settings.getTempXmlFile());
        status = document.getDocumentElement().getElementsByTagName("login").item(0).getChildNodes().item(0).getNodeValue();
        
        if(status.isEmpty()) {
            status = "Error.. Could not get XML Data";
        }
        
        return status;
    }
}
