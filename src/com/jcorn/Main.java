package com.jcorn;

import com.jcorn.helper.JM;
import com.jcorn.view.MainViewController;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * JocolateManager
 * 
 * @author Markus Petritz
 * @version 1.0.0
 * @see http://petritzdesigns.com
 */
public class Main {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            JM.debug(ex.getMessage());
        }
        java.awt.EventQueue.invokeLater(() -> {
            MainViewController mv = new MainViewController();
            mv.setVisible(true);
        });
    }

}
