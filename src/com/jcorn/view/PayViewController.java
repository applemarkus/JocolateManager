package com.jcorn.view;

import com.jcorn.helper.JM;
import com.jcorn.model.BillGenerator;
import com.jcorn.model.BillingDetails;
import com.jcorn.model.ShoppingCartItem;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * JocolateManager
 *
 * @author Markus Petritz
 * @version 1.0.0
 * @see http://petritzdesigns.com
 */
public class PayViewController extends javax.swing.JFrame {
    
    private boolean paid;
    private List<ShoppingCartItem> list;
    
    public PayViewController() {
        initComponents();
        paid = false;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        btPay = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        pbProgress = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tfFirstName = new javax.swing.JTextField();
        tfEmail = new javax.swing.JTextField();
        tfPhone = new javax.swing.JTextField();
        tfStreet = new javax.swing.JTextField();
        tfStreetnumber = new javax.swing.JTextField();
        tfZipCode = new javax.swing.JTextField();
        tfCity = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        tfCardNumber = new javax.swing.JTextField();
        tfExpires = new javax.swing.JTextField();
        tfSecurityCode = new javax.swing.JTextField();
        tfCountry = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbInfo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lbPrice = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Pay");
        setAlwaysOnTop(true);
        setMinimumSize(new java.awt.Dimension(742, 498));
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        btPay.setText("Pay & Finish");
        btPay.setToolTipText("");
        btPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onPay(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        getContentPane().add(btPay, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 48)); // NOI18N
        jLabel1.setText("Pay");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(jLabel1, gridBagConstraints);

        pbProgress.setMaximum(11);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        getContentPane().add(pbProgress, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel2.setText("Delivery Address:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        getContentPane().add(jLabel2, gridBagConstraints);

        jLabel3.setText("Name: *");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        getContentPane().add(jLabel3, gridBagConstraints);

        tfName.setColumns(15);
        tfName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfNameKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        getContentPane().add(tfName, gridBagConstraints);

        jLabel4.setText("First Name: *");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        getContentPane().add(jLabel4, gridBagConstraints);

        jLabel5.setText("Phone: *");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        getContentPane().add(jLabel5, gridBagConstraints);

        jLabel6.setText("Email: *");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        getContentPane().add(jLabel6, gridBagConstraints);

        jLabel7.setText("Street: *");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        getContentPane().add(jLabel7, gridBagConstraints);

        jLabel8.setText("Streetnumber: *");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        getContentPane().add(jLabel8, gridBagConstraints);

        jLabel9.setText("Zip Code: *");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        getContentPane().add(jLabel9, gridBagConstraints);

        jLabel10.setText("City: *");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        getContentPane().add(jLabel10, gridBagConstraints);

        tfFirstName.setColumns(15);
        tfFirstName.setText(" ");
        tfFirstName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfFirstNameKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        getContentPane().add(tfFirstName, gridBagConstraints);

        tfEmail.setColumns(15);
        tfEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfEmailKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        getContentPane().add(tfEmail, gridBagConstraints);

        tfPhone.setColumns(15);
        tfPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfPhoneKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        getContentPane().add(tfPhone, gridBagConstraints);

        tfStreet.setColumns(15);
        tfStreet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfStreetKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        getContentPane().add(tfStreet, gridBagConstraints);

        tfStreetnumber.setColumns(15);
        tfStreetnumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfStreetnumberKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        getContentPane().add(tfStreetnumber, gridBagConstraints);

        tfZipCode.setColumns(15);
        tfZipCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfZipCodeKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        getContentPane().add(tfZipCode, gridBagConstraints);

        tfCity.setColumns(15);
        tfCity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfCityKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        getContentPane().add(tfCity, gridBagConstraints);

        jLabel11.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel11.setText("Credit Card:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.insets = new java.awt.Insets(2, 10, 2, 5);
        getContentPane().add(jLabel11, gridBagConstraints);

        jLabel12.setText("Card number: *");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.insets = new java.awt.Insets(2, 10, 2, 5);
        getContentPane().add(jLabel12, gridBagConstraints);

        jLabel13.setText("Expires: *");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.insets = new java.awt.Insets(2, 10, 2, 5);
        getContentPane().add(jLabel13, gridBagConstraints);

        jLabel14.setText("Security Code: *");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.insets = new java.awt.Insets(2, 10, 2, 5);
        getContentPane().add(jLabel14, gridBagConstraints);

        jLabel15.setText("Country: *");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        getContentPane().add(jLabel15, gridBagConstraints);

        tfCardNumber.setColumns(15);
        tfCardNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfCardNumberKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        getContentPane().add(tfCardNumber, gridBagConstraints);

        tfExpires.setColumns(15);
        tfExpires.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfExpiresKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        getContentPane().add(tfExpires, gridBagConstraints);

        tfSecurityCode.setColumns(15);
        tfSecurityCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfSecurityCodeKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        getContentPane().add(tfSecurityCode, gridBagConstraints);

        tfCountry.setColumns(15);
        tfCountry.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfCountryKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        getContentPane().add(tfCountry, gridBagConstraints);

        jLabel16.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("* Required  ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        getContentPane().add(jLabel16, gridBagConstraints);

        jLabel17.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel17.setText("Info:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.insets = new java.awt.Insets(2, 10, 2, 5);
        getContentPane().add(jLabel17, gridBagConstraints);

        lbInfo.setText("There are missing fields.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.insets = new java.awt.Insets(2, 8, 2, 2);
        getContentPane().add(lbInfo, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        getContentPane().add(jSeparator1, gridBagConstraints);

        lbPrice.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        lbPrice.setText("Price: € 0,00");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 7);
        getContentPane().add(lbPrice, gridBagConstraints);

        jButton1.setText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onCancel(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        getContentPane().add(jButton1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void check() {
        String name = tfName.getText();
        String firstName = tfFirstName.getText();
        String email = tfEmail.getText();
        String phone = tfPhone.getText();
        String street = tfStreet.getText();
        String streetNumber = tfStreetnumber.getText();
        String zipCode = tfZipCode.getText();
        String city = tfCity.getText();
        String country = tfCountry.getText();
        String cardNumber = tfCardNumber.getText();
        String expires = tfExpires.getText();
        String securityCode = tfSecurityCode.getText();
        
        if (name.trim().isEmpty()) {
            lbInfo.setText("Name is missing.");
        } else if (firstName.trim().isEmpty()) {
            lbInfo.setText("First Name is missing.");
        } else if (email.trim().isEmpty()) {
            lbInfo.setText("Email is missing.");
        } else if (phone.trim().isEmpty()) {
            lbInfo.setText("Phone is missing.");
        } else if (street.trim().isEmpty()) {
            lbInfo.setText("Street is missing.");
        } else if (streetNumber.trim().isEmpty()) {
            lbInfo.setText("Streetnumber is missing.");
        } else if (zipCode.trim().isEmpty()) {
            lbInfo.setText("ZipCode is missing.");
        } else if (city.trim().isEmpty()) {
            lbInfo.setText("City is missing.");
        } else if (country.trim().isEmpty()) {
            lbInfo.setText("Country is missing.");
        } else if (cardNumber.trim().isEmpty()) {
            lbInfo.setText("Card Number is missing.");
        } else if (expires.trim().isEmpty()) {
            lbInfo.setText("Expires is missing.");
        } else if (securityCode.trim().isEmpty()) {
            lbInfo.setText("Security Code is missing.");
        } else {
            //nothing is missing!
            lbInfo.setText("");
        }
        
        int total = 12;
        int correct = infoIsCorrect(tfName, tfFirstName, tfEmail, tfStreet, tfStreetnumber,
                tfZipCode, tfCity, tfCountry, tfCardNumber,
                tfExpires, tfSecurityCode);
        pbProgress.setMaximum(total - 1);
        pbProgress.setValue(correct);
    }
    
    private int infoIsCorrect(JTextField... textFields) {
        int counter = 0;
        for (JTextField textField : textFields) {
            if (!textField.getText().trim().isEmpty()) {
                counter++;
            }
        }
        return counter;
    }
    
    public boolean isPaid() {
        return paid;
    }
    
    public void setShoppingCartList(List<ShoppingCartItem> list) {
        this.list = list;
    }
    
    public void setPrice(double price) {
        lbPrice.setText(String.format("Price: € %.2f", price));
    }
    
    private void makeBill() throws Exception {
        String name = tfName.getText();
        String firstName = tfFirstName.getText();
        String email = tfEmail.getText();
        String phone = tfPhone.getText();
        String street = tfStreet.getText();
        String streetNumber = tfStreetnumber.getText();
        String zipCode = tfZipCode.getText();
        String city = tfCity.getText();
        String country = tfCountry.getText();
        String cardNumber = tfCardNumber.getText();
        String expires = tfExpires.getText();
        String securityCode = tfSecurityCode.getText();
        
        BillingDetails billingDetails = new BillingDetails(name, firstName, email, phone, street, streetNumber, zipCode, city, country, cardNumber, expires, securityCode);
        BillGenerator gen = new BillGenerator(billingDetails, list);
        gen.createXml();
        JOptionPane.showMessageDialog(this, "Uploading to Server... This can take a moment.");
        gen.sendToWebServer();
    }

    private void onPay(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onPay
        if (lbInfo.getText().isEmpty()) {
            try {
                makeBill();
                JOptionPane.showMessageDialog(this, "Successfully paid.");
                paid = true;
                this.setVisible(false);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
                JM.debug(ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please provide all information with the star");
        }
    }//GEN-LAST:event_onPay

    private void onCancel(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onCancel
        this.setVisible(false);
    }//GEN-LAST:event_onCancel

    private void tfNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNameKeyReleased
        check();
    }//GEN-LAST:event_tfNameKeyReleased

    private void tfFirstNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfFirstNameKeyReleased
        check();
    }//GEN-LAST:event_tfFirstNameKeyReleased

    private void tfEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfEmailKeyReleased
        check();
    }//GEN-LAST:event_tfEmailKeyReleased

    private void tfPhoneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPhoneKeyReleased
        check();
    }//GEN-LAST:event_tfPhoneKeyReleased

    private void tfStreetKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfStreetKeyReleased
        check();
    }//GEN-LAST:event_tfStreetKeyReleased

    private void tfStreetnumberKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfStreetnumberKeyReleased
        check();
    }//GEN-LAST:event_tfStreetnumberKeyReleased

    private void tfZipCodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfZipCodeKeyReleased
        check();
    }//GEN-LAST:event_tfZipCodeKeyReleased

    private void tfCityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCityKeyReleased
        check();
    }//GEN-LAST:event_tfCityKeyReleased

    private void tfCountryKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCountryKeyReleased
        check();
    }//GEN-LAST:event_tfCountryKeyReleased

    private void tfCardNumberKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCardNumberKeyReleased
        check();
    }//GEN-LAST:event_tfCardNumberKeyReleased

    private void tfExpiresKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfExpiresKeyReleased
        check();
    }//GEN-LAST:event_tfExpiresKeyReleased

    private void tfSecurityCodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSecurityCodeKeyReleased
        check();
    }//GEN-LAST:event_tfSecurityCodeKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btPay;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbInfo;
    private javax.swing.JLabel lbPrice;
    private javax.swing.JProgressBar pbProgress;
    private javax.swing.JTextField tfCardNumber;
    private javax.swing.JTextField tfCity;
    private javax.swing.JTextField tfCountry;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfExpires;
    private javax.swing.JTextField tfFirstName;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfPhone;
    private javax.swing.JTextField tfSecurityCode;
    private javax.swing.JTextField tfStreet;
    private javax.swing.JTextField tfStreetnumber;
    private javax.swing.JTextField tfZipCode;
    // End of variables declaration//GEN-END:variables

}
