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

    public ShoppingCartModel() {
        this.shoppingCart = new LinkedList<>();
    }
    
    public void add(ShoppingCartItem item) {
        shoppingCart.add(item);
        super.fireIntervalAdded(this, shoppingCart.size() - 1, shoppingCart.size() - 1);
    }
    
    public void remove(int index) {
        if(index > 0) {
            shoppingCart.remove(index);
            super.fireIntervalRemoved(this, index, index);
        }
    }
    
    public void readAll(ShoppingCartController controller) throws Exception {
        shoppingCart.addAll(controller.readAll());
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
