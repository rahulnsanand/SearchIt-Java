package com.searchit.tfg.UI;

import com.searchit.tfg.UI.SearchElement.SearchItem;
import com.searchit.tfg.UI.utils.HintTextField;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ResultsPanel extends MainWindow {


    private static JPanel ResultPanelFrame;
    static File SFProTextRegularLocation = new File("C:\\Users\\rahul\\Desktop\\Themes\\Themes\\sfwin-master\\SFPro\\TrueType\\SFProText-Regular.ttf");
    static Font SFProRegular;
    private static SearchItem searchItem;
    private static javax.swing.JScrollPane SearchResultScroll;
    private static final int GAP = 5;
    public static String RestaurantName;

    public ResultsPanel(String RestaurantName){
        ResultsPanel.RestaurantName =RestaurantName;
    }

    public void resultPanel(){

        Container container = MainWindowFrame.getContentPane();
        container.removeAll();

        try{
            SFProRegular = Font.createFont(Font.TRUETYPE_FONT, SFProTextRegularLocation);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, SFProTextRegularLocation));

        }
        catch(IOException | FontFormatException e){

        }

        JTextField searchItText = new HintTextField("Start typing here...");
        Label searchItLogo = new Label();
        JButton searchItButton = new JButton();
        ResultPanelFrame = new JPanel();
        searchItem = new SearchItem(RestaurantName);

        MainWindowFrame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        MainWindowFrame.getContentPane().add(ResultPanelFrame);

        searchItLogo.setFont(SFProRegular.deriveFont(35f));
        searchItLogo.setText("SearchIt");

        searchItButton.setFont(SFProRegular.deriveFont(15f));
        searchItButton.setText("SearchIt");
        GroupLayout layout = new GroupLayout(MainWindowFrame.getContentPane());
        MainWindowFrame.getContentPane().setLayout(layout);


        ResultPanelFrame = new javax.swing.JPanel();
        ResultPanelFrame.setBackground(new Color(31,31,31));
        ResultPanelFrame.setLayout(new BorderLayout());
        SearchResultScroll = new javax.swing.JScrollPane();
        SearchResultScroll.setBackground(new java.awt.Color(31,31,31));
        SearchResultScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        //SearchResultScroll.add(new SearchItem());
        MainWindow.MainWindowFrame.setContentPane(ResultPanelFrame);
        ResultPanelFrame.add(searchItem, BorderLayout.CENTER);
        ResultPanelFrame.setVisible(true);


    }
}
