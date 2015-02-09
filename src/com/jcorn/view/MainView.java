package com.jcorn.view;

import com.jcorn.controller.LoginController;
import com.jcorn.helper.FileHelper;
import com.jcorn.helper.Settings;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * JocolateManager
 *
 * @author Markus Petritz
 * @version 1.0.0
 * @see http://petritzdesigns.com
 */
public class MainView extends javax.swing.JFrame {

    public MainView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pnHeader = new javax.swing.JPanel();
        lbTitle = new javax.swing.JLabel();
        pnStatus = new javax.swing.JPanel();
        lbCopyright = new javax.swing.JLabel();
        lbStatus = new javax.swing.JLabel();
        pnMain = new javax.swing.JPanel();
        tabBar = new javax.swing.JTabbedPane();
        paLogin = new javax.swing.JPanel();
        lbEmail = new javax.swing.JLabel();
        lbPassword = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        tfPassword = new javax.swing.JTextField();
        btLogin = new javax.swing.JButton();
        paChoose = new javax.swing.JPanel();
        paCart = new javax.swing.JPanel();
        paBill = new javax.swing.JPanel();
        paStatus = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Jocolate Manager");

        pnHeader.setBackground(new java.awt.Color(52, 73, 94));
        pnHeader.setLayout(new java.awt.BorderLayout());

        lbTitle.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(255, 255, 255));
        lbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitle.setText("Jocolate Manager");
        lbTitle.setPreferredSize(new java.awt.Dimension(199, 50));
        pnHeader.add(lbTitle, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnHeader, java.awt.BorderLayout.NORTH);

        pnStatus.setBackground(new java.awt.Color(52, 73, 94));
        pnStatus.setLayout(new java.awt.BorderLayout());

        lbCopyright.setForeground(new java.awt.Color(255, 255, 255));
        lbCopyright.setText("(c) by jCorn");
        lbCopyright.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onCopyrightClicked(evt);
            }
        });
        pnStatus.add(lbCopyright, java.awt.BorderLayout.LINE_END);

        lbStatus.setForeground(new java.awt.Color(255, 255, 255));
        lbStatus.setText("Status");
        pnStatus.add(lbStatus, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnStatus, java.awt.BorderLayout.PAGE_END);

        pnMain.setLayout(new java.awt.BorderLayout());

        paLogin.setLayout(new java.awt.GridBagLayout());

        lbEmail.setText("E-Mail:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        paLogin.add(lbEmail, gridBagConstraints);

        lbPassword.setText("Password:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        paLogin.add(lbPassword, gridBagConstraints);

        tfEmail.setColumns(10);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        paLogin.add(tfEmail, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        paLogin.add(tfPassword, gridBagConstraints);

        btLogin.setText("Login");
        btLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onLoginClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        paLogin.add(btLogin, gridBagConstraints);

        tabBar.addTab("Login", paLogin);
        tabBar.addTab("Choose Chocolate", paChoose);
        tabBar.addTab("Shopping Cart", paCart);
        tabBar.addTab("Bill", paBill);
        tabBar.addTab("Delivery Status", paStatus);

        pnMain.add(tabBar, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnMain, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void onCopyrightClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onCopyrightClicked
        try {
            String htmlString = FileHelper.readAllFrom(Settings.getAssetPath("copyright.html"));
            JOptionPane.showMessageDialog(this, htmlString);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Could not read Copyright File...");
            System.err.println("I/O Error: " + ex.getLocalizedMessage());
        }
    }//GEN-LAST:event_onCopyrightClicked

    private void onLoginClicked(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onLoginClicked
        try {
            String username = tfEmail.getText();
            String password = tfPassword.getText();
            
            LoginController lc = new LoginController();
            lc.login(username, password);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getLocalizedMessage());
        }
    }//GEN-LAST:event_onLoginClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btLogin;
    private javax.swing.JLabel lbCopyright;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbPassword;
    private javax.swing.JLabel lbStatus;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JPanel paBill;
    private javax.swing.JPanel paCart;
    private javax.swing.JPanel paChoose;
    private javax.swing.JPanel paLogin;
    private javax.swing.JPanel paStatus;
    private javax.swing.JPanel pnHeader;
    private javax.swing.JPanel pnMain;
    private javax.swing.JPanel pnStatus;
    private javax.swing.JTabbedPane tabBar;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfPassword;
    // End of variables declaration//GEN-END:variables

}
