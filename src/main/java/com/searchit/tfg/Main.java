package com.searchit.tfg;


import com.searchit.tfg.TESTING.CSVParserClass;
import com.searchit.tfg.TESTING.Trie;

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


        Trie trie = new Trie();
        trie.insert("Hauz Khas");
        trie.insert("Helslo");
        trie.insert("Hesdllo");
        trie.insert("Hellasdo");

        System.out.println(trie.containsNode("Hello"));

    }
}
