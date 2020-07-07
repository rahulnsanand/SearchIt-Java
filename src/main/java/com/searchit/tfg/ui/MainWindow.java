package com.searchit.tfg.ui;


import javax.swing.*;
import java.awt.*;


public class MainWindow{

    public JFrame MainWindowFrame;
    public javax.swing.JLabel mainFrameLogo;
    public javax.swing.JLabel mainFrameLoadingText;
    public javax.swing.JPanel mainPanel;
    public javax.swing.JProgressBar updateProgressBar;
    public Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public void createWindow() {
        MainWindowFrame = new JFrame("SearchIt");
        MainWindowFrame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        MainWindowFrame.setTitle("SearchIt");
        MainWindowFrame.setMaximumSize(new java.awt.Dimension(1920, 1240));
        MainWindowFrame.setMinimumSize(new java.awt.Dimension(720, 540));
        MainWindowFrame.setLocation(screenSize.width/2-MainWindowFrame.getSize().width/2, screenSize.height/2-MainWindowFrame.getSize().height/2);
        MainWindowFrame.setPreferredSize(new Dimension(screenSize.getSize().width/2,screenSize.getSize().height/2));
        MainWindowFrame.setResizable(false);
    }

    public void displayWindow(){
        MainWindowFrame.pack();
        MainWindowFrame.setVisible(true);
    }

    public void initLoadingPanel() {

        mainPanel = new javax.swing.JPanel();
        updateProgressBar = new javax.swing.JProgressBar();
        mainFrameLogo = new javax.swing.JLabel();
        mainFrameLoadingText = new javax.swing.JLabel();



        mainPanel.setBackground(new java.awt.Color(51, 51, 51));
        mainPanel.setPreferredSize(new java.awt.Dimension(720, 480));

        updateProgressBar.setBackground(new java.awt.Color(255, 255, 255));
        updateProgressBar.setForeground(new java.awt.Color(0, 51, 51));
        updateProgressBar.setBorder(null);
        updateProgressBar.setMaximumSize(new java.awt.Dimension(50000, 4));
        updateProgressBar.setOpaque(true);

        mainFrameLogo.setFont(new java.awt.Font("Consolas", 2, 60)); // NOI18N
        mainFrameLogo.setForeground(new java.awt.Color(239, 239, 239));
        mainFrameLogo.setText("SᴇᴀʀᴄʜIᴛ");

        mainFrameLoadingText.setFont(new java.awt.Font("Consolas", 2, 14)); // NOI18N
        mainFrameLoadingText.setForeground(new java.awt.Color(239, 239, 239));
        mainFrameLoadingText.setText("Loading");

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addContainerGap(228, Short.MAX_VALUE)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(mainFrameLogo)
                                        .addComponent(updateProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(228, Short.MAX_VALUE))
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(mainFrameLoadingText)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(mainFrameLogo)
                                .addGap(40, 40, 40)
                                .addComponent(updateProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(mainFrameLoadingText)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );


    }
    public void showLoadingPanel(){
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(MainWindowFrame.getContentPane());
        MainWindowFrame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }

    public void switchToSearchPanel(JPanel searchPanel){

        MainWindowFrame.getContentPane().removeAll();
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(MainWindowFrame.getContentPane());
        MainWindowFrame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(searchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(searchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }

    public void switchToResultPanel(ResultsPanel resultPanel){

        MainWindowFrame.getContentPane().removeAll();
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(MainWindowFrame.getContentPane());
        MainWindowFrame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(resultPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(resultPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }

}
