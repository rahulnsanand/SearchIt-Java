package com.searchit.tfg.floptrie;

import com.searchit.tfg.TESTING.ZomatoAPISearch;

import java.util.*;

public class FlopTrie {

    private static class FlopTrieNode {

        private boolean isEndOfWord;
        private String ID;
        private String URL;
        private String City;
        private String Name;
        public static final int ALPHABET_SIZE = 220;
        private final FlopTrieNode[] children = new FlopTrieNode[ALPHABET_SIZE];

        private FlopTrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;
        }

        private boolean isEndOfWord() {
            return isEndOfWord;
        }

        private void setEndOfWord(boolean endOfWord) {
            isEndOfWord = endOfWord;
        }

        private String getID() {
            return ID;
        }

        private void setID(String ID) {
            this.ID = ID;
        }

        private String getURL() {
            return URL;
        }

        private void setURL(String URL) {
            this.URL = URL;
        }

        private String getCity() {
            return City;
        }

        private void setCity(String city) {
            City = city;
        }

        private String getName() {
            return Name;
        }

        private void setName(String name) {
            Name = name;
        }

    }

    private final FlopTrieNode rootLevelNode;
    private boolean checkFlag = false;
    private GetDataPOJO getDataPOJO = new GetDataPOJO();

    public FlopTrie() {
        rootLevelNode= new FlopTrieNode();
    }

    public void insert(String Name, String id, String url, String city){
        
        int level;
        int lengthName = Name.length();
        int lengthID = id.length();
        int index;

        FlopTrieNode insertNode = rootLevelNode;

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

    public boolean hasData(String res_id) {
        FlopTrieNode searchNode = rootLevelNode;
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

    public String getCity(String res_id){
        FlopTrieNode citySearchNode = rootLevelNode;
        if(hasData(res_id)){
            boolean isLast = isLastNode(citySearchNode);
            if(!isLast){
                findCity(citySearchNode,res_id);
                return getDataPOJO.getRes_city();
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
    private void findURL(FlopTrieNode searchCity, String res_id) {
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
    private void findName(FlopTrieNode searchCity, String res_id) {
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

    public int getSuggestions(String word){
        FlopTrieNode internalSearchNode = rootLevelNode;
        int level;
        int len=word.length();
        int index;

        for(level=0; level<len; level++){
            index = CharToIndex(word.toLowerCase().charAt(level));
            internalSearchNode = internalSearchNode.children[index];
            if(internalSearchNode==null){
                return 404;
            }
            if(internalSearchNode.isEndOfWord()){
                return 0;
            }
        }
        boolean isWord = internalSearchNode.isEndOfWord();
        boolean isLast = isLastNode(internalSearchNode);
        if(isWord && isLast){
            idName.put(internalSearchNode.getID(),word);
            idCity.put(internalSearchNode.getID(),internalSearchNode.getCity());
            return 1;
        }
        if(!isLast){
            suggestionRec(internalSearchNode);
            return 12;
        }
        return -1;
    }

    private void suggestionRec(FlopTrieNode internalSearchNode) {

        for(int i=0;i<FlopTrieNode.ALPHABET_SIZE;i++) {
            if(internalSearchNode.children[i]!=null){
                if (internalSearchNode.children[i].isEndOfWord()) {
                    idName.put(internalSearchNode.children[i].getID(),internalSearchNode.children[i].getName());
                    idCity.put(internalSearchNode.children[i].getID(),internalSearchNode.children[i].getCity());
                }
                else{
                    suggestionRec(internalSearchNode.children[i]);
                }
            }
        }
    }

    public String showSuggestion(int limit){
        Scanner sc = new Scanner(System.in);
        int counter = 1;
        for(Map.Entry<String,String> mapLoop : idName.entrySet()){
            if(counter>limit){
                break;
            }
            searchKeyID.put(counter,mapLoop.getKey());
            System.out.println(counter+"::\t"+mapLoop.getValue()+", "+ ZomatoAPISearch.getRegion(mapLoop.getKey()));
            counter++;
        }
        System.out.print(">>");
        int choice = sc.nextInt();
        return searchKeyID.get(choice);
    }
}
