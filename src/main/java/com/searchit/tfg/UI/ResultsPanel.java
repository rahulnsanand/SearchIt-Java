package com.searchit.tfg.UI;

import com.searchit.tfg.UI.SearchElement.SearchData;
import com.searchit.tfg.UI.SearchElement.SearchItem;
import com.searchit.tfg.UI.utils.HintTextField;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class ResultsPanel extends JPanel {


    public javax.swing.JLabel searchItLogo;
    public javax.swing.JLabel madeInIndia;
    public javax.swing.JTextField searchTextField;
    public javax.swing.JButton switchThemeButton;
    public boolean darkTheme = false;
    public String selectedItem;
    public String selectedID;


    public String getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(String selectedItem) {
        this.selectedItem = selectedItem;
    }

    public ResultsPanel(SearchData searchData, MainWindow mainWindow){
        this.selectedItem = searchData.getSelectedItem();
        this.selectedID = searchData.getNameIDMap().get(this.selectedItem);
        initComponents(mainWindow);
    }

//    public static void resultPanel(){
//
////        try{
//////            SFProRegular = Font.createFont(Font.TRUETYPE_FONT, SFProTextRegularLocation);
////            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//////            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, SFProTextRegularLocation));
////
////        }
////        catch(IOException | FontFormatException e){
////
////        }
//
//    }

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

    public void initComponents(MainWindow mainWindow) {

        searchItLogo = new javax.swing.JLabel();
        switchThemeButton = new javax.swing.JButton();
        searchTextField = new HintTextField("Start typing here...");
        madeInIndia = new javax.swing.JLabel();

        setBackground(new java.awt.Color(32, 32, 32));

        searchItLogo.setFont(new java.awt.Font("Consolas", 2, 60)); // NOI18N
        searchItLogo.setForeground(new java.awt.Color(239, 239, 239));
        searchItLogo.setText(selectedID);
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
}
