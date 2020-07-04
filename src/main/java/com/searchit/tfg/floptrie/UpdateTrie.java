package com.searchit.tfg.floptrie;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.searchit.tfg.UI.MainWindow;
import com.searchit.tfg.UI.utils.ConsoleProgress;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class UpdateTrie {

    public static void update(String JSONDir, FlopTrie flopTrie, MainWindow mainWindow){
        File JSONDirFiles = new File(JSONDir);
        String[] JSONFiles = JSONDirFiles.list();
        ObjectMapper objectMapper = new ObjectMapper();

        assert JSONFiles != null;
        mainWindow.updateProgressBar.setMaximum(JSONFiles.length-1);
        mainWindow.updateProgressBar.setMinimum(0);
        for(int i = 0; i < JSONFiles.length; i++) {
            String jsonFilePath = JSONDir+JSONFiles[i];

            try {
                List<TrieOrder> jsonList = objectMapper.readValue(new File(jsonFilePath), new TypeReference<List<TrieOrder>>(){});
                for (TrieOrder trieOrder : jsonList) {
                    String restaurantName = trieOrder.getRes_name();
                    String restaurantID = trieOrder.getRes_id();
                    String restaurantURL = trieOrder.getRes_url();
                    String restaurantCity = trieOrder.getRes_city();
                    flopTrie.insert(restaurantName, restaurantID, restaurantURL, restaurantCity);
                }
                mainWindow.mainFrameLoadingText.setText("Updated "+JSONFiles[i]+" FlopTrie Values!");
                mainWindow.updateProgressBar.setValue(i);
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
        mainWindow.mainFrameLoadingText.setText("FlopTrie Updated!");
    }

}
