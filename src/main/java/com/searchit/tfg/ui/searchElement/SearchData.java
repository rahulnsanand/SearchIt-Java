package com.searchit.tfg.ui.searchElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SearchData {

    public Map<String, String> nameIDMap = new HashMap<>();
    public ArrayList<String> nameList = new ArrayList<>();
    public String selectedID;
    public String selectedItem;

    public SearchData() {
    }

    public Map<String, String> getNameIDMap() {
        return nameIDMap;
    }

    public void setNameIDMap(Map<String, String> nameIDMap) {
        this.nameIDMap = nameIDMap;
    }

    public ArrayList<String> getNameList() {
        return nameList;
    }

    public void setNameList(ArrayList<String> nameList) {
        this.nameList = nameList;
    }

    public String getSelectedID() {
        return selectedID;
    }

    public void setSelectedID(String selectedID) {
        this.selectedID = selectedID;
    }

    public String getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(String selectedItem) {
        this.selectedItem = selectedItem;
    }

    public SearchData(Map<String, String> nameIDMap, ArrayList<String> nameList, String selectedID, String selectedItem) {
        this.nameIDMap = nameIDMap;
        this.nameList = nameList;
        this.selectedID = selectedID;
        this.selectedItem = selectedItem;
    }
}
