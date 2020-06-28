package com.searchit.tfg;


import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.searchit.tfg.TESTING.JsonToCSV;
import com.searchit.tfg.TESTING.OrderLine;

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

        File zomatoDataDirectory = new File("C:\\Users\\swastika\\Desktop\\Restaurants\\");

        jsonToCSV.readWriteFinalJson(sourceJson, destJson);



        File SourceJsonFile = new File(DatasetSourceFolder);
//        File CSVFile1 = new File(CSV1);
//        File CSVFile2 = new File(CSV2);

//        JsonToCSV jsonToCSV = new JsonToCSV();
//
//        jsonToCSV.csvToJson();

    }
}
