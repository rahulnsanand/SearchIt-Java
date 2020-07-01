package com.searchit.tfg.TESTING;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.io.IOException;

public class JsonConverter {

    public void JsonToCSV(String JsonDir, String CSVDir) throws IOException {
        File JsonDirFiles = new File(JsonDir);
        File CSVDirFiles = new File(CSVDir);
        String JsonFiles[] = JsonDirFiles.list();
        ConsoleProgress cp = new ConsoleProgress("Convertor",25);
        ObjectMapper objectMapper = new ObjectMapper();
        cp.start(JsonFiles.length,0);
        for(int i = 0; i < JsonFiles.length; i++){

            String jsonFilePath = JsonDir+JsonFiles[i];
            String[] csvSplit = JsonFiles[i].split(".json");
            String csvFileName = csvSplit[0]+".csv";
            String csvFilePath = CSVDirFiles+"\\"+csvFileName;

            if(!jsonFilePath.contains("C:\\Users\\swastika\\Desktop\\Zomato Dataset\\Final JSON\\Delhi3.json")){
                JsonNode jsonTree = objectMapper.readTree(new File(jsonFilePath));
                CsvSchema.Builder csvSchemaBuilder = CsvSchema.builder();
                JsonNode firstObject = jsonTree.elements().next();
                firstObject.fieldNames().forEachRemaining(csvSchemaBuilder::addColumn);
                CsvSchema csvSchema = csvSchemaBuilder.build().withHeader();

                CsvMapper csvMapper = new CsvMapper();
                csvMapper.writerFor(JsonNode.class)
                        .with(csvSchema)
                        .writeValue(new File(csvFilePath), jsonTree);
                cp.addStep(i, csvFileName+" Written!");
            }
        }
        cp.stop();
    }

}
