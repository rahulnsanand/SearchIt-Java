package com.searchit.tfg;


import com.searchit.tfg.ui.searchElement.SearchData;
import com.searchit.tfg.ui.MainWindow;
import com.searchit.tfg.ui.SearchPanel;
import com.searchit.tfg.ui.utils.ConsoleProgress;
import com.searchit.tfg.floptrie.FlopTrie;
import com.searchit.tfg.floptrie.UpdateSearchList;
import com.searchit.tfg.floptrie.UpdateTrie;
import com.searchit.tfg.ui.utils.JDialogProgressBar;
import jdk.nashorn.internal.scripts.JD;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Main{

    private static final FlopTrie flopTrie = new FlopTrie();
    private static final SearchData searchData = new SearchData();
    private static final FlopTrie.FlopTrieNode flopTrieNode = new FlopTrie.FlopTrieNode();
    private static final JDialogProgressBar jp = new JDialogProgressBar();
    private static final String JSONDataDirectory = "src/main/resources/Final JSON/";

    static MainWindow mainWindow = new MainWindow();

    public static void main(String[] args) {
        setupFrame();
        updateFlopTrie(JSONDataDirectory);
        jp.start("Checking Internet", "Pinging");
        jp.dpb.setIndeterminate(true);
        updateSearch();
        jp.stop();
        SearchPanel searchPanel = new SearchPanel(searchData,mainWindow);
        checkInternet();
        mainWindow.switchToSearchPanel(searchPanel);
    }

    private static void checkInternet() {
        try {
            URL url = new URL("http://www.google.com");
            URLConnection connection = url.openConnection();
            connection.connect();
            System.out.println("Internet is connected");
        } catch (MalformedURLException e) {
            System.out.println("Internet is not connected");
            System.exit(102);
        } catch (IOException e) {
            System.out.println("Internet is not connected");
            System.exit(101);
        }
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
