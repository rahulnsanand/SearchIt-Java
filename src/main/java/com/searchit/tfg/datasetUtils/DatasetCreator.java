package com.searchit.tfg.datasetUtils;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.searchit.tfg.UI.utils.ConsoleProgress;
import net.minidev.json.JSONArray;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class DatasetCreator {


    public void csvToJson(String csvSourceFolder) throws IOException {

        File sourceFolder = new File(csvSourceFolder);

        String cityFileNames[] = sourceFolder.list();
        CsvSchema orderLineSchema = CsvSchema
                .emptySchema()
                .withColumnSeparator('|')
                .withHeader();

        JsonFactory jsonFactory = new JsonFactory();

        CsvMapper csvMapper = new CsvMapper();
        ObjectMapper objectMapper = new ObjectMapper().configure(SerializationFeature.INDENT_OUTPUT,true);
        ConsoleProgress consoleProgress = new ConsoleProgress("Getting CSV",25);

        consoleProgress.start(cityFileNames.length,0);
        for(int i = 0; i <cityFileNames.length; i++){
            String cityNames[] = cityFileNames[i].split(".csv");
            String csvFileNames = cityFileNames[i];
            File sourceFile = new File(sourceFolder+"\\"+csvFileNames);
            System.out.println(sourceFile);
            String ExtraInfo = "Processing :"+sourceFile;
            consoleProgress.addStep(i,ExtraInfo);
            for(int j = 0; j <cityNames.length; j++){
                String cityName = sourceFolder+"\\"+cityNames[j]+".json";
                JsonGenerator jsonGenerator = jsonFactory.createGenerator(new File(cityName), JsonEncoding.UTF8);
                MappingIterator<OrderLine> orderLines = csvMapper.readerFor(OrderLine.class).with(orderLineSchema).readValues(sourceFile);
                objectMapper.writeValue(jsonGenerator, orderLines.readAll());
                jsonGenerator.close();
            }
        }
        consoleProgress.stop();
    }

    public void readWriteFinalJson(String sourceJsonFolder, String destJsonFolder) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);

        File sourceFolder = new File(sourceJsonFolder);
        String rawJsonFiles[] = sourceFolder.list();

        for (String rawJsonFile : rawJsonFiles) {
            String destinationFile = destJsonFolder + rawJsonFile;
            String sourceFile = sourceJsonFolder + rawJsonFile;
            OrderLine[] node = objectMapper.readValue(new File(sourceFile), OrderLine[].class);
            int counter = 1;
            JSONArray jsonArray = new JSONArray();
            FileWriter fileWriter = new FileWriter(new File(destinationFile));
            ConsoleProgress consoleProgress = new ConsoleProgress(rawJsonFile,50);
            consoleProgress.start(node.length, 0);
            for (int i = 0; i < node.length; i++) {
                int Count = counter;
                String URL = node[i].getURL();
                String CuisineCategory = node[i].getCUSINE_CATEGORY();
                String City = node[i].getCITY();
                String Name = node[i].getNAME();
                String Res_ID = RestaurantWebSearch.GetID(node[i].getURL());
                FinalJsonOrder jsonOrder = new FinalJsonOrder(String.valueOf(Count), Res_ID, Name, City, CuisineCategory, URL);
                jsonArray.add(jsonOrder);
                counter++;
                consoleProgress.addStep(i, Res_ID + "ID:\t" + Name +  " added!");
            }
            fileWriter.write(jsonArray.toString().replace("\\", ""));
            fileWriter.flush();
            consoleProgress.stop();
        }
    }

    public void jsonToCSV(File csvFile, File jsonFile) throws IOException {
        JsonNode jsonTree = new ObjectMapper().readTree(jsonFile);
        CsvSchema.Builder csvSchemaBuilder = CsvSchema.builder();
        JsonNode firstObject = jsonTree.elements().next();
        firstObject.fieldNames().forEachRemaining(csvSchemaBuilder::addColumn);
        CsvSchema csvSchema = csvSchemaBuilder.build().withHeader();

        CsvMapper csvMapper = new CsvMapper();
        csvMapper.writerFor(JsonNode.class)
                .with(csvSchema)
                .writeValue(csvFile, jsonTree);
    }
}
