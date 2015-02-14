package com.jcorn.controller;

import com.jcorn.view.MainViewController;

/**
 * JocolateManager
 * 
 * @author Markus Petritz
 * @version 1.0.0
 * @see http://petritzdesigns.com
 */
public class StatusController {

    private final MainViewController mv;
    
    public StatusController(MainViewController mv) {
        this.mv = mv;
    }
    
    public void set(String text) {
        mv.lbStatus.setText(" " + text);
    }
}
