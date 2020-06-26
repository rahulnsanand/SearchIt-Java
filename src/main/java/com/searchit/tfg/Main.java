package com.searchit.tfg;


import com.searchit.tfg.TESTING.CSVParserClass;
import com.searchit.tfg.TESTING.Trie;
import com.searchit.tfg.UI.utils.ConsoleProgress;

import java.util.Arrays;

public class Main{

    public static void main(String[] args) {

//        MainWindow.createWindow();
//        SearchPanel.SearchElements();
//        SearchPanel.SearchPanelFrame.setVisible(false);
//        ResultsPanel resultsPanel = new ResultsPanel("HAHAHA");
//        resultsPanel.resultPanel();
//        MainWindow.displayWindow();

        CSVParserClass csvParserClass = new CSVParserClass();
        csvParserClass.readFile();
        //csvParserClass.printFile();


//        ConsoleProgress consoleProgress= new ConsoleProgress();
//        consoleProgress.start(10,0);
//        for (int i = 1 ; i <=10; i ++) {
//            consoleProgress.addStep(i);
//        }
//        consoleProgress.stop();



//        Trie trie = new Trie();
//        trie.insert("Hauz Khas");
//        trie.insert("Helslo");
//        trie.insert("Hesdllo");
//        trie.insert("Hellasdo");

        int a = getCurrentStep(101,101);
        System.out.println(a);

    }

    public static int getCurrentStep(int toConvert, int loopLen){
        return (int) Math.floor(((double) toConvert / (double) loopLen)*10);
    }
}
