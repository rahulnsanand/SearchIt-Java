package com.searchit.tfg.TESTING;

import com.searchit.tfg.UI.utils.ConsoleProgress;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVParserClass {

    List<String> nameArray = new ArrayList<String>();
    ConsoleProgress consoleProgress= new ConsoleProgress("Testing",10);

    public void readFile(){
        File restaurantNameFile = new File("C:\\Users\\swastika\\Desktop\\Shared Projects\\Restaurant Names.csv");

        try(FileInputStream fileInputStream = new FileInputStream(restaurantNameFile)) {
            Reader inputReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
            CsvParser parser = new CsvParser(new CsvParserSettings());
            List<String[]> parsedRows = parser.parseAll(inputReader);
            consoleProgress.start(parsedRows.size(), 0);
            for (int i = 0 ; i <parsedRows.size(); i ++) {
                nameArray.add(Arrays.toString(parsedRows.get(i)));
                consoleProgress.addStep(i);
            }
            consoleProgress.stop();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
