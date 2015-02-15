package com.jcorn.model;

import com.jcorn.controller.PackageController;
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
public class DeliveryStatusModel extends AbstractListModel<Package> implements Iterable<Package>{

    private final List<Package> packages;
    private final PackageController controller;

    public DeliveryStatusModel(PackageController controller) {
        this.packages = new LinkedList<>();
        this.controller = controller;
    }
    
    public void getAll() throws Exception {
        packages.clear();
        packages.addAll(controller.getAll());
        if(packages.isEmpty()) {
            super.fireIntervalAdded(this, 0, 0);
        } else {
            super.fireIntervalAdded(this, 0, packages.size() - 1);
        }
    }
    
    @Override
    public int getSize() {
        return packages.size();
    }

    @Override
    public Package getElementAt(int index) {
        return packages.get(index);
    }

    @Override
    public Iterator<Package> iterator() {
        return packages.iterator();
    }
    
}
