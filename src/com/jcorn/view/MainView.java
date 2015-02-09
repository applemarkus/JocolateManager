package com.jcorn.view;

import com.jcorn.controller.JocolateController;
import com.jcorn.controller.LoginController;
import com.jcorn.controller.StatusController;
import com.jcorn.helper.FileHelper;
import com.jcorn.helper.Settings;
import com.jcorn.model.JocolateModel;
import java.io.IOException;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 * JocolateManager
 *
 * @author Markus Petritz
 * @version 1.0.0
 * @see http://petritzdesigns.com
 */
public class MainView extends javax.swing.JFrame {
    
    private StatusController status;
    private JocolateController jocolate;
    
    public MainView() {
        initComponents();
        setup();
    }
    
    private void setup() {
        status = new StatusController(this);
        jocolate = new JocolateController();
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
        btLogin = new javax.swing.JButton();
        lbLoginStatus = new javax.swing.JLabel();
        tfPassword = new javax.swing.JPasswordField();
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
        paCart = new javax.swing.JPanel();
        tbMain = new javax.swing.JToolBar();
        btPayItem = new javax.swing.JButton();
        fillerCart = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        btClearAll = new javax.swing.JButton();
        btClearSelected = new javax.swing.JButton();
        spShoppingCart = new javax.swing.JScrollPane();
        tableShoppingCart = new javax.swing.JTable();
        paBill = new javax.swing.JPanel();
        spBill = new javax.swing.JScrollPane();
        epBillView = new javax.swing.JEditorPane();
        spBillList = new javax.swing.JScrollPane();
        liBill = new javax.swing.JList();
        paStatus = new javax.swing.JPanel();
        paProfile = new javax.swing.JPanel();
        mainMenuBar = new javax.swing.JMenuBar();
        meFile = new javax.swing.JMenu();
        miQuit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Jocolate Manager");
        setPreferredSize(new java.awt.Dimension(564, 401));
        setSize(new java.awt.Dimension(564, 401));

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
        lbCopyright.setText("(c) by jCorn ");
        lbCopyright.setPreferredSize(new java.awt.Dimension(76, 20));
        lbCopyright.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onCopyrightClicked(evt);
            }
        });
        pnStatus.add(lbCopyright, java.awt.BorderLayout.LINE_END);

        lbStatus.setForeground(new java.awt.Color(255, 255, 255));
        lbStatus.setText(" ");
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

        lbLoginStatus.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        lbLoginStatus.setText("Please give your login informations.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(9, 0, 9, 0);
        paLogin.add(lbLoginStatus, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        paLogin.add(tfPassword, gridBagConstraints);

        tabBar.addTab("Login", paLogin);

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
                onTypeChanged(evt);
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
                onSizeChanged(evt);
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
                onLogoChanged(evt);
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
                onTextReleased(evt);
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
                onAmountChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        paChoose.add(spinnerAmount, gridBagConstraints);

        btToShoppingCart.setText("To Shopping Cart");
        btToShoppingCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toShoppingCart(evt);
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
        lbPrice.setText("Price: € 0,00");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        paChoose.add(lbPrice, gridBagConstraints);

        tabBar.addTab("Choose Chocolate", paChoose);

        paCart.setLayout(new java.awt.BorderLayout());

        tbMain.setRollover(true);

        btPayItem.setText("Pay Item");
        btPayItem.setFocusable(false);
        btPayItem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btPayItem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tbMain.add(btPayItem);
        tbMain.add(fillerCart);

        btClearAll.setText("Clear all");
        btClearAll.setFocusable(false);
        btClearAll.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btClearAll.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tbMain.add(btClearAll);

        btClearSelected.setText("Clear selected");
        btClearSelected.setFocusable(false);
        btClearSelected.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btClearSelected.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tbMain.add(btClearSelected);

        paCart.add(tbMain, java.awt.BorderLayout.PAGE_END);

        tableShoppingCart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Name", "Type", "Size", "Logo", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        spShoppingCart.setViewportView(tableShoppingCart);

        paCart.add(spShoppingCart, java.awt.BorderLayout.CENTER);

        tabBar.addTab("Shopping Cart", paCart);

        paBill.setLayout(new java.awt.BorderLayout());

        spBill.setViewportView(epBillView);

        paBill.add(spBill, java.awt.BorderLayout.CENTER);

        liBill.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Bill #1" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        liBill.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        liBill.setSize(new java.awt.Dimension(50, 136));
        spBillList.setViewportView(liBill);

        paBill.add(spBillList, java.awt.BorderLayout.LINE_START);

        tabBar.addTab("Bill", paBill);
        tabBar.addTab("Delivery Status", paStatus);
        tabBar.addTab("Profile", paProfile);

        pnMain.add(tabBar, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnMain, java.awt.BorderLayout.CENTER);

        meFile.setText("File");

        miQuit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        miQuit.setText("Quit");
        miQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onQuit(evt);
            }
        });
        meFile.add(miQuit);

        mainMenuBar.add(meFile);

        setJMenuBar(mainMenuBar);

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
            String password = Arrays.toString(tfPassword.getPassword());
            
            if (username.isEmpty()) {
                throw new Exception("Username missing");
            }
            
            if (password.isEmpty()) {
                throw new Exception("Password missing");
            }
            
            loginMessage("Submitting...");
            LoginController lc = new LoginController();
            String error = lc.login(username, password);
            if (error.isEmpty()) {
                loginMessage("Logged in as " + username);
            } else {
                loginMessage("Error: " + error);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getLocalizedMessage());
        }
    }//GEN-LAST:event_onLoginClicked

    private void onQuit(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onQuit
        if (JOptionPane.showConfirmDialog(this, "Do you really want to quit?", "Quit?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_onQuit

    private void toShoppingCart(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toShoppingCart
        
    }//GEN-LAST:event_toShoppingCart

    private void onTypeChanged(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onTypeChanged
        calcPrice();
    }//GEN-LAST:event_onTypeChanged

    private void onSizeChanged(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onSizeChanged
        calcPrice();
    }//GEN-LAST:event_onSizeChanged

    private void onLogoChanged(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onLogoChanged
        calcPrice();
        if(cbLogo.getSelectedItem().equals("Text")) {
            tfText.setEnabled(true);
        }
        else {
            tfText.setEnabled(false);
        }
    }//GEN-LAST:event_onLogoChanged

    private void onTextReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_onTextReleased
        calcPrice();
    }//GEN-LAST:event_onTextReleased

    private void onAmountChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_onAmountChanged
        Integer value = (Integer) spinnerAmount.getValue();
        if(value <= 0) {
            value = 0;
        }
        if(value >= 99999) {
            value = 99999;
        }
        spinnerAmount.setValue(value);
        calcPrice();
    }//GEN-LAST:event_onAmountChanged
    
    private void loginMessage(String text) {
        status.set(text);
        lbLoginStatus.setText(text);
    }
    
    private void calcPrice() {
        String type = (String) cbType.getSelectedItem();
        String size = (String) cbSize.getSelectedItem();
        String logo = (String) cbLogo.getSelectedItem();
        String text = tfText.getText();
        Integer amount = (Integer) spinnerAmount.getValue();
        JocolateModel joc = new JocolateModel(type, size, logo, text, amount);
        lbPrice.setText("Price: € "+jocolate.calculatePrice(joc));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btClearAll;
    private javax.swing.JButton btClearSelected;
    private javax.swing.JButton btLogin;
    private javax.swing.JButton btPayItem;
    private javax.swing.JButton btToShoppingCart;
    private javax.swing.JComboBox cbLogo;
    private javax.swing.JComboBox cbSize;
    private javax.swing.JComboBox cbType;
    private javax.swing.JEditorPane epBillView;
    private javax.swing.Box.Filler fillerCart;
    private javax.swing.JLabel lbAmount;
    private javax.swing.JLabel lbCopyright;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbLoginStatus;
    private javax.swing.JLabel lbLogo;
    private javax.swing.JLabel lbPassword;
    private javax.swing.JLabel lbPrice;
    private javax.swing.JLabel lbSize;
    public javax.swing.JLabel lbStatus;
    private javax.swing.JLabel lbText;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbType;
    private javax.swing.JList liBill;
    private javax.swing.JMenuBar mainMenuBar;
    private javax.swing.JMenu meFile;
    private javax.swing.JMenuItem miQuit;
    private javax.swing.JPanel paBill;
    private javax.swing.JPanel paCart;
    private javax.swing.JPanel paChoose;
    private javax.swing.JPanel paLogin;
    private javax.swing.JPanel paProfile;
    private javax.swing.JPanel paStatus;
    private javax.swing.JPanel pnHeader;
    private javax.swing.JPanel pnMain;
    private javax.swing.JPanel pnStatus;
    private javax.swing.JScrollPane spBill;
    private javax.swing.JScrollPane spBillList;
    private javax.swing.JScrollPane spShoppingCart;
    private javax.swing.JSpinner spinnerAmount;
    private javax.swing.JTabbedPane tabBar;
    private javax.swing.JTable tableShoppingCart;
    private javax.swing.JToolBar tbMain;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JPasswordField tfPassword;
    private javax.swing.JTextField tfText;
    // End of variables declaration//GEN-END:variables

}
