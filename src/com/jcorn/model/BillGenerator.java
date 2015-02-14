package com.jcorn.model;

import com.jcorn.helper.FileHelper;
import com.jcorn.helper.HTTPRequester;
import com.jcorn.helper.JM;
import com.jcorn.helper.Settings;
import com.jcorn.helper.WebApiLinks;
import java.io.PrintWriter;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * JocolateManager
 *
 * @author Markus Petritz
 * @version 1.0.0
 * @see http://petritzdesigns.com
 */
public class BillGenerator {

    private final BillingDetails details;
    private final List<ShoppingCartItem> list;

    public BillGenerator(BillingDetails details, List<ShoppingCartItem> list) {
        this.details = details;
        this.list = list;
    }

    public void createXml() throws Exception {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        //Root
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("JocolateManager");
        doc.appendChild(rootElement);

        //Details
        Element detailElem = doc.createElement("Details");
        rootElement.appendChild(detailElem);

        //All Elements
        appendElements(doc, detailElem);

        Element shoppingCart = doc.createElement("ShoppingCart");
        rootElement.appendChild(shoppingCart);
        
        appendShoppingCart(doc, shoppingCart);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(Settings.getTempXmlFile());
        transformer.transform(source, result);
    }
    
    public void sendToWebServer() throws Exception {
        String billPlain = FileHelper.readAllFrom(Settings.getTempXmlFile());
        String response = HTTPRequester.getContentFromUrlWithPost(WebApiLinks.postBill, WebApiLinks.getPostBillParam(billPlain));
        parseXml(response);
    }
    
    private void parseXml(String xmlData) throws Exception {
        FileHelper.clearFile(Settings.getTempXmlFile());
        
        String login = "";
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
        status = document.getDocumentElement().getElementsByTagName("bill").item(0).getChildNodes().item(0).getNodeValue();
        error = document.getDocumentElement().getElementsByTagName("error").item(0).getChildNodes().item(0).getNodeValue();
        login = document.getDocumentElement().getElementsByTagName("login").item(0).getChildNodes().item(0).getNodeValue();
        
        JM.debug("status: "+status);
        JM.debug("error: "+error);
        JM.debug("login "+login);
        
        if(!error.equals("none")) {
            throw new Exception(error);
        }
        
        if(status.equals("failure")) {
            throw new Exception("Could not send Bill to Webserver. Please contact your webmaster!");
        }
        
        FileHelper.clearFile(Settings.getTempXmlFile());
    }

    private void appendElements(Document doc, Element elem) throws Exception {
        Element name = doc.createElement("name");
        name.appendChild(doc.createTextNode(details.getName()));
        elem.appendChild(name);
        
        Element firstName = doc.createElement("firstName");
        firstName.appendChild(doc.createTextNode(details.getFirstName()));
        elem.appendChild(firstName);
        
        Element email = doc.createElement("email");
        email.appendChild(doc.createTextNode(details.getEmail()));
        elem.appendChild(email);
        
        Element phone = doc.createElement("phone");
        phone.appendChild(doc.createTextNode(details.getPhone()));
        elem.appendChild(phone);
        
        Element street = doc.createElement("street");
        street.appendChild(doc.createTextNode(details.getStreet()));
        elem.appendChild(street);
        
        Element streetNumber = doc.createElement("streetNumber");
        streetNumber.appendChild(doc.createTextNode(details.getStreetNumber()));
        elem.appendChild(streetNumber);
        
        Element zipCode = doc.createElement("zipCode");
        zipCode.appendChild(doc.createTextNode(details.getZipCode()));
        elem.appendChild(zipCode);
        
        Element city = doc.createElement("city");
        city.appendChild(doc.createTextNode(details.getCity()));
        elem.appendChild(city);
        
        Element country = doc.createElement("country");
        country.appendChild(doc.createTextNode(details.getCountry()));
        elem.appendChild(country);
        
        Element cardNumber = doc.createElement("cardNumber");
        cardNumber.appendChild(doc.createTextNode(details.getCardNumber()));
        elem.appendChild(cardNumber);
        
        Element expires = doc.createElement("expires");
        expires.appendChild(doc.createTextNode(details.getExpires()));
        elem.appendChild(expires);
        
        Element securityCode = doc.createElement("securityCode");
        securityCode.appendChild(doc.createTextNode(details.getSecurityCode()));
        elem.appendChild(securityCode);
        
        Element date = doc.createElement("date");
        date.appendChild(doc.createTextNode(details.getDate()));
        elem.appendChild(date);
    }
    
    private void appendShoppingCart(Document doc, Element elem) throws Exception {
        for (ShoppingCartItem item : list) {
            Element shoppingItem = doc.createElement("ShoppingCartItem");
            elem.appendChild(shoppingItem);
            
            Element name = doc.createElement("name");
            name.appendChild(doc.createTextNode(item.getName()));
            shoppingItem.appendChild(name);
            
            Element type = doc.createElement("type");
            type.appendChild(doc.createTextNode(item.getType()));
            shoppingItem.appendChild(type);
            
            Element size = doc.createElement("size");
            size.appendChild(doc.createTextNode(item.getSize()));
            shoppingItem.appendChild(size);
            
            Element logo = doc.createElement("logo");
            logo.appendChild(doc.createTextNode(item.getLogo()));
            shoppingItem.appendChild(logo);
            
            Element amount = doc.createElement("amount");
            amount.appendChild(doc.createTextNode(item.getAmount() + ""));
            shoppingItem.appendChild(amount);
            
            Element price = doc.createElement("price");
            price.appendChild(doc.createTextNode(String.format("%4.2f", item.getPrice())));
            shoppingItem.appendChild(price);
        }
    }
}
