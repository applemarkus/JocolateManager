package com.jcorn.model;

import com.jcorn.helper.Crypt;
import com.jcorn.helper.FileHelper;
import com.jcorn.helper.HTTPRequester;
import com.jcorn.helper.JM;
import com.jcorn.helper.Settings;
import com.jcorn.helper.WebApiLinks;
import java.io.File;
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
        JM.debug(response);
    }

    private void appendElements(Document doc, Element elem) {
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
}
