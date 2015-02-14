package com.jcorn.controller;

import com.jcorn.helper.FileHelper;
import com.jcorn.helper.HTTPRequester;
import com.jcorn.helper.JM;
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
        String url = WebApiLinks.postLogin;
        String postParam = WebApiLinks.getPostLoginParam(username, password);
        String response = HTTPRequester.getContentFromUrlWithPost(url, postParam);
        //XML Parser
        String parsedResponse = parseXml(response);
        return parsedResponse;
    }
    
    private String parseXml(String xmlData) throws Exception {
        String status = "";
        String error = "";
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        
        //temp file
        try (
            PrintWriter out = new PrintWriter(Settings.getTempXmlFile())) {
            out.print(xmlData);
            out.flush();
        }
        
        Document document = builder.parse(Settings.getTempXmlFile());
        status = document.getDocumentElement().getElementsByTagName("login").item(0).getChildNodes().item(0).getNodeValue();
        error = document.getDocumentElement().getElementsByTagName("error").item(0).getChildNodes().item(0).getNodeValue();
        
        JM.debug("status: "+status);
        JM.debug("error: "+error);
        
        if(!error.equals("none")) {
            throw new Exception(error);
        }
        
        if(status.isEmpty()) {
            status = "Error.. Could not get XML Data";
        }
        
        FileHelper.clearFile(Settings.getTempXmlFile());
        
        return status;
    }
}
