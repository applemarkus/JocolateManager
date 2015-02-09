package com.jcorn.controller;

import com.jcorn.view.MainView;

/**
 * JocolateManager
 * 
 * @author Markus Petritz
 * @version 1.0.0
 * @see http://petritzdesigns.com
 */
public class StatusController {

    private final MainView mv;
    
    public StatusController(MainView mv) {
        this.mv = mv;
    }
    
    public void set(String text) {
        mv.lbStatus.setText(text);
    }
}
