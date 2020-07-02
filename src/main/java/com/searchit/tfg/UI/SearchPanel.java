package com.searchit.tfg.UI;

import com.searchit.tfg.UI.utils.HintTextField;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class SearchPanel extends MainWindow {

    static GroupLayout layout;
    public static JPanel SearchPanelFrame;
    static Label searchItLogo;
    static JTextField searchItText;
    static Border searchTextBorder = BorderFactory.createLineBorder(Color.BLACK, 2);
    static File SFProTextRegularLocation = new File("C:\\Users\\swastika\\Desktop\\Shared Projects\\SearchIt IntelliJ\\src\\main\\resources\\SFProText-Regular.ttf");
    static String SearchIt = "SᴇᴀʀᴄʜIᴛ";

    static Font SFProRegular;


    public static void SearchElements(){
        searchItText = new HintTextField("Start typing here...");
        searchItText.setBorder(searchTextBorder);
        searchItLogo = new Label();
        SearchPanelFrame = new JPanel();

        MainWindowFrame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        MainWindowFrame.getContentPane().add(SearchPanelFrame);
        SearchPanelFrame.setBackground(new Color(49, 49, 49));

        try{
            SFProRegular = Font.createFont(Font.TRUETYPE_FONT, SFProTextRegularLocation);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, SFProTextRegularLocation));

        }
        catch(IOException | FontFormatException e){

        }

        searchItLogo.setFont(SFProRegular.deriveFont(65f).deriveFont(Font.ITALIC));
        searchItLogo.setForeground(new Color(239, 239, 239));
        searchItLogo.setText(SearchIt);

        layout = new GroupLayout(SearchPanelFrame);
        SearchPanelFrame.setLayout(layout);
        SearchPanelFrame.setVisible(true);

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(searchItText, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(380, Short.MAX_VALUE)
                                .addComponent(searchItLogo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(380, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(250, Short.MAX_VALUE)
                                .addComponent(searchItLogo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(searchItText, GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 15, 20)
                                .addContainerGap(300, Short.MAX_VALUE))
        );
    }
}
