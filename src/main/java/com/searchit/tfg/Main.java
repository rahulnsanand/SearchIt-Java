package com.searchit.tfg;


import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.searchit.tfg.TESTING.JsonToCSV;
import com.searchit.tfg.TESTING.OrderLine;
import com.searchit.tfg.UI.utils.ConsoleProgress;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Main{

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

        JsonToCSV jsonToCSV = new JsonToCSV();
//        jsonToCSV.JsonToFormattedCsv(JsonFile,CSVFile);
//        System.out.println(jsonToCSV.getExampleRoot(JsonFile,CSVFile));

        String zomatoDataDirectory = "C:\\Users\\swastika\\Desktop\\Zomato Dataset\\";
        String rawJSONDataDirectory = "C:\\Users\\swastika\\Desktop\\Zomato Dataset\\JSON\\";
        String finalJSONDataDirectory = "C:\\Users\\swastika\\Desktop\\Zomato Dataset\\Final JSON\\";

        //jsonToCSV.csvToJson(zomatoDataDirectory);

        jsonToCSV.readWriteFinalJson(rawJSONDataDirectory, finalJSONDataDirectory);

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
