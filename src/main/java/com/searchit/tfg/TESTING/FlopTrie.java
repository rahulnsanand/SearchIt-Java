package com.searchit.tfg.TESTING;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FlopTrie {
    FlopTrieNode root;

    public FlopTrie() {
        root = new FlopTrieNode();
        root.setName(null);
    }

    public void add(String name, String id, String url, String city) {
        FlopTrieNode current = root;
        current.setNext(null);

        for (char l : name.toCharArray()) {
            current = current.getChildren().computeIfAbsent(l, c -> new FlopTrieNode());
        }
        current.setNext(new FlopTrieNode());
        //Every character must be a node, every node must point to the next node. Every node must have all the
        //details required.
        current.setName(name);
        current.setID(id);
        current.setURL(url);
        current.setCity(city);
        current.setEndOfWord(true);
    }

    public boolean deleteData(String word) {
        return delete(root, word, 0);
    }

    public boolean hasData(String word) {
        FlopTrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            FlopTrieNode node = current.getChildren().get(ch);
            if (node == null) {
                return false;
            }
            current = node;
        }
        return current.isEndOfWord();
    }

    public List<String> getSuggestion(String word, int countSuggestion){
        List<String> suggestions = new ArrayList<>();
        FlopTrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            FlopTrieNode node  = current.getChildren().get(ch);
            current = node;
        }
        Map<Character, FlopTrieNode> map= current.getChildren();
        for(int i = 0; i<map.size(); i++){
            suggestions.add(map.get(i).toString());
        }

        return suggestions;
    }

    private String  returnPrefixSuggestion(FlopTrieNode node){
        String suggestWord= "Hello";
        return suggestWord;
    }

    public String getID(String word){
        FlopTrieNode current = root;
        String ID = "";
        if(hasData(word)){
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                FlopTrieNode node = current.getChildren().get(ch);
                current = node;
            }
            ID = current.getID();
        }
        else{
            return "That doesn't exist";
        }
        return ID;
    }
    public String getCity(String word){
        FlopTrieNode current = root;
        String ID = "";
        if(hasData(word)){
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                FlopTrieNode node = current.getChildren().get(ch);
                current = node;
            }
            ID = current.getCity();
        }
        else{
            return "That doesn't exist";
        }
        return ID;
    }
    public String getURL(String word){
        FlopTrieNode current = root;
        String ID = "";
        if(hasData(word)){
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                FlopTrieNode node = current.getChildren().get(ch);
                current = node;
            }
            ID = current.getURL();
        }
        else{
            return "That doesn't exist";
        }
        return ID;
    }
    public String getName(String word){
        FlopTrieNode current = root;
        String ID = "";
        if(hasData(word)){
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                FlopTrieNode node = current.getChildren().get(ch);
                current = node;
            }
            ID = current.getName();
        }
        else{
            return "That doesn't exist";
        }
        return ID;
    }
    public String getDetails(String word){
        FlopTrieNode current = root;
        String ID = "";
        String Name = "";
        String City = "";
        String URL = "";

        if(hasData(word)){
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                FlopTrieNode node = current.getChildren().get(ch);
                current = node;
            }
            ID = current.getID();
            Name = current.getName();
            City = current.getCity();
            URL = current.getURL();
        }
        else{
            return "That doesn't exist";
        }
        return "Restaurant Details\n\n" +
                "ID   :\t"+ID+"\n"+
                "Name :\t"+Name+"\n"+
                "City :\t"+City+"\n"+
                "URL  :\t"+URL;
    }

    public boolean isEmpty() {
        return root == null;
    }

    private boolean delete(FlopTrieNode current, String word, int index) {
        if (index == word.length()) {
            if (!current.isEndOfWord()) {
                return false;
            }
            current.setEndOfWord(false);
            current.setID("");
            current.setURL("");
            current.setCity("");
            current.setName("");
            return current.getChildren().isEmpty();
        }
        char ch = word.charAt(index);
        FlopTrieNode node = current.getChildren().get(ch);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(node, word, index + 1) && !node.isEndOfWord();

        if (shouldDeleteCurrentNode) {
            current.getChildren().remove(ch);
            return current.getChildren().isEmpty();
        }
        return false;
    }
}
