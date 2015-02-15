package com.jcorn.model;

import com.jcorn.controller.BillController;
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
public class BillModel extends AbstractListModel<Bill> implements Iterable<Bill> {

    private final List<Bill> bills;
    private final BillController controller;

    public BillModel(BillController controller) {
        this.bills = new LinkedList<>();
        this.controller = controller;
    }
    
    public void getAll() throws Exception {
        bills.clear();
        bills.addAll(controller.getAll());
        if(bills.isEmpty()) {
            super.fireIntervalAdded(this, 0, 0);
        } else {
            super.fireIntervalAdded(this, 0, bills.size() - 1);
        }
    }
    
    @Override
    public int getSize() {
        return bills.size();
    }

    @Override
    public Bill getElementAt(int index) {
        return bills.get(index);
    }

    @Override
    public Iterator<Bill> iterator() {
        return bills.iterator();
    }
    
}
