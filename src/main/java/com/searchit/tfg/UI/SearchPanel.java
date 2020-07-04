package com.searchit.tfg.UI;

import com.searchit.tfg.UI.utils.HintTextField;
import com.searchit.tfg.floptrie.FlopTrie;
import org.apache.commons.lang3.ObjectUtils;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;

public class SearchPanel extends JPanel{

    public javax.swing.JLabel searchItLogo;
    public javax.swing.JLabel madeInIndia;
    public javax.swing.JTextField searchTextField;
    public javax.swing.JButton switchThemeButton;
    public javax.swing.JComboBox<String> suggestionBox;
    public String id = "";
    public String res_name = "";
    public boolean darkTheme = false;

    public SearchPanel(ArrayList<String> list, Map<String, String> nameID){
        initComponents(list, nameID);
    }

    public void switchThemeButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if(darkTheme){
            setBackground(new java.awt.Color(32, 32, 32));
            searchItLogo.setForeground(new java.awt.Color(239, 239, 239));
            switchThemeButton.setBackground(new java.awt.Color(239, 239, 239));
            switchThemeButton.setText("LightMode");
            switchThemeButton.setForeground(new java.awt.Color(31, 31, 31));
            searchTextField.setForeground(new java.awt.Color(31, 31, 31));
            darkTheme=false;
        }
        else{
            setBackground(new java.awt.Color(239, 239, 239));
            searchItLogo.setForeground(new java.awt.Color(31, 31, 31));
            switchThemeButton.setBackground(new java.awt.Color(31, 31, 31));
            switchThemeButton.setText("DarkMode ");
            switchThemeButton.setForeground(new java.awt.Color(239, 239, 239));
            searchTextField.setForeground(new java.awt.Color(32, 32, 32));
            darkTheme=true;
        }
    }

    public void searchTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    public void initComponents(ArrayList<String> searchItemList, Map<String, String> nameID) {

        searchItLogo = new javax.swing.JLabel();
        switchThemeButton = new javax.swing.JButton();
        searchTextField = new HintTextField("Start typing here...");
        madeInIndia = new javax.swing.JLabel();

        setBackground(new java.awt.Color(32, 32, 32));

        searchItLogo.setFont(new java.awt.Font("Consolas", 2, 60)); // NOI18N
        searchItLogo.setForeground(new java.awt.Color(239, 239, 239));
        searchItLogo.setText("SᴇᴀʀᴄʜIᴛ");
        searchTextField.setFocusTraversalKeysEnabled(false);

        switchThemeButton.setBackground(new java.awt.Color(239, 239, 239));
        switchThemeButton.setFont(new java.awt.Font("Consolas", 3, 14)); // NOI18N
        switchThemeButton.setForeground(new java.awt.Color(50, 50, 50));
        switchThemeButton.setText("LightMode");
        switchThemeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        switchThemeButton.setOpaque(true);
        switchThemeButton.addActionListener(this::switchThemeButtonActionPerformed);

        searchTextField.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        searchTextField.setEditable(true);
        searchTextField.setEnabled(true);
        searchTextField.setForeground(new java.awt.Color(31, 31, 31));
        searchTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        searchTextField.setMaximumSize(new java.awt.Dimension(600, 20));
        searchTextField.setMinimumSize(new java.awt.Dimension(400, 20));
        searchTextField.setPreferredSize(new java.awt.Dimension(400, 20));
        searchTextField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));
        searchTextField.addActionListener(this::searchTextFieldActionPerformed);

        madeInIndia.setFont(new java.awt.Font("Consolas", Font.ITALIC, 12));
        madeInIndia.setText("Made In India by TheFlopGuy");
        madeInIndia.setForeground(new java.awt.Color(102, 102, 102));

        setupAutoComplete(searchTextField, searchItemList, nameID);

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

    public static void setupAutoComplete(final JTextField txtInput, final ArrayList<String> items, final Map<String, String> nameID) {
        final DefaultComboBoxModel model = new DefaultComboBoxModel();
        final JComboBox cbInput = new JComboBox(model) {
            public Dimension getPreferredSize() {
                return new Dimension(super.getPreferredSize().width, 0);
            }
        };
        setAdjusting(cbInput, false);
        for (String item : items) {
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
//                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
//                    if (cbInput.isPopupVisible()) {
//                        e.setKeyCode(KeyEvent.VK_ENTER);
//                    }
//                }
                if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN) {
                    e.setSource(cbInput);
                    cbInput.dispatchEvent(e);
                }
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    try{
                        txtInput.setText(cbInput.getSelectedItem().toString());
                        cbInput.setPopupVisible(false);
                        System.out.println(nameID.get(cbInput.getSelectedItem().toString()));
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
                    for (String item : items) {
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
}
