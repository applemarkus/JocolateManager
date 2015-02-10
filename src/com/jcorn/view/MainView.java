package com.jcorn.view;

import com.jcorn.controller.JocolateController;
import com.jcorn.controller.LoginController;
import com.jcorn.controller.ShoppingCartController;
import com.jcorn.controller.StatusController;
import com.jcorn.helper.FileHelper;
import com.jcorn.helper.Settings;
import com.jcorn.helper.JM;
import com.jcorn.model.JocolateModel;
import com.jcorn.model.ShoppingCartItem;
import com.jcorn.model.ShoppingCartModel;
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
    private ShoppingCartController shoppingCart;

    private ShoppingCartModel shoppingModel;

    public MainView() {
        initComponents();
        setup();
    }

    private void setup() {
        status = new StatusController(this);
        jocolate = new JocolateController();
        shoppingCart = new ShoppingCartController();

        shoppingModel = new ShoppingCartModel(shoppingCart);
        
        //disable other, if they did not login
        tabBar.setEnabledAt(1, false);
        tabBar.setEnabledAt(2, false);
        tabBar.setEnabledAt(3, false);
        tabBar.setEnabledAt(4, false);
        tabBar.setEnabledAt(5, false);
        
        //if they login do this:
        tabBar.setEnabledAt(1, true);
        tabBar.setEnabledAt(2, true);
        tabBar.setEnabledAt(3, true);
        tabBar.setEnabledAt(4, true);
        tabBar.setEnabledAt(5, true);
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
        lbAllShopping = new javax.swing.JLabel();
        btPayItem = new javax.swing.JButton();
        btUpdate = new javax.swing.JButton();
        fillerCart = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        btDeleteAll = new javax.swing.JButton();
        btDeleteSelected = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        listShoppingCart = new javax.swing.JList();
        paBill = new javax.swing.JPanel();
        spBill = new javax.swing.JScrollPane();
        epBillView = new javax.swing.JEditorPane();
        spBillList = new javax.swing.JScrollPane();
        liBill = new javax.swing.JList();
        paStatus = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        paProfile = new javax.swing.JPanel();
        mainMenuBar = new javax.swing.JMenuBar();
        meFile = new javax.swing.JMenu();
        miQuit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Jocolate Manager");
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

        tabBar.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabBarStateChanged(evt);
            }
        });

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
        lbPrice.setText("Change Values for price calculation");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        paChoose.add(lbPrice, gridBagConstraints);

        tabBar.addTab("Choose Chocolate", paChoose);

        paCart.setLayout(new java.awt.BorderLayout());

        tbMain.setRollover(true);

        lbAllShopping.setText("All: € 0,00");
        tbMain.add(lbAllShopping);

        btPayItem.setText("Pay");
        btPayItem.setFocusable(false);
        btPayItem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btPayItem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tbMain.add(btPayItem);

        btUpdate.setText("Update");
        btUpdate.setFocusable(false);
        btUpdate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btUpdate.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onUpdate(evt);
            }
        });
        tbMain.add(btUpdate);
        tbMain.add(fillerCart);

        btDeleteAll.setText("Delete All");
        btDeleteAll.setFocusable(false);
        btDeleteAll.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btDeleteAll.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tbMain.add(btDeleteAll);

        btDeleteSelected.setText("Delete Selected");
        btDeleteSelected.setFocusable(false);
        btDeleteSelected.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btDeleteSelected.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tbMain.add(btDeleteSelected);

        paCart.add(tbMain, java.awt.BorderLayout.PAGE_END);

        listShoppingCart.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(listShoppingCart);

        paCart.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        tabBar.addTab("Shopping Cart", paCart);

        paBill.setLayout(new java.awt.BorderLayout());

        epBillView.setText("=============\nBill #1\nDate: 9.2.2014\n\nName: Markus\n=============\n\n-------------------------------------------\n*) 1x Chocolate white, small, jcorn\t€ 10,89\n*) 2x Chocolate brown, big, default\t€ 90,13\n-------------------------------------------\n\t\tSum:\t€ 21,12\n\t\t===============\n"); // NOI18N
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

        paStatus.setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Checking Details");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(23, 0, 23, 0);
        jPanel1.add(jLabel1, gridBagConstraints);

        jProgressBar1.setValue(25);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 16, 0);
        jPanel1.add(jProgressBar1, gridBagConstraints);

        jLabel2.setText("Check | Packaging | Send | Receive");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(13, 7, 0, 7);
        jPanel1.add(jLabel2, gridBagConstraints);

        jTextPane1.setEditable(false);
        jTextPane1.setText("Teststreet 4\n3523 Test\nAustria");
        jScrollPane2.setViewportView(jTextPane1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        jPanel1.add(jScrollPane2, gridBagConstraints);

        jLabel3.setText("Info");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(6, 4, 0, 6);
        jPanel1.add(jLabel3, gridBagConstraints);

        jButton1.setText("Update");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(12, 0, 0, 0);
        jPanel1.add(jButton1, gridBagConstraints);

        paStatus.add(jPanel1, java.awt.BorderLayout.CENTER);

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Package #1 9.2" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        paStatus.add(jScrollPane1, java.awt.BorderLayout.WEST);

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
        try {
            String type = (String) cbType.getSelectedItem();
            String size = (String) cbSize.getSelectedItem();
            String logo = (String) cbLogo.getSelectedItem();
            String text = tfText.getText();
            Integer amount = (Integer) spinnerAmount.getValue();
            JocolateModel joc = new JocolateModel(type, size, logo, text, amount);
            ShoppingCartItem item = joc.toShoppingCartItem();
            shoppingCart.moveToShoppingCart(item);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            JM.debug(ex.getMessage());
        }
    }//GEN-LAST:event_toShoppingCart

    private void onTypeChanged(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onTypeChanged
        calcPrice();
    }//GEN-LAST:event_onTypeChanged

    private void onSizeChanged(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onSizeChanged
        calcPrice();
    }//GEN-LAST:event_onSizeChanged

    private void onLogoChanged(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onLogoChanged
        calcPrice();
        if (cbLogo.getSelectedItem().equals("Text")) {
            tfText.setEnabled(true);
        } else {
            tfText.setEnabled(false);
        }
    }//GEN-LAST:event_onLogoChanged

    private void onTextReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_onTextReleased
        calcPrice();
    }//GEN-LAST:event_onTextReleased

    private void onAmountChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_onAmountChanged
        Integer value = (Integer) spinnerAmount.getValue();
        if (value <= 1) {
            value = 1;
        }
        if (value >= 99999) {
            value = 99999;
        }
        spinnerAmount.setValue(value);
        calcPrice();
    }//GEN-LAST:event_onAmountChanged

    private void tabBarStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabBarStateChanged
        switch (tabBar.getSelectedIndex()) {
            //Jocolate Chooser shown
            case 1:
                spinnerAmount.setValue(1);
                calcPrice();
                break;

            //Shopping Cart shown
            case 2:
                listShoppingCart.setModel(shoppingModel);
                 {
                    try {
                        shoppingModel.clearAll();
                        shoppingModel.readAll();
                        lbAllShopping.setText(String.format("€ %.2f", shoppingModel.getAllPrice()));
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, ex.getMessage());
                        JM.debug(ex.getMessage());
                    }
                }
                break;
        }
    }//GEN-LAST:event_tabBarStateChanged

    private void onUpdate(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onUpdate
        try {
            shoppingModel.clearAll();
            shoppingModel.readAll();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            JM.debug(ex.getMessage());
        }
    }//GEN-LAST:event_onUpdate

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
        lbPrice.setText(String.format("Price: € %.2f", jocolate.calculatePrice(joc)));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDeleteAll;
    private javax.swing.JButton btDeleteSelected;
    private javax.swing.JButton btLogin;
    private javax.swing.JButton btPayItem;
    private javax.swing.JButton btToShoppingCart;
    private javax.swing.JButton btUpdate;
    private javax.swing.JComboBox cbLogo;
    private javax.swing.JComboBox cbSize;
    private javax.swing.JComboBox cbType;
    private javax.swing.JEditorPane epBillView;
    private javax.swing.Box.Filler fillerCart;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JLabel lbAllShopping;
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
    private javax.swing.JList listShoppingCart;
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
    private javax.swing.JSpinner spinnerAmount;
    private javax.swing.JTabbedPane tabBar;
    private javax.swing.JToolBar tbMain;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JPasswordField tfPassword;
    private javax.swing.JTextField tfText;
    // End of variables declaration//GEN-END:variables

}
