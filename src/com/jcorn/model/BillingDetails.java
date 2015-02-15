package com.jcorn.model;

import java.text.Normalizer;
import java.util.Calendar;

/**
 * JocolateManager
 *
 * @author Markus Petritz
 * @version 1.0.0
 * @see http://petritzdesigns.com
 */
public class BillingDetails {

    private final String name;
    private final String firstName;
    private final String email;
    private final String phone;
    private final String street;
    private final String streetNumber;
    private final String zipCode;
    private final String city;
    private final String country;
    private final String cardNumber;
    private final String expires;
    private final String securityCode;
    private final String date;

    public BillingDetails(String name, String firstName, String email, String phone, String street, String streetNumber, String zipCode, String city, String country, String cardNumber, String expires, String securityCode) {
        this.name = normalize(name);
        this.firstName = normalize(firstName);
        this.email = normalize(email);
        this.phone = normalize(phone);
        this.street = normalize(street);
        this.streetNumber = normalize(streetNumber);
        this.zipCode = normalize(zipCode);
        this.city = normalize(city);
        this.country = normalize(country);
        this.cardNumber = normalize(cardNumber);
        this.expires = normalize(expires);
        this.securityCode = normalize(securityCode);
        this.date = normalize(getTimestamp());
    }

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getStreet() {
        return street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getExpires() {
        return expires;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public String getDate() {
        return date;
    }

    private String getTimestamp() {
        Calendar cal = Calendar.getInstance();
        return "" + cal.getTimeInMillis() / 1000L;
    }

    private String normalize(String input) {
        return Normalizer
                .normalize(input, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "");
    }
}
