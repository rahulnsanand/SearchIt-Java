package com.searchit.tfg;


import com.searchit.tfg.TESTING.FlopTrie;
import com.searchit.tfg.TESTING.UpdateTrie;
import com.searchit.tfg.UI.utils.ConsoleProgress;
import com.searchit.tfg.datasetUtils.DatasetCreator;

import java.io.IOException;
import java.util.Scanner;

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

        String JSONDataDirectory = "D:\\Shared Projects\\Zomato Dataset\\Final JSON\\";
        String ReadDataDirectory = "C:\\Users\\swastika\\Desktop\\Zomato Dataset\\JSON\\";

        //DatasetCreator datasetCreator = new DatasetCreator();
        //datasetCreator.readWriteFinalJson(ReadDataDirectory,JSONDataDirectory);

        String check = "™";
        for(int i =0; i <check.length(); i++){
            System.out.println(flopTrie.CharToIndex(check.charAt(i)));
        }
        UpdateTrie.update(JSONDataDirectory,flopTrie);

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter search >>");
        String word = sc.next();
        int noOfSuggestion = flopTrie.getSuggestions(word);
        System.out.println(noOfSuggestion);
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
