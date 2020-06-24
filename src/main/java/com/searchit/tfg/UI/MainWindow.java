package com.searchit.tfg.UI;


import com.searchit.tfg.UI.utils.HintTextField;

import javax.swing.*;
import java.awt.*;


public class MainWindow{

    static JFrame MainWindowFrame;

    public static void createWindow() {

        MainWindowFrame = new JFrame("SearchIt");


    }

    public static void displayWindow(){
        MainWindowFrame.pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        MainWindowFrame.setLocationRelativeTo(null);
        MainWindowFrame.setLocation(screenSize.width/2-MainWindowFrame.getSize().width/2, screenSize.height/2-MainWindowFrame.getSize().height/2);
        MainWindowFrame.setSize(new Dimension(screenSize.getSize().width/2,screenSize.getSize().height/2));
        MainWindowFrame.setVisible(true);
    }



}
