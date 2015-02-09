package com.jcorn;

import com.jcorn.view.MainView;

/**
 * JocolateManager
 * 
 * @author Markus Petritz
 * @version 1.0.0
 * @see http://petritzdesigns.com
 */
public class Main {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            MainView mv = new MainView();
            mv.setVisible(true);
        });
    }

}
