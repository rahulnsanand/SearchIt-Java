package com.searchit.tfg.testingPackage;

import java.awt.*;

import javax.swing.*;

public class test {


    public static void main(String[] args) {
        JFrame parentFrame = new JFrame();
        parentFrame.setSize(500, 150);
        JLabel jl = new JLabel();
        jl.setText("Count : 0");

        parentFrame.add(BorderLayout.CENTER, jl);
        parentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        parentFrame.setVisible(true);
        JDialog dlg = new JDialog(parentFrame, "Progress Dialog", true);
        JProgressBar dpb = new JProgressBar(0, 500);
        dlg.add(BorderLayout.CENTER, dpb);
        dlg.add(BorderLayout.NORTH, new JLabel("Progress..."));
        dlg.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dlg.setSize(300, 75);
        dlg.setLocationRelativeTo(parentFrame);

        Thread t = new Thread(new Runnable() {
            public void run() {
                dlg.setVisible(true);
            }
        });
        t.start();
        for (int i = 0; i <= 500; i++) {
            dpb.setValue(i);
            if(dpb.getValue() == 500){
                dlg.setVisible(false);
                System.exit(0);

            }
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        dlg.setVisible(true);

    }
}

