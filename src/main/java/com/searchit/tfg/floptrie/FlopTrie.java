package com.searchit.tfg.floptrie;

import com.searchit.tfg.TESTING.ZomatoWebOrder;

import java.util.*;

public class FlopTrie {

    public String URL;
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

    public FlopTrie() {
        rootLevelNode= new FlopTrieNode();
    }

    public void insert(String Name, String id, String url, String city){
        
        int level;
        int lengthName = Name.length();
        int lengthCity = city.length();
        int index;

        FlopTrieNode insertNode = rootLevelNode;

        for (level = 0; level < lengthName; level++) {
            index = CharToIndex(Name.charAt(level));
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
    public boolean hasData(String Name) {
        int level;
        int length = Name.length();
        int index;
        FlopTrieNode searchNode = rootLevelNode;
        for (level = 0; level < length; level++)
        {
            index = CharToIndex(Name.charAt(level));
            if (searchNode.children[index] == null)
                return false;
            searchNode = searchNode.children[index];
        }
        return (searchNode != null && searchNode.isEndOfWord);
    }
    public String getID(String word){
        int level;
        int length = word.length();
        int index;
        FlopTrieNode idSearchNode = rootLevelNode;
        if(hasData(word)){
            for (level = 0; level < length; level++)
            {
                index = word.charAt(level) - ' ';
                idSearchNode = idSearchNode.children[index];
            }
        }
        return idSearchNode.getID();
    }
    public String getCity(String word){
        int level;
        int length = word.length();
        int index;
        FlopTrieNode citySearchNode = rootLevelNode;
        if(hasData(word)){
            for (level = 0; level < length; level++)
            {
                index = CharToIndex(word.charAt(level));
                citySearchNode = citySearchNode.children[index];
            }
        }
        return citySearchNode.getCity();
    }
    public String getURL(String word){
        int level;
        int length = word.length();
        int index;
        FlopTrieNode urlSearchNode = rootLevelNode;
        if(hasData(word)){
            for (level = 0; level < length; level++)
            {
                index = CharToIndex(word.charAt(level));
                urlSearchNode = urlSearchNode.children[index];
            }
        }
        return urlSearchNode.getURL();
    }
    public String getName(String word){
        int level;
        int length = word.length();
        int index;
        FlopTrieNode nameSearchNode = rootLevelNode;
        if(hasData(word)){
            for (level = 0; level < length; level++)
            {
                index = CharToIndex(word.charAt(level));
                nameSearchNode = nameSearchNode.children[index];
            }
        }
        return nameSearchNode.getName();
    }
    public String getDetails(String word){
        int level;
        int length = word.length();
        int index;
        String Name = "", City = "", URL = "", ID = "";
        FlopTrieNode detailSearchNode = rootLevelNode;
        if(hasData(word)){
            for (level = 0; level < length; level++)
            {
                index = CharToIndex(word.charAt(level));
                detailSearchNode = detailSearchNode.children[index];
            }
        }
        ID = detailSearchNode.getID();
        Name = detailSearchNode.getName();
        City = detailSearchNode.getCity();
        URL = detailSearchNode.getURL();
        return "Restaurant Details\n\n" +
                "ID   :\t"+ID+"\n"+
                "Name :\t"+Name+"\n"+
                "City :\t"+City+"\n"+
                "URL  :\t"+URL;
    }

    public int CharToIndex(char a){
        return a-' ';
    }
    private boolean isLastNode(FlopTrieNode lastSearchNode){
        return lastSearchNode.isEndOfWord;
    }

    Map<String,String> suggestions = new HashMap<>();
    Map<Integer,String> keys = new HashMap<>();
    Map<String, String> values = new HashMap<>();

    public int getSuggestions(String word, int limit){
        FlopTrieNode internalSearchNode = rootLevelNode;
        int level;
        int len=word.length();
        int index;

        for(level=0; level<len; level++){
            index = CharToIndex(word.charAt(level));
            if(internalSearchNode==null){
                return 404;
            }
            if(internalSearchNode.isEndOfWord()){
                return 0;
            }
            internalSearchNode = internalSearchNode.children[index];
        }
        boolean isWord = internalSearchNode.isEndOfWord();
        boolean isLast = isLastNode(internalSearchNode);
        if(isWord && isLast){
            suggestions.put(internalSearchNode.getID(),word+internalSearchNode.getCity());
            values.put(internalSearchNode.getID(),word);
            URL=showSuggestion(limit);
            return -1;
        }
        if(!isLast){
            suggestionRec(internalSearchNode,word);
            URL=showSuggestion(limit);
            return -1;
        }
        URL=showSuggestion(limit);
        return -1;
    }

    private String getNameCity(FlopTrieNode node){
        return node.getName()+", "+node.getCity();
    }

    private void suggestionRec(FlopTrieNode internalSearchNode,String searchWord) {
        if(isLastNode(internalSearchNode)){
            System.out.println("Faulty data!");
        }

        for(int i=0;i<FlopTrieNode.ALPHABET_SIZE;i++) {
            if(internalSearchNode.children[i]!=null){
                if (internalSearchNode.children[i].isEndOfWord()) {
                    suggestions.put(getID(internalSearchNode.children[i].getName()),getNameCity(internalSearchNode.children[i]));
                    values.put(getID(internalSearchNode.children[i].getName()),internalSearchNode.children[i].getName());
                }
                else{
                    suggestionRec(internalSearchNode.children[i],searchWord);
                }
            }
        }
    }

    private String showSuggestion(int limit){
        Scanner sc = new Scanner(System.in);
        int counter = 1;
        for(Map.Entry<String,String> mapLoop : suggestions.entrySet()){
            if(counter>limit){
                break;
            }
            keys.put(counter,mapLoop.getKey());
            System.out.println(counter+"::\t"+mapLoop.getValue());
            counter++;
        }
        System.out.print(">>");
        int choice = sc.nextInt();
        return getURL(values.get(keys.get(choice)));
    }
}
