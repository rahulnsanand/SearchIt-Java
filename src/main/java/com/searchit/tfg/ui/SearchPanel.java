package com.searchit.tfg.ui;

import com.searchit.tfg.ui.searchElement.SearchData;
import com.searchit.tfg.ui.utils.HintTextField;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SearchPanel extends JPanel{

    public javax.swing.JLabel searchItLogo;
    public javax.swing.JLabel madeInIndia;
    public javax.swing.JTextField searchTextField;
    public javax.swing.JButton switchThemeButton;
    public String id = "";
    public static int darkTheme = 1;
    public static int currentTheme = 1;
    public static SearchData searchData;

    public SearchPanel(SearchData searchData, MainWindow mainWindow){
        SearchPanel.searchData =searchData;
        initComponents(mainWindow);
    }

    public void themeCheck(){
        if(darkTheme==1){
            setBackground(new java.awt.Color(32, 32, 32));
            searchItLogo.setForeground(new java.awt.Color(239, 239, 239));
            switchThemeButton.setBackground(new java.awt.Color(239, 239, 239));
            switchThemeButton.setText("LightMode");
            switchThemeButton.setForeground(new java.awt.Color(31, 31, 31));
            searchTextField.setForeground(new java.awt.Color(31, 31, 31));
            currentTheme=1;
            darkTheme=0;
        }
        else{
            setBackground(new java.awt.Color(239, 239, 239));
            searchItLogo.setForeground(new java.awt.Color(31, 31, 31));
            switchThemeButton.setBackground(new java.awt.Color(31, 31, 31));
            switchThemeButton.setText("DarkMode ");
            switchThemeButton.setForeground(new java.awt.Color(239, 239, 239));
            searchTextField.setForeground(new java.awt.Color(32, 32, 32));
            currentTheme=0;
            darkTheme=1;
        }
    }

    public void switchThemeButtonActionPerformed(java.awt.event.ActionEvent evt) {
        themeCheck();
    }

    public void searchTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    public void initComponents(MainWindow mainWindow) {

        searchItLogo = new javax.swing.JLabel();
        switchThemeButton = new javax.swing.JButton();
        searchTextField = new HintTextField("Start typing here...");
        madeInIndia = new javax.swing.JLabel();

        themeCheck();

        searchItLogo.setFont(new java.awt.Font("Consolas", 2, 60)); // NOI18N
        searchItLogo.setText("SᴇᴀʀᴄʜIᴛ");
        searchTextField.setFocusTraversalKeysEnabled(false);

        switchThemeButton.setFont(new java.awt.Font("Consolas", 3, 14)); // NOI18N
        switchThemeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        switchThemeButton.setOpaque(true);
        switchThemeButton.addActionListener(this::switchThemeButtonActionPerformed);

        searchTextField.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        searchTextField.setEditable(true);
        searchTextField.setEnabled(true);
        searchTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        searchTextField.setMaximumSize(new java.awt.Dimension(600, 20));
        searchTextField.setMinimumSize(new java.awt.Dimension(400, 20));
        searchTextField.setPreferredSize(new java.awt.Dimension(400, 20));
        searchTextField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));
        searchTextField.addActionListener(this::searchTextFieldActionPerformed);

        madeInIndia.setFont(new java.awt.Font("Consolas", Font.ITALIC, 12));
        madeInIndia.setText("Made In India by TheFlopGuy");

        setupAutoComplete(mainWindow, searchTextField);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        layoutSetup(layout);
    }

    public void layoutSetup(GroupLayout layout){
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(switchThemeButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(madeInIndia)
                                .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(searchTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(260, Short.MAX_VALUE)
                                .addComponent(searchItLogo)
                                .addContainerGap(260, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(switchThemeButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                                .addComponent(searchItLogo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addContainerGap(100, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(madeInIndia)
                                .addContainerGap())
        );
    }

    private static boolean isAdjusting(JComboBox cbInput) {
        if (cbInput.getClientProperty("is_adjusting") instanceof Boolean) {
            return (Boolean) cbInput.getClientProperty("is_adjusting");
        }
        return false;
    }

    private static void setAdjusting(JComboBox cbInput, boolean adjusting) {
        cbInput.putClientProperty("is_adjusting", adjusting);
    }

    public static void setupAutoComplete(MainWindow mainWindow, final JTextField txtInput) {
        final DefaultComboBoxModel model = new DefaultComboBoxModel();
        final JComboBox cbInput = new JComboBox(model) {
            public Dimension getPreferredSize() {
                return new Dimension(super.getPreferredSize().width, 0);
            }
        };
        setAdjusting(cbInput, false);
        for (String item : searchData.getNameList()) {
            model.addElement(item);
        }
        cbInput.setSelectedItem(null);
        cbInput.addActionListener(e -> {
            if (!isAdjusting(cbInput)) {
                if (cbInput.getSelectedItem() != null) {
                    txtInput.setText(cbInput.getSelectedItem().toString());
                }
            }
        });

        txtInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                setAdjusting(cbInput, true);
                if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN) {
                    e.setSource(cbInput);
                    cbInput.dispatchEvent(e);
                }
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    try{
                        searchData.setSelectedItem("");
                        String selectedItem = cbInput.getSelectedItem().toString();
                        txtInput.setText(selectedItem);
                        cbInput.setPopupVisible(false);
                        searchData.setSelectedItem(selectedItem);
                        switchToResultPage(mainWindow, searchData);
                    }catch (NullPointerException nullPointerException){
                        System.out.println("Invalid Restaurant");
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    cbInput.setPopupVisible(false);
                }
                setAdjusting(cbInput, false);
            }
        });

        txtInput.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                updateList();
            }

            public void removeUpdate(DocumentEvent e) {
                updateList();
            }

            public void changedUpdate(DocumentEvent e) {
                updateList();
            }

            private void updateList() {
                setAdjusting(cbInput, true);
                model.removeAllElements();
                String input = txtInput.getText();
                if (!input.isEmpty()) {
                    for (String item : searchData.getNameList()) {
                        if (item.toLowerCase().startsWith(input.toLowerCase())) {
                            model.addElement(item);
                        }
                    }
                }
                cbInput.setPopupVisible(model.getSize() > 0);
                setAdjusting(cbInput, false);
            }
        });
        txtInput.setLayout(new BorderLayout());
        txtInput.add(cbInput, BorderLayout.SOUTH);
    }

    private static void switchToResultPage(MainWindow mainWindow, SearchData searchData) {
        darkTheme = currentTheme;
        ResultsPanel resultsPanel = new ResultsPanel(searchData,mainWindow, SearchPanel.currentTheme);
        mainWindow.switchToResultPanel(resultsPanel);
    }
}
