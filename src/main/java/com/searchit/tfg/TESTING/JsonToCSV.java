package com.searchit.tfg.TESTING;

import com.github.wnameless.json.flattener.JsonFlattener;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class JsonToCSV {

    public static void main(String[] args){

        JSONParser parser = new JSONParser();
        String jsonFile = "C:\\Users\\Swastika\\Desktop\\zomato\\file1.json";

        try (Reader reader = new FileReader(jsonFile)) {


            Object jsonDataString = parser.parse(reader);

            //Map<String, Object> flattenJson = JsonFlattener.flattenAsMap(jsonDataString);

            System.out.println(jsonDataString);



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> getValuesForGivenKey(String jsonArrayStr, String key) {
        JSONArray jsonArray = new JSONArray(jsonArrayStr);
        return IntStream.range(0, jsonArray.length())
                .mapToObj(index -> ((JSONObject)jsonArray.get(index)).optString(key))
                .collect(Collectors.toList());
    }
    public static String readFile(String filename) {
        String result = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            result = sb.toString();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
