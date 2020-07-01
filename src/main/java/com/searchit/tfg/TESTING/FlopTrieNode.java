package com.searchit.tfg.TESTING;

import java.util.HashMap;
import java.util.Map;

class FlopTrieNode {

    private FlopTrieNode next;
    private final Map<Character, FlopTrieNode> children = new HashMap<>();
    private boolean endOfWord;
    private String ID;
    private String URL;
    private String City;
    private String Name;

    public FlopTrieNode getNext() {
        return next;
    }

    public void setNext(FlopTrieNode next) {
        this.next = next;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    Map<Character, FlopTrieNode> getChildren() {
        return children;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    boolean isEndOfWord() {
        return endOfWord;
    }

    String getID(){
        return ID;
    }
    void setID(String id){
        this.ID = id;
    }

    void setEndOfWord(boolean endOfWord) {
        this.endOfWord = endOfWord;
    }
}
