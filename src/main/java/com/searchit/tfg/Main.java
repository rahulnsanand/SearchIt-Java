package com.searchit.tfg;


import com.searchit.tfg.dataset.retrieve.ZomatoAPISearch;
import com.searchit.tfg.dataset.retrieve.ZomatoWebOrder;
import com.searchit.tfg.UI.MainWindow;
import com.searchit.tfg.UI.SearchPanel;
import com.searchit.tfg.UI.utils.ConsoleProgress;
import com.searchit.tfg.floptrie.FlopTrie;
import com.searchit.tfg.floptrie.GetDataPOJO;
import com.searchit.tfg.floptrie.UpdateTrie;

import java.lang.reflect.Array;
import java.util.*;

public class Main{

    private static final FlopTrie flopTrie = new FlopTrie();
    private static final ZomatoWebOrder zomato = new ZomatoWebOrder();
    private static GetDataPOJO getDataPOJO = new GetDataPOJO();
    private static final String JSONDataDirectory = "C:\\Users\\swastika\\Desktop\\Shared Projects\\Zomato Dataset\\Final JSON\\";
    private static String word;
    static MainWindow mainWindow = new MainWindow();
    private static ArrayList<String> searchList = new ArrayList<>();

    public static void main(String[] args) {

        mainWindow.createWindow();
        mainWindow.initLoadingPanel();
        mainWindow.displayWindow();
        mainWindow.showLoadingPanel();
        updateFlopTrie(JSONDataDirectory);
        SearchPanel searchPanel = new SearchPanel(flopTrie);
        mainWindow.switchToSearchPanel(searchPanel);

//        getInput();
//        search(word);
//        callAPI();

    }

    public static void getInput(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter search >>");
        word = sc.next();
    }

    public static void search(String word){
        flopTrie.getSuggestions(word, 2);
        flopTrie.showSuggestion(2,getDataPOJO);
    }

    public static void callAPI(){
        ZomatoAPISearch zomatoAPISearch = new ZomatoAPISearch();
        int status = zomatoAPISearch.getApiDetails(zomato,getDataPOJO.getRes_id());
        getResponse(status);
    }

    public static void getResponse(int statusID){

        if(statusID == 1){
            getDetails();
        }
        else if (statusID == -1){
            System.out.println("This restaurant doesn't exit anymore");
        }
        else if(statusID == 404){
            System.out.println("Error "+statusID+": Couldn't get the details of this restaurant.");
        }
        else if(statusID ==101){
            System.out.println("Couldn't connect to the website. Check internet speed.");
        }
        else if(statusID == 102){
            System.out.println("IOException occured");
        }
        else if(statusID ==103){
            System.out.println("Couldn't connect to the website. Check internet connection");
        }
        else if(statusID ==104){
            System.out.println("API Limit exceeded!");
        }
        else if(statusID ==105) {
            System.out.println("Null Value Of Restaurant ID Passed!");
        }
    }

    private static void getDetails() {
        System.out.println(zomato.toString());

        if(zomato.getRetryNo()>0){
            System.out.println(zomato.getRetryNo());
        }
    }

    public static void updateFlopTrie(String dir){
        UpdateTrie.update(dir,flopTrie, mainWindow);
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
