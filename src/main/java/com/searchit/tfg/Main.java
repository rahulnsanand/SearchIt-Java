package com.searchit.tfg;


import com.searchit.tfg.datasetUtils.DatasetCreator;

import java.io.IOException;

public class Main{

//APIEY : ddc19ec4e7244f81d2ef270dfba9ae31

    public static void main(String[] args) throws IOException {
//        MainWindow.createWindow();
//        SearchPanel.SearchElements();
//        SearchPanel.SearchPanelFrame.setVisible(false);
//        ResultsPanel resultsPanel = new ResultsPanel("HAHAHA");
//        resultsPanel.resultPanel();
//        MainWindow.displayWindow();

//        CSVParserClass csvParserClass = new CSVParserClass();
//        csvParserClass.readFile();
//        csvParserClass.printFile();

//        Trie trie = new Trie();
//        trie.insert("Hauz Khas");
//        trie.insert("Helslo");
//        trie.insert("Hesdllo");
//        trie.insert("Hellasdo");

//        int a = getCurrentStep(101,101);
//        System.out.println(a);

        DatasetCreator datasetCreator = new DatasetCreator();
//        jsonToCSV.JsonToFormattedCsv(JsonFile,CSVFile);
//        System.out.println(jsonToCSV.getExampleRoot(JsonFile,CSVFile));

        String zomatoDataDirectory = "C:\\Users\\swastika\\Desktop\\Zomato Dataset\\";
        String rawJSONDataDirectory = "C:\\Users\\swastika\\Desktop\\Zomato Dataset\\JSON\\";
        String finalJSONDataDirectory = "C:\\Users\\swastika\\Desktop\\Zomato Dataset\\Final JSON\\";

        //jsonToCSV.csvToJson(zomatoDataDirectory);

        datasetCreator.readWriteFinalJson(rawJSONDataDirectory, finalJSONDataDirectory);

//        ConsoleProgress cp = new ConsoleProgress("Title",10);
//        cp.start(10,0);
//        for(int i = 0; i < 10; i++){
//            try {
//                Thread.sleep(1000);
//
//                cp.addStep(i,"HELLO");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        cp.stop();

//        File CSVFile1 = new File(CSV1);
//        File CSVFile2 = new File(CSV2);

//        JsonToCSV jsonToCSV = new JsonToCSV();
//
//        jsonToCSV.csvToJson();

    }
}
