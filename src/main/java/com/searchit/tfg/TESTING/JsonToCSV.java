package com.searchit.tfg.TESTING;

import com.github.wnameless.json.flattener.JsonFlattener;
import com.github.wnameless.json.unflattener.JsonUnflattener;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.sql.SQLOutput;
import java.util.Map;

import static com.sun.activation.registries.LogSupport.log;

public class JsonToCSV {

    public static void main(String[] args){

        JSONParser parser = new JSONParser();

        try (Reader reader = new FileReader("C:\\Users\\Swastika\\Desktop\\zomato\\file1.json")) {

            String exampleRequest = FileUtils.readFileToString(new File("C:\\Users\\Swastika\\Desktop\\zomato\\file1.json"), StandardCharsets.UTF_8);

            String jsonStr = JsonFlattener.flatten(exampleRequest);
            System.out.println(jsonStr);

        } catch (Exception e) {
            e.printStackTrace();
        }

//        String JsonFile = "{ \"a\" : { \"b\" : 1, \"c\": null, \"d\": [false, true] }, \"e\": \"f\", \"g\":2.3 }";
//        Map<String, Object> flattenedJsonMap = JsonFlattener.flattenAsMap(JsonFile);
//        System.out.println(flattenedJsonMap);

    }

}
