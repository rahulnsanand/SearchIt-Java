package com.searchit.tfg.floptrie;

import java.util.ArrayList;
import java.util.Map;

public class UpdateSearchList {

    public static ArrayList<String> searchListUpdate(FlopTrie.FlopTrieNode searchNode, ArrayList<String> list){
        for(int level = 0; level< FlopTrie.FlopTrieNode.ALPHABET_SIZE; level++) {
            if(searchNode.children[level]!=null){
                if (searchNode.children[level].isEndOfWord()) {
                    String name = searchNode.children[level].getName();
                    String city = searchNode.children[level].getCity();
                    list.add(name+", "+city);
                }
                else{
                    searchListUpdate(searchNode.children[level], list);
                }
            }
        }
        return list;
    }

    public static Map<String,String> hashMapUpdate(FlopTrie.FlopTrieNode flopTrieNode, Map<String, String> idSearch) {
        for(int level = 0; level< FlopTrie.FlopTrieNode.ALPHABET_SIZE; level++) {
            if(flopTrieNode.children[level]!=null){
                if (flopTrieNode.children[level].isEndOfWord()) {
                    String name = flopTrieNode.children[level].getName();
                    String city = flopTrieNode.children[level].getCity();
                    idSearch.put(name+", "+city,flopTrieNode.children[level].getID());
                }
                else{
                    hashMapUpdate(flopTrieNode.children[level], idSearch);
                }
            }
        }
        return idSearch;
    }
}
