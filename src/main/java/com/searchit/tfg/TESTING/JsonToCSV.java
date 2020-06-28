package com.searchit.tfg.TESTING;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.*;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.dataformat.csv.*;
import com.fasterxml.jackson.dataformat.csv.impl.CsvEncoder;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class JsonToCSV {
    private static MappingIterator<OrderLine> orderLines;

    public void csvToJson() throws IOException {

        File zomatoDataDirectory = new File("C:\\Users\\swastika\\Desktop\\Restaurants\\");
        String cityNames[] = zomatoDataDirectory.list();


        CsvSchema orderLineSchema = CsvSchema
                .emptySchema()
                .withColumnSeparator('|')
                .withHeader();


        JsonFactory jsonFactory = new JsonFactory();

        CsvMapper csvMapper = new CsvMapper();

        for (String cityName : cityNames) {
            File cityDirectory = new File(zomatoDataDirectory + "\\" + cityName);
            System.out.println(cityDirectory);
            String DestJson = "C:\\Users\\swastika\\Desktop\\Zomato Dataset\\"+cityName+".json";
            File DestJsonFile = new File(DestJson);

            JsonGenerator jsonGenerator = jsonFactory.createGenerator(DestJsonFile, JsonEncoding.UTF8);

            String csvNames[] = cityDirectory.list();
            for (String csvName : csvNames) {

                File currentCSV = new File(zomatoDataDirectory + "\\" + cityName+"\\"+csvName);
                System.out.println(currentCSV);
                orderLines = csvMapper.readerFor(OrderLine.class)
                        .with(orderLineSchema)
                        .readValues(currentCSV);
                new ObjectMapper()
                        .configure(SerializationFeature.INDENT_OUTPUT, true)
                        .writeValue(jsonGenerator, orderLines.readAll());
            }
            jsonGenerator.close();
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
////        JsonNode rootNode = mapper.readTree(jsonFile);
////
//        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
////        System.out.println(rootNode);
////        CsvSchema.Builder csvSchemaBuilder = CsvSchema.builder();
////        JsonNode firstObject = rootNode.elements().next();
////        System.out.println(firstObject);
////        firstObject.fieldNames().forEachRemaining(csvSchemaBuilder::addColumn);
//
//        CsvMapper csvMapper = new CsvMapper();
//        CsvSchema csvSchema = csvMapper.schemaFor(ProductFields.class).withHeader();
//
//        csvMapper.addMixIn(Product.class, ProductFields.class);
////        JsonOrderLine[] orderLines = mapper.readValue(jsonFile, JsonOrderLine[].class);
//
//        //        csvMapper.writerFor(JsonNode.class)
////                .with(csvSchema)
////                .writeValue(csvFile, rootNode);
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
////        CsvMapper csvMapper = new CsvMapper();
////        CsvSchema csvSchema = csvMapper
////                .schemaFor(JsonFields.class)
////                .withColumnSeparator('|')
////                .withHeader();
//////        csvMapper.addMixIn(JsonOrderLine.class, JsonFields.class);
//////        JsonOrderLine[] orderLines = new ObjectMapper()
//////                .readValue(jsonFile, JsonOrderLine[].class);
//////        csvMapper.writerFor(JsonOrderLine[].class)
//////                .with(csvSchema)
//////                .writeValue(csvFile, orderLines);
//    }

}
