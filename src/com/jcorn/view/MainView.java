package com.jcorn.view;

import com.jcorn.helper.FileHelper;
import com.jcorn.helper.Settings;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        btProfile = new javax.swing.JButton();
        btMenu = new javax.swing.JButton();
        pnStatus = new javax.swing.JPanel();
        lbCopyright = new javax.swing.JLabel();
        lbStatus = new javax.swing.JLabel();
        pnMain = new javax.swing.JPanel();

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

        btProfile.setText("Profile");
        btProfile.setPreferredSize(new java.awt.Dimension(84, 20));
        btProfile.setSize(new java.awt.Dimension(97, 20));
        pnHeader.add(btProfile, java.awt.BorderLayout.LINE_END);

        btMenu.setText("Menu");
        btMenu.setPreferredSize(new java.awt.Dimension(78, 20));
        pnHeader.add(btMenu, java.awt.BorderLayout.LINE_START);

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

        javax.swing.GroupLayout pnMainLayout = new javax.swing.GroupLayout(pnMain);
        pnMain.setLayout(pnMainLayout);
        pnMainLayout.setHorizontalGroup(
            pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 552, Short.MAX_VALUE)
        );
        pnMainLayout.setVerticalGroup(
            pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 362, Short.MAX_VALUE)
        );

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btMenu;
    private javax.swing.JButton btProfile;
    private javax.swing.JLabel lbCopyright;
    private javax.swing.JLabel lbStatus;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JPanel pnHeader;
    private javax.swing.JPanel pnMain;
    private javax.swing.JPanel pnStatus;
    // End of variables declaration//GEN-END:variables

}
