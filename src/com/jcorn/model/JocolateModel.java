package com.jcorn.model;

/**
 * JocolateManager
 * 
 * @author Markus Petritz
 * @version 1.0.0
 * @see http://petritzdesigns.com
 */
public class JocolateModel {
    
    private final String type;
    private final String size;
    private final String logo;
    private final String text;
    private final Integer amount;

    public JocolateModel(String type, String size, String logo, String text, Integer amount) {
        this.type = type;
        this.size = size;
        this.logo = logo;
        this.text = text;
        this.amount = amount;
    }
    
    public JocolateModel(String type, String size, String logo, Integer amount) {
        this.type = type;
        this.size = size;
        this.logo = logo;
        this.text = "";
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public String getSize() {
        return size;
    }

    public String getLogo() {
        return logo;
    }

    public String getText() {
        return text;
    }

    public Integer getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return String.format("%s|%s|%s|%s|%d", type, size, logo, text, amount);
    }
    
    public ShoppingCartItem toShoppingCartItem() {
        if(logo.equals("Text")) {
            return new ShoppingCartItem("Chocolate", type, size, text, amount);
        }
        else {
            return new ShoppingCartItem("Chocolate", type, size, logo, amount);
        }
    }
}
