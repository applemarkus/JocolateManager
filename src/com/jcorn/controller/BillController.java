package com.jcorn.controller;

import com.jcorn.helper.FileHelper;
import com.jcorn.helper.HTTPRequester;
import com.jcorn.helper.JM;
import com.jcorn.helper.Settings;
import com.jcorn.helper.WebApiLinks;
import com.jcorn.model.Bill;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * JocolateManager
 * 
 * @author Markus Petritz
 * @version 1.0.0
 * @see http://petritzdesigns.com
 */
public class BillController {

    public BillController() {
    }
    
    public List<Bill> getAll() throws Exception {
        String url = WebApiLinks.postGetBills;
        String postParam = WebApiLinks.getPostGetBillsParam();
        String response = HTTPRequester.getContentFromUrlWithPost(url, postParam);
        //Xml parser
        return parseXml(response);
    }
    
    private List<Bill> parseXml(String xmlData) throws Exception {
        List<Bill> temp = new LinkedList<>();
        
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
        document.normalize();
        
        status = document.getDocumentElement().getElementsByTagName("login").item(0).getChildNodes().item(0).getNodeValue();
        error = document.getDocumentElement().getElementsByTagName("error").item(0).getChildNodes().item(0).getNodeValue();
        
        NodeList nList = document.getElementsByTagName("bills").item(0).getChildNodes();
        for(int i = 0; i < nList.getLength(); ++i) {
            Node nNode = nList.item(i);
            if(nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElem = (Element) nNode;
                int id = Integer.parseInt(eElem.getElementsByTagName("id").item(0).getTextContent());
                String name = eElem.getElementsByTagName("name").item(0).getTextContent();
                String date = eElem.getElementsByTagName("date").item(0).getTextContent();
                temp.add(new Bill(id, name, date));
            }
        }
        
        JM.debug("status: "+status);
        JM.debug("error: "+error);
        
        if(!error.equals("none")) {
            throw new Exception(error);
        }
        
        if(status.isEmpty()) {
            status = "Error.. Could not get XML Data";
        }
        
        FileHelper.clearFile(Settings.getTempXmlFile());
        return temp;
    }
}
