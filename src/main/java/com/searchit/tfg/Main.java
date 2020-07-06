package com.searchit.tfg;


import com.searchit.tfg.UI.ResultsPanel;
import com.searchit.tfg.UI.SearchElement.SearchData;
import com.searchit.tfg.dataset.retrieve.ZomatoAPISearch;
import com.searchit.tfg.dataset.retrieve.ZomatoWebOrder;
import com.searchit.tfg.UI.MainWindow;
import com.searchit.tfg.UI.SearchPanel;
import com.searchit.tfg.UI.utils.ConsoleProgress;
import com.searchit.tfg.floptrie.FlopTrie;
import com.searchit.tfg.floptrie.GetDataPOJO;
import com.searchit.tfg.floptrie.UpdateSearchList;
import com.searchit.tfg.floptrie.UpdateTrie;

import java.lang.reflect.Array;
import java.util.*;

public class Main{

    private static final FlopTrie flopTrie = new FlopTrie();
    private static final SearchData searchData = new SearchData();
    private static final FlopTrie.FlopTrieNode flopTrieNode = new FlopTrie.FlopTrieNode();

    private static final String JSONDataDirectory = "src/main/resources/Final JSON/";
    private static String word;
    static MainWindow mainWindow = new MainWindow();

    public static void main(String[] args) {
        setupFrame();
        updateFlopTrie(JSONDataDirectory);
        updateSearch();
        SearchPanel searchPanel = new SearchPanel(searchData,mainWindow);
        mainWindow.switchToSearchPanel(searchPanel);
    }

    public static void setupFrame(){
        mainWindow.createWindow();
        mainWindow.initLoadingPanel();
        mainWindow.displayWindow();
        mainWindow.showLoadingPanel();
    }

    public static void updateSearch(){
        mainWindow.updateProgressBar.setIndeterminate(true);
        mainWindow.mainFrameLoadingText.setText("Updating HashMap!");
        searchData.setNameIDMap(UpdateSearchList.hashMapUpdate(flopTrieNode));
        mainWindow.mainFrameLoadingText.setText("Updating Search List!");
        searchData.setNameList(UpdateSearchList.searchListUpdate(flopTrieNode));
        mainWindow.updateProgressBar.setIndeterminate(false);
        mainWindow.updateProgressBar.setMinimum(0);
        mainWindow.updateProgressBar.setMaximum(100);
        mainWindow.updateProgressBar.setValue(100);
    }

    public static void getInput(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter search >>");
        word = sc.next();
    }

    public static void search(String word){
        flopTrie.getSuggestions(flopTrieNode,word, 2);
        //flopTrie.showSuggestion(2,getDataPOJO);
    }

    public static void updateFlopTrie(String dir){
        UpdateTrie.update(dir,flopTrie,flopTrieNode, mainWindow);
    }

    public void consoleProgressCheck(){
        ConsoleProgress cp = new ConsoleProgress("Title",10);
        cp.start(10,0);
        for(int i = 0; i < 10; i++){
            try {
                Thread.sleep(1000);

                cp.addStep(i,"HELLO");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        cp.stop();
    }
}
