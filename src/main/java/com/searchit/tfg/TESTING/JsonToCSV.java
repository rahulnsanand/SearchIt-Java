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

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class JsonToCSV {
    private static MappingIterator<OrderLine> orderLines;
    private static MappingIterator<OrderLine> orderLines1;
    private static MappingIterator<OrderLine> orderLines2;
    public static String nameRead;

    public void csvToJson(File jsonSource) throws IOException {

        File zomatoDataDirectory = new File("C:\\Users\\swastika\\Desktop\\Restaurants\\");
        String cityNames[] = zomatoDataDirectory.list();

        CsvSchema orderLineSchema = CsvSchema
                .emptySchema()
                .withColumnSeparator('|')
                .withHeader();

        JsonFactory jsonFactory = new JsonFactory();

        CsvMapper csvMapper = new CsvMapper();
        File DestJsonFile = new File("C:\\Users\\swastika\\Desktop\\test.json");
        JsonGenerator jsonGenerator = jsonFactory.createGenerator(DestJsonFile, JsonEncoding.UTF8);
        ObjectMapper objectMapper = new ObjectMapper().configure(SerializationFeature.INDENT_OUTPUT,true);

        System.out.println(jsonSource);

        orderLines1 = csvMapper.readerFor(OrderLine.class).with(orderLineSchema).readValues(jsonSource);
        objectMapper.writeValue(jsonGenerator, orderLines1.readAll());
        jsonGenerator.close();

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

    public void readJson(File jsonFile) throws IOException {

        File DestJsonFile = new File("C:\\Users\\swastika\\Desktop\\testFinal.json");

        ObjectMapper objectMapper = new ObjectMapper();
//        JsonFactory jsonFactory = new JsonFactory();
//        JsonGenerator jsonGenerator = jsonFactory.createGenerator(DestJsonFile, JsonEncoding.UTF8);

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        OrderLine[] node = objectMapper.readValue(jsonFile,OrderLine[].class);
        System.out.println("Reading :"+jsonFile);
        int counter =0;
        for (OrderLine orderLine : node) {
            Map<String,String> putValue = new HashMap<String,String>();
            System.out.println(orderLine.getNAME());
            int Count = counter;

            String URL = orderLine.getURL();
            String CuisineCategory = orderLine.getCUSINE_CATEGORY();
            String City = orderLine.getCITY();
            String Name = orderLine.getNAME();
            String Res_ID =RestaurantWebSearch.GetID(orderLine.getURL());
            putValue.put("res_no", String.valueOf(Count));
            putValue.put("res_id", Res_ID);
            putValue.put("res_name", Name);
            putValue.put("res_city", City);
            putValue.put("res_cuisine", CuisineCategory);
            putValue.put("res_url", URL);
            ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());
            writer.writeValue(DestJsonFile, putValue);
            System.out.println("--Done--");
            counter++;
        }
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
