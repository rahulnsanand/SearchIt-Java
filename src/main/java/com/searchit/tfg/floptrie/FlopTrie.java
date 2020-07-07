package com.searchit.tfg.floptrie;

import java.util.*;

public class FlopTrie {

    public static class FlopTrieNode {

        public boolean isEndOfWord;
        public String ID;
        public String URL;
        public String City;
        public String Name;
        public static int ALPHABET_SIZE = 220;
        public final FlopTrieNode[] children = new FlopTrieNode[ALPHABET_SIZE];

        public FlopTrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;
        }

        public boolean isEndOfWord() {
            return isEndOfWord;
        }

        public void setEndOfWord(boolean endOfWord) {
            isEndOfWord = endOfWord;
        }

        public String getID() {
            return ID;
        }

        public void setID(String ID) {
            this.ID = ID;
        }

        public String getURL() {
            return URL;
        }

        public void setURL(String URL) {
            this.URL = URL;
        }

        public String getCity() {
            return City;
        }

        public void setCity(String city) {
            City = city;
        }

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }

    }

    //private final FlopTrieNode rootLevelNode;
    private boolean checkFlag = false;
    private GetDataPOJO getDataPOJO = new GetDataPOJO();

    public FlopTrie() {
        //rootLevelNode= new FlopTrieNode();
    }

    public void insert(FlopTrieNode flopTrieNode, String Name, String id, String url, String city){
        
        int level;
        int lengthName = Name.length();
        int lengthID = id.length();
        int index;

        FlopTrieNode insertNode = flopTrieNode;

        for (level = 0; level < lengthName; level++) {
            index = CharToIndex(Name.toLowerCase().charAt(level));
            if (insertNode.children[index] == null)
                insertNode.children[index] = new FlopTrieNode();
            insertNode = insertNode.children[index];
        }
        for (level = 0; level < lengthID; level++) {
            index = CharToIndex(id.charAt(level));
            if (insertNode.children[index] == null)
                insertNode.children[index] = new FlopTrieNode();
            insertNode = insertNode.children[index];
        }
        // mark last node as leaf
        insertNode.setName(Name);
        insertNode.setID(id);
        insertNode.setURL(url);
        insertNode.setCity(city);
        insertNode.setEndOfWord(true);
    }

    public boolean hasData(FlopTrieNode flopTrieNode, String res_id) {
        FlopTrieNode searchNode = flopTrieNode;
        boolean isLast = isLastNode(searchNode);
        if(!isLast){
            findID(searchNode,res_id);
            return getCheckFlag();
        }
        else{
            return searchNode.getID().equals(res_id);
        }
    }
    private boolean findID(FlopTrieNode searchNode, String res_id) {
        for(int level=0;level<FlopTrieNode.ALPHABET_SIZE;level++) {
            if(searchNode.children[level]!=null){
                if (searchNode.children[level].isEndOfWord()) {
                    String foundID = searchNode.children[level].getID();
                    if (foundID.equals(res_id)) {
                        setCheckFlag(true);
                    }
                }
                else{
                    findID(searchNode.children[level],res_id);
                }
            }
        }
        return false;
    }
    private void setCheckFlag(boolean status){
        this.checkFlag = status;
    }
    private boolean getCheckFlag(){
        return checkFlag;
    }
    private String getNotFound(){
        return "Restaurant Doesn't exist";
    }

    public String getCity(FlopTrieNode flopTrieNode, String res_id){
        FlopTrieNode citySearchNode = flopTrieNode;
        if(hasData(citySearchNode,res_id)){
            boolean isLast = isLastNode(citySearchNode);
            if(!isLast){
                findCity(citySearchNode,res_id);
                return getDataPOJO.getRes_city();
            }
        }
        return getNotFound();
    }
    public String getURL(FlopTrieNode flopTrieNode, String res_id){
        FlopTrieNode citySearchNode = flopTrieNode;
        if(hasData(citySearchNode,res_id)){
            boolean isLast = isLastNode(citySearchNode);
            if(!isLast){
                findURL(citySearchNode,res_id);
                return getDataPOJO.getRes_url();
            }
        }
        return getNotFound();
    }
    public String getName(FlopTrieNode flopTrieNode, String res_id){
        FlopTrieNode citySearchNode = flopTrieNode;
        if(hasData(citySearchNode, res_id)){
            boolean isLast = isLastNode(citySearchNode);
            if(!isLast){
                findName(citySearchNode,res_id);
                return getDataPOJO.getRes_name();
            }
        }
        return getNotFound();
    }
    public String getFlopTrieDetails(FlopTrieNode flopTrieNode, String res_id){
        FlopTrieNode citySearchNode = flopTrieNode;
        if(hasData(citySearchNode, res_id)){
            boolean isLast = isLastNode(citySearchNode);
            if(!isLast){
                findFlopTrieDetails(citySearchNode,res_id);
                return getDataPOJO.toString();
            }
        }
        return getNotFound();
    }

    private void findCity(FlopTrieNode searchCity, String res_id) {
        for(int level=0;level<FlopTrieNode.ALPHABET_SIZE;level++) {
            if(searchCity.children[level]!=null){
                if (searchCity.children[level].isEndOfWord() && searchCity.children[level].getID().equals(res_id)) {
                    getDataPOJO.setRes_city(searchCity.children[level].getCity());
                }
                else{
                    findCity(searchCity.children[level],res_id);
                }
            }
        }
    }
    private void findURL(FlopTrieNode searchURL, String res_id) {
        for(int level=0;level<FlopTrieNode.ALPHABET_SIZE;level++) {
            if(searchURL.children[level]!=null){
                if (searchURL.children[level].isEndOfWord() && searchURL.children[level].getID().equals(res_id)) {
                    getDataPOJO.setRes_url(searchURL.children[level].getURL());
                }
                else{
                    findURL(searchURL.children[level],res_id);
                }
            }
        }
    }
    private void findName(FlopTrieNode searchName, String res_id) {
        for(int level=0;level<FlopTrieNode.ALPHABET_SIZE;level++) {
            if(searchName.children[level]!=null){
                if (searchName.children[level].isEndOfWord() && searchName.children[level].getID().equals(res_id)) {
                    getDataPOJO.setRes_name(searchName.children[level].getName());
                }
                else{
                    findName(searchName.children[level],res_id);
                }
            }
        }
    }
    private void findFlopTrieDetails(FlopTrieNode searchDetails, String res_id) {
        for(int level=0;level<FlopTrieNode.ALPHABET_SIZE;level++) {
            if(searchDetails.children[level]!=null){
                if (searchDetails.children[level].isEndOfWord() && searchDetails.children[level].getID().equals(res_id)) {
                    getDataPOJO.setRes_name(searchDetails.children[level].getName());
                    getDataPOJO.setRes_url(searchDetails.children[level].getURL());
                    getDataPOJO.setRes_city(searchDetails.children[level].getCity());
                    getDataPOJO.setRes_id(res_id);

                }
                else{
                    findFlopTrieDetails(searchDetails.children[level],res_id);
                }
            }
        }
    }

    //TODO: FIND REGION VALUES ALSO TO IMPROVE SUGGESTION
