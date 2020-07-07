package com.searchit.tfg.ui.utils;

import javax.swing.*;
import java.awt.*;

public class JDialogProgressBar extends JDialog {

    public JProgressBar dpb = new JProgressBar(0, 500);

    public void start(String title, String processText){
        new JDialog(this, title, true);
        add(BorderLayout.CENTER, dpb);
        add(BorderLayout.NORTH, new JLabel(processText));
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        setSize(300, 75);
        setLocationRelativeTo(this);
        Thread t = new Thread(() -> setVisible(true));
        t.start();
    }

    public void setProgressValue(int i){
        dpb.setValue(i);
    }

    public void stop(){
        setVisible(false);
    }

}
