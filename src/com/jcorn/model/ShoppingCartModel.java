package com.jcorn.model;

import com.jcorn.controller.ShoppingCartController;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.AbstractListModel;

/**
 * JocolateManager
 * 
 * @author Markus Petritz
 * @version 1.0.0
 * @see http://petritzdesigns.com
 */
public class ShoppingCartModel extends AbstractListModel<ShoppingCartItem> implements Iterable<ShoppingCartItem>{

    private final List<ShoppingCartItem> shoppingCart;
    private final ShoppingCartController controller;

    public ShoppingCartModel(ShoppingCartController controller) {
        this.shoppingCart = new LinkedList<>();
        this.controller = controller;
    }
    
    public void add(ShoppingCartItem item) throws Exception {
        shoppingCart.add(item);
        super.fireIntervalAdded(this, shoppingCart.size() - 1, shoppingCart.size() - 1);
        writeOut();
    }
    
    public void remove(int index) throws Exception {
        if(index > 0) {
            super.fireIntervalRemoved(this, index, index);
            shoppingCart.remove(index);
        }
        writeOut();
    }
    
    public void readAll() throws Exception {
        shoppingCart.addAll(controller.readAll());
        super.fireIntervalAdded(this, 0, shoppingCart.size() - 1);

    }
    
    public void clearAll() {
        //super.fireIntervalRemoved(this, 0, shoppingCart.size() - 1);
        shoppingCart.clear();
    }
    
    public void writeOut() throws Exception {
        controller.writeAll(shoppingCart);
    }
    
    public double getAllPrice() {
        double price = 0;
        for (ShoppingCartItem item : this) {
            price += item.getPrice();
        }
        return price;
    }
    
    @Override
    public int getSize() {
        return shoppingCart.size();
    }

    @Override
    public ShoppingCartItem getElementAt(int index) {
        return shoppingCart.get(index);
    }

    @Override
    public Iterator<ShoppingCartItem> iterator() {
        return shoppingCart.iterator();
    }
    
}
