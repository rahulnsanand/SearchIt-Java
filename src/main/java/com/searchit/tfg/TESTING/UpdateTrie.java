package com.searchit.tfg.TESTING;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.searchit.tfg.UI.utils.ConsoleProgress;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class UpdateTrie {

    public static void update(String JSONDir, FlopTrie flopTrie){
        File JSONDirFiles = new File(JSONDir);
        String JSONFiles[] = JSONDirFiles.list();
        ObjectMapper objectMapper = new ObjectMapper();
        ConsoleProgress cp = new ConsoleProgress("FlopTrie Creation",25);
        cp.start(JSONFiles.length,0);
        for(int i = 0; i < JSONFiles.length; i++) {
            String jsonFilePath = JSONDir+JSONFiles[i];

            try {
                List<TrieOrder> listCar = objectMapper.readValue(new File(jsonFilePath), new TypeReference<List<TrieOrder>>(){});
                for(int j = 0; j <listCar.size(); j++){
                    String restaurantName = listCar.get(j).getRes_name();
                    String restaurantID = listCar.get(j).getRes_id();
                    String restaurantURL = listCar.get(j).getRes_url();
                    String restaurantCity = listCar.get(j).getRes_city();

                    flopTrie.add(restaurantName,restaurantID,restaurantURL,restaurantCity);

                }
                cp.addStep(i,"Added :\t"+JSONFiles[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        cp.stop();
    }

}
