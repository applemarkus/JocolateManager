package com.jcorn.model;

/**
 * JocolateManager
 * 
 * @author Markus Petritz
 * @version 1.0.0
 * @see http://petritzdesigns.com
 */
public class ShoppingCartItem {
    
    private final String name;
    private final String type;
    private final String size;
    private final String logo;
    private Integer amount;

    public ShoppingCartItem(String name, String type, String size, String logo, Integer amount) {
        this.name = name;
        this.type = type;
        this.size = size;
        this.logo = logo;
        this.amount = amount;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
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

    @Override
    public String toString() {
        return String.format("%s|%s|%s|%s|%d", name, type, size, logo, amount);
    }
}
