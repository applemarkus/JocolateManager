package com.jcorn.view;

import com.jcorn.controller.JocolateController;
import com.jcorn.controller.StatusController;
import com.jcorn.helper.JM;
import com.jcorn.model.JocolateModel;
import com.jcorn.model.ShoppingCartItem;
import com.jcorn.model.ShoppingCartModel;
import javax.swing.JOptionPane;

/**
 * JocolateManager
 * 
 * @author Markus Petritz
 * @version 1.0.0
 * @see http://petritzdesigns.com
 */
public class EditItemViewController extends javax.swing.JFrame {

    private final StatusController status;
    private final ShoppingCartModel shoppingCart;
    private int index;
    
    private boolean hasChanged;
    
    public EditItemViewController(StatusController status, ShoppingCartModel shoppingCart) {
        initComponents();
        this.status = status;
        this.shoppingCart = shoppingCart;
    }
    
    public void setItem(JocolateModel item, int index) {
        hasChanged = false;
        this.index = index;
        insertValues(item);
    }

    public boolean isHasChanged() {
        return hasChanged;
    }
    
    private void insertValues(JocolateModel item) {
        cbType.setSelectedItem(item.getType());
        cbSize.setSelectedItem(item.getSize());
        cbLogo.setSelectedItem(item.getLogo());
        tfText.setText(item.getText());
        spinnerAmount.setValue((Integer) item.getAmount());
    }
    
    private void calcPrice() {
        String type = (String) cbType.getSelectedItem();
        String size = (String) cbSize.getSelectedItem();
        String logo = (String) cbLogo.getSelectedItem();
        String text = tfText.getText();
        Integer amount = (Integer) spinnerAmount.getValue();
        JocolateModel joc = new JocolateModel(type, size, logo, text, amount);
        lbPrice.setText(String.format("Price: € %.2f", JocolateController.calculatePrice(joc)));
        hasChanged = true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        paChoose = new javax.swing.JPanel();
        lbType = new javax.swing.JLabel();
        cbType = new javax.swing.JComboBox();
        lbSize = new javax.swing.JLabel();
        cbSize = new javax.swing.JComboBox();
        lbLogo = new javax.swing.JLabel();
        cbLogo = new javax.swing.JComboBox();
        lbText = new javax.swing.JLabel();
        tfText = new javax.swing.JTextField();
        lbAmount = new javax.swing.JLabel();
        spinnerAmount = new javax.swing.JSpinner();
        btToShoppingCart = new javax.swing.JButton();
        lbPrice = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setTitle("Edit Item");
        setMinimumSize(new java.awt.Dimension(409, 346));
        setResizable(false);

        paChoose.setLayout(new java.awt.GridBagLayout());

        lbType.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbType.setText("Type");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 9, 4, 9);
        paChoose.add(lbType, gridBagConstraints);

        cbType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "milk chocolate", "white chocolate", "dark chocolate", "pure cocoa chocolate" }));
        cbType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTypeonTypeChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        paChoose.add(cbType, gridBagConstraints);

        lbSize.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbSize.setText("Size");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 9, 4, 9);
        paChoose.add(lbSize, gridBagConstraints);

        cbSize.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ultra-big", "big", "middle", "small", "slim" }));
        cbSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSizeonSizeChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        paChoose.add(cbSize, gridBagConstraints);

        lbLogo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbLogo.setText("Logo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 9, 4, 9);
        paChoose.add(lbLogo, gridBagConstraints);

        cbLogo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Default", "PetritzDesigns", "jCorn", "Happy Birthday", "Text" }));
        cbLogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLogoonLogoChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        paChoose.add(cbLogo, gridBagConstraints);

        lbText.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbText.setText("Text");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 9, 4, 9);
        paChoose.add(lbText, gridBagConstraints);

        tfText.setEnabled(false);
        tfText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfTextonTextReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        paChoose.add(tfText, gridBagConstraints);

        lbAmount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbAmount.setText("Amount");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 9, 4, 9);
        paChoose.add(lbAmount, gridBagConstraints);

        spinnerAmount.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerAmountonAmountChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        paChoose.add(spinnerAmount, gridBagConstraints);

        btToShoppingCart.setText("Update");
        btToShoppingCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btToShoppingCarttoShoppingCart(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 6, 0);
        paChoose.add(btToShoppingCart, gridBagConstraints);

        lbPrice.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        lbPrice.setText("Change Values for price calculation");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        paChoose.add(lbPrice, gridBagConstraints);

        getContentPane().add(paChoose, java.awt.BorderLayout.CENTER);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Edit Item");
        jLabel1.setToolTipText("");
        getContentPane().add(jLabel1, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbTypeonTypeChanged(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTypeonTypeChanged
        calcPrice();
    }//GEN-LAST:event_cbTypeonTypeChanged

    private void cbSizeonSizeChanged(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSizeonSizeChanged
        calcPrice();
    }//GEN-LAST:event_cbSizeonSizeChanged

    private void cbLogoonLogoChanged(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLogoonLogoChanged
        calcPrice();
        if (cbLogo.getSelectedItem().equals("Text")) {
            tfText.setEnabled(true);
        } else {
            tfText.setEnabled(false);
        }
    }//GEN-LAST:event_cbLogoonLogoChanged

    private void tfTextonTextReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTextonTextReleased
        calcPrice();
    }//GEN-LAST:event_tfTextonTextReleased

    private void spinnerAmountonAmountChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerAmountonAmountChanged
        Integer value = (Integer) spinnerAmount.getValue();
        if (value <= 1) {
            value = 1;
        }
        if (value >= 99999) {
            value = 99999;
        }
        spinnerAmount.setValue(value);
        calcPrice();
    }//GEN-LAST:event_spinnerAmountonAmountChanged

    private void btToShoppingCarttoShoppingCart(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btToShoppingCarttoShoppingCart
        try {
            status.set("Updated Item");
            String type = (String) cbType.getSelectedItem();
            String size = (String) cbSize.getSelectedItem();
            String logo = (String) cbLogo.getSelectedItem();
            String text = tfText.getText();
            Integer amount = (Integer) spinnerAmount.getValue();
            JocolateModel joc = new JocolateModel(type, size, logo, text, amount);
            ShoppingCartItem item = joc.toShoppingCartItem();
            shoppingCart.edit(item, index);
            this.setVisible(false);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            JM.debug(ex.getMessage());
        }
    }//GEN-LAST:event_btToShoppingCarttoShoppingCart

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btToShoppingCart;
    private javax.swing.JComboBox cbLogo;
    private javax.swing.JComboBox cbSize;
    private javax.swing.JComboBox cbType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbAmount;
    private javax.swing.JLabel lbLogo;
    private javax.swing.JLabel lbPrice;
    private javax.swing.JLabel lbSize;
    private javax.swing.JLabel lbText;
    private javax.swing.JLabel lbType;
    private javax.swing.JPanel paChoose;
    private javax.swing.JSpinner spinnerAmount;
    private javax.swing.JTextField tfText;
    // End of variables declaration//GEN-END:variables

}
