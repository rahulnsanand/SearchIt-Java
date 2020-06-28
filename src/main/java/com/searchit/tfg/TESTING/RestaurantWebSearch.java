package com.searchit.tfg.TESTING;

import org.jsoup.Jsoup;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;

public class RestaurantWebSearch {

    public static String GetID(String URL){
        Document doc = null;

        try {
            doc = Jsoup.connect(URL).get();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        assert doc != null;
        Elements scriptElements = doc.getElementsByTag("script");

        for (Element element :scriptElements ){
            for (DataNode node : element.dataNodes()) {
                if(node.toString().contains("res_id")){
                    String data = node.getWholeData();
                    String[] split = data.split("\n");
                    for(String i :split){
                        if(i.contains("res_id")) {
                            String[] JsonData = i.split(":");
                            for(int j=0; j<JsonData.length;j++){
                                if(JsonData[j].contains("res_id")){
                                    String[] res_idWhole = JsonData[j+1].split(",");
                                    return res_idWhole[0];
                                }
                            }
                        }
                    }
                }
            }
        }
        return "NULL";
    }
}