//    private void findRegion(FlopTrieNode searchCity, String res_id) {
//        for(int level=0;level<FlopTrieNode.ALPHABET_SIZE;level++) {
//            if(searchCity.children[level]!=null){
//                if (searchCity.children[level].isEndOfWord() && searchCity.children[level].getID().equals(res_id)) {
//                    getDataPOJO.setRes_city(searchCity.children[level].getCity());
//                }
//                else{
//                    findCity(searchCity.children[level],res_id);
//                }
//            }
//        }
//    }

    public int CharToIndex(char a){
        return a-' ';
    }

    private boolean isLastNode(FlopTrieNode lastSearchNode){
        return lastSearchNode.isEndOfWord;
    }

    Map<Integer,String> searchKeyID = new HashMap<>();
    Map<String, String> idName = new HashMap<>();
    Map<String, String> idCity = new HashMap<>();
    int suggestionCounter = 0;

    public void getSuggestions(FlopTrieNode flopTrieNode, String word, int limit){
        FlopTrieNode internalSearchNode = flopTrieNode;
        int level;
        int len=word.length();
        int index;

        for(level=0; level<len; level++){
            index = CharToIndex(word.toLowerCase().charAt(level));
            internalSearchNode = internalSearchNode.children[index];
            if(internalSearchNode==null){
                return;
            }
            if(internalSearchNode.isEndOfWord()){
                return;
            }
        }
        boolean isWord = internalSearchNode.isEndOfWord();
        boolean isLast = isLastNode(internalSearchNode);
        if(isWord && isLast){
            idName.put(internalSearchNode.getID(),word);
            //searchList.add(word+", "+internalSearchNode.getCity());
            //idCity.put(internalSearchNode.getID(),getCity(internalSearchNode.getID()));
            return;
        }
        if(!isLast){
            suggestionRec(internalSearchNode, limit);
        }
    }
    private void suggestionRec(FlopTrieNode internalSearchNode, int limit) {

        for(int i=0;i<FlopTrieNode.ALPHABET_SIZE;i++) {
            if(internalSearchNode.children[i]!=null){
                if (internalSearchNode.children[i].isEndOfWord()) {
                    suggestionCounter++;
                    idName.put(internalSearchNode.children[i].getID(),internalSearchNode.children[i].getName());
                    //searchList.add(internalSearchNode.children[i].getName()+", "+internalSearchNode.children[i].getCity());
                    //idCity.put(internalSearchNode.children[i].getID(),getCity(internalSearchNode.children[i].getID()));
                }
                else{
                    if(suggestionCounter<limit){
                        suggestionRec(internalSearchNode.children[i], limit);
                    }
                    else{
                        return;
                    }
                }
            }
        }
    }

    public void showSuggestion(int limit, GetDataPOJO getDataPOJO){
        Scanner sc = new Scanner(System.in);
        int counter = 1;
        for(Map.Entry<String,String> mapLoop : idName.entrySet()){
            if(counter>limit){
                break;
            }
            searchKeyID.put(counter,mapLoop.getKey());
            System.out.println(counter+"::\t"+mapLoop.getValue()+", "+ idCity.get(mapLoop.getKey()));
            counter++;
        }
        System.out.print(">>");
        int choice = sc.nextInt();
        getDataPOJO.setRes_id(searchKeyID.get(choice));
    }

}
