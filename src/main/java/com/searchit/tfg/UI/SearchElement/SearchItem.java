package com.searchit.tfg.UI.SearchElement;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;


public class SearchItem extends JPanel {

    private javax.swing.JLabel RestaurantImageFeature;
    private javax.swing.JLabel jLabel1;
    private BufferedImage RestaurantImage;
    private String RestaurantName;

    public SearchItem(String RestaurantName) {

        Dimension dimension = new Dimension(800,200);
        this.RestaurantName = RestaurantName;
        this.setPreferredSize(dimension);
        this.setBackground(new Color(36,36,36));
        //RestaurantImageFeature = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setForeground(new Color(239, 239, 239));

        setForeground(new java.awt.Color(51, 51, 51));


        //RestaurantImageFeature.setIcon(new ImageIcon("C:\\Users\\rahul\\Downloads\\cf86dbd8b8ca4d40682c7713f112cc07_featured_v2.jpg"));
        //RestaurantImageFeature.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        jLabel1.setText(RestaurantName);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                //.addComponent(RestaurantImageFeature)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        //.addComponent(RestaurantImageFeature)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addGap(117, 117, 117))
        );
    }

}
