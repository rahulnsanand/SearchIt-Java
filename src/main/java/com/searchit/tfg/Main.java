package com.searchit.tfg;


import com.searchit.tfg.TESTING.FlopTrie;
import com.searchit.tfg.TESTING.UpdateTrie;
import com.searchit.tfg.UI.utils.ConsoleProgress;
import com.searchit.tfg.datasetUtils.DatasetCreator;

import java.io.IOException;

public class Main{

    //APIKEY : ddc19ec4e7244f81d2ef270dfba9ae31
    private static final FlopTrie flopTrie = new FlopTrie();

    public static void main(String[] args) throws IOException {
//        MainWindow.createWindow();
//        SearchPanel.SearchElements();
//        SearchPanel.SearchPanelFrame.setVisible(false);
//        ResultsPanel resultsPanel = new ResultsPanel("HAHAHA");
//        resultsPanel.resultPanel();
//        MainWindow.displayWindow();

        String JSONDataDirectory = "C:\\Users\\swastika\\Desktop\\Zomato Dataset\\Final JSON\\";

        UpdateTrie.update(JSONDataDirectory,flopTrie);
        System.out.println();
        System.out.println(flopTrie.getSuggestion("Kebabs",4));

    }

    public void consoleProgressCheck(){
        ConsoleProgress cp = new ConsoleProgress("Title",10);
        cp.start(10,0);
        for(int i = 0; i < 10; i++){
            try {
                Thread.sleep(1000);

                cp.addStep(i,"HELLO");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        cp.stop();
    }
}
