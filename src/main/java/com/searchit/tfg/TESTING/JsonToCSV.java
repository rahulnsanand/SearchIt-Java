package com.searchit.tfg.TESTING;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.dataformat.csv.CsvFactory;
import com.fasterxml.jackson.dataformat.csv.CsvGenerator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.searchit.tfg.UI.utils.ConsoleProgress;
import net.minidev.json.JSONArray;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class JsonToCSV {
    private static MappingIterator<OrderLine> orderLines;


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
                orderLines = csvMapper.readerFor(OrderLine.class).with(orderLineSchema).readValues(sourceFile);
                objectMapper.writeValue(jsonGenerator, orderLines.readAll());
                jsonGenerator.close();
            }
        }
        consoleProgress.stop();



//        System.out.println(file2);
//        orderLines2 = csvMapper.readerFor(TestOrder.class).with(orderLineSchema).readValues(file2);


//        for (String cityName : cityNames) {
//            File cityDirectory = new File(zomatoDataDirectory + "\\" + cityName);
//            System.out.println(cityDirectory);
//            String DestJson = "C:\\Users\\swastika\\Desktop\\Zomato Dataset\\"+cityName+".json";
//            File DestJsonFile = new File(DestJson);
//
//            JsonGenerator jsonGenerator = jsonFactory.createGenerator(DestJsonFile, JsonEncoding.UTF8);
//
//            String csvNames[] = cityDirectory.list();
//            for (String csvName : csvNames) {
//
//                File currentCSV = new File(zomatoDataDirectory + "\\" + cityName+"\\"+csvName);
//                System.out.println(currentCSV);
//                orderLines = csvMapper.readerFor(OrderLine.class)
//                        .with(orderLineSchema)
//                        .readValues(currentCSV);
//                new ObjectMapper()
//                        .configure(SerializationFeature.INDENT_OUTPUT, true)
//                        .writeValue(jsonGenerator, orderLines.readAll());
//            }
//            jsonGenerator.close();
//        }


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
            ConsoleProgress consoleProgress = new ConsoleProgress(rawJsonFile,25);
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



//

    }

    public void jsonToCSV(File csvFile, File jsonFile) throws IOException {
        CsvFactory csvFactory = new CsvFactory();


        File zomatoDataDirectory = new File("C:\\Users\\swastika\\Desktop\\Restaurants\\");
        String cityNames[] = zomatoDataDirectory.list();

        CsvGenerator csvGenerator = csvFactory.createGenerator(csvFile,JsonEncoding.UTF8);

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

//    public int getExampleRoot(File jsonFile, File csvFile) throws IOException {
//
//        JsonNode rootNode = mapper.readTree(jsonFile);
//
//        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
//        System.out.println(rootNode);
//        CsvSchema.Builder csvSchemaBuilder = CsvSchema.builder();
//        JsonNode firstObject = rootNode.elements().next();
//        System.out.println(firstObject);
//        firstObject.fieldNames().forEachRemaining(csvSchemaBuilder::addColumn);
//
//        CsvMapper csvMapper = new CsvMapper();
//        CsvSchema csvSchema = csvMapper.schemaFor(ProductFields.class).withHeader();
//
//        csvMapper.addMixIn(Product.class, ProductFields.class);
//        JsonOrderLine[] orderLines = mapper.readValue(jsonFile, JsonOrderLine[].class);
//
//        //        csvMapper.writerFor(JsonNode.class)
//                .with(csvSchema)
//                .writeValue(csvFile, rootNode);
//
//        Product[] product = mapper.readValue(jsonFile, Product[].class);
//        mapper.writerFor(JsonNode.class)
//                .with(csvSchema)
//                .writeValue(csvFile, product);
//
//        //System.out.println(product.getBrandName());
//
//        return 1;
//
//    }

//    public void JsonToFormattedCsv(File jsonFile, File csvFile) throws IOException {
//        CsvMapper csvMapper = new CsvMapper();
//        CsvSchema csvSchema = csvMapper
//                .schemaFor(JsonFields.class)
//                .withColumnSeparator('|')
//                .withHeader();
//        csvMapper.addMixIn(JsonOrderLine.class, JsonFields.class);
//        JsonOrderLine[] orderLines = new ObjectMapper()
//                .readValue(jsonFile, JsonOrderLine[].class);
//        csvMapper.writerFor(JsonOrderLine[].class)
//                .with(csvSchema)
//                .writeValue(csvFile, orderLines);
//    }

}
