package com.searchit.tfg.TESTING;

import java.util.HashMap;

class TrieNode {
    public TrieNode(char ch)  {
        value = ch;
        children = new HashMap<>();
        bIsEnd = false;
    }
    public HashMap<Character,TrieNode> getChildren(){
        return children;
    }
    public char getValue(){
        return value;
    }
    public void setIsEnd(boolean val){
        bIsEnd = val;
    }
    public boolean isEnd(){
        return bIsEnd;
    }

    private final char value;
    private final HashMap<Character,TrieNode> children;
    private boolean bIsEnd;
}
