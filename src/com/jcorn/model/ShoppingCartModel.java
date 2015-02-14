package com.jcorn.model;

import com.jcorn.controller.ShoppingCartController;
import com.jcorn.helper.FileHelper;
import com.jcorn.helper.Settings;
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
public class ShoppingCartModel extends AbstractListModel<ShoppingCartItem> implements Iterable<ShoppingCartItem> {

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
        shoppingCart.remove(index);
        super.fireIntervalRemoved(this, index, index);
        if(shoppingCart.isEmpty()) {
            clearAll();
        } else {
            writeOut();
        }
    }
    
    public void edit(ShoppingCartItem item, int index) throws Exception {
        shoppingCart.set(index, item);
        super.fireContentsChanged(this, index, index);
        writeOut();
    }

    public void readAll() throws Exception {
        shoppingCart.clear();
        shoppingCart.addAll(controller.readAll());
        if(shoppingCart.isEmpty()) {
            super.fireIntervalAdded(this, 0, 0);
        }
        else {
            super.fireIntervalAdded(this, 0, shoppingCart.size() - 1);
        }
    }

    public void clearAll() throws Exception {
        FileHelper.clearFile(Settings.getSaveFile());
        readAll();
    }

    public void writeOut() throws Exception {
        FileHelper.clearFile(Settings.getSaveFile());
        controller.writeAll(shoppingCart);
    }

    public double getAllPrice() {
        double price = 0;
        for (ShoppingCartItem item : this) {
            price += item.getPrice();
        }
        return price;
    }

    public List<ShoppingCartItem> getShoppingCart() {
        return shoppingCart;
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
