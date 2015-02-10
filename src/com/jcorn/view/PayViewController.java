package com.jcorn.view;

/**
 * JocolateManager
 * 
 * @author Markus Petritz
 * @version 1.0.0
 * @see http://petritzdesigns.com
 */
public class PayViewController extends javax.swing.JFrame {

    public PayViewController() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btClose = new javax.swing.JButton();

        setTitle("Pay");
        setAlwaysOnTop(true);
        getContentPane().setLayout(new java.awt.GridLayout());

        btClose.setText("Close");
        btClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClose(evt);
            }
        });
        getContentPane().add(btClose);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void onClose(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onClose
        this.setVisible(false);
    }//GEN-LAST:event_onClose

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btClose;
    // End of variables declaration//GEN-END:variables

}
