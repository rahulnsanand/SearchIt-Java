package com.searchit.tfg.dataset.utils;


import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderLine {
    private String NAME;
    private String PRICE;
    private String CUSINE_CATEGORY;
    private String CITY;
    private String REGION;
    private String URL;
    private String PAGE_NO;
    private String CUSINE_TYPE;
    private String TIMING;
    private String RATING_TYPE;
    private String RATING;
    private String VOTES;

    @Override
    public String toString() {
        return "OrderLine{" +
                "NAME='" + NAME + '\'' +
                ", PRICE='" + PRICE + '\'' +
                ", CUSINE_CATEGORY='" + CUSINE_CATEGORY + '\'' +
                ", CITY='" + CITY + '\'' +
                ", REGION='" + REGION + '\'' +
                ", URL='" + URL + '\'' +
                ", PAGE_NO='" + PAGE_NO + '\'' +
                ", CUSINE_TYPE='" + CUSINE_TYPE + '\'' +
                ", TIMING='" + TIMING + '\'' +
                ", RATING_TYPE='" + RATING_TYPE + '\'' +
                ", RATING='" + RATING + '\'' +
                ", VOTES='" + VOTES + '\'' +
                '}';
    }

    @JsonProperty("NAME")
    public String getNAME() {
        return NAME;
    }
    @JsonProperty("NAME")
    public void setNAME(String NAME) {
        this.NAME = NAME;
    }
    @JsonProperty("PRICE")
    public String getPRICE() {
        return PRICE;
    }
    @JsonProperty("PRICE")
    public void setPRICE(String PRICE) {
        this.PRICE = PRICE;
    }
    @JsonProperty("CUSINE_CATEGORY")
    public String getCUSINE_CATEGORY() {
        return CUSINE_CATEGORY;
    }
    @JsonProperty("CUSINE_CATEGORY")
    public void setCUSINE_CATEGORY(String CUSINE_CATEGORY) {
        this.CUSINE_CATEGORY = CUSINE_CATEGORY;
    }
    @JsonProperty("CITY")
    public String getCITY() {
        return CITY;
    }
    @JsonProperty("CITY")
    public void setCITY(String CITY) {
        this.CITY = CITY;
    }
    @JsonProperty("REGION")
    public String getREGION() {
        return REGION;
    }
    @JsonProperty("REGION")
    public void setREGION(String REGION) {
        this.REGION = REGION;
    }
    @JsonProperty("URL")
    public String getURL() {
        return URL;
    }
    @JsonProperty("URL")
    public void setURL(String URL) {
        this.URL = URL;
    }
    @JsonProperty("PAGE NO")
    public String getPAGE_NO() {
        return PAGE_NO;
    }
    @JsonProperty("PAGE NO")
    public void setPAGE_NO(String PAGE_NO) {
        this.PAGE_NO = PAGE_NO;
    }
    @JsonProperty("CUSINE TYPE")
    public String getCUSINE_TYPE() {
        return CUSINE_TYPE;
    }
    @JsonProperty("CUSINE TYPE")
    public void setCUSINE_TYPE(String CUSINE_TYPE) {
        this.CUSINE_TYPE = CUSINE_TYPE;
    }
    @JsonProperty("TIMING")
    public String getTIMING() {
        return TIMING;
    }
    @JsonProperty("TIMING")
    public void setTIMING(String TIMING) {
        this.TIMING = TIMING;
    }
    @JsonProperty("RATING_TYPE")
    public String getRATING_TYPE() {
        return RATING_TYPE;
    }
    @JsonProperty("RATING_TYPE")
    public void setRATING_TYPE(String RATING_TYPE) {
        this.RATING_TYPE = RATING_TYPE;
    }
    @JsonProperty("RATING")
    public String getRATING() {
        return RATING;
    }
    @JsonProperty("RATING")
    public void setRATING(String RATING) {
        this.RATING = RATING;
    }
    @JsonProperty("VOTES")
    public String getVOTES() {
        return VOTES;
    }
    @JsonProperty("VOTES")
    public void setVOTES(String VOTES) {
        this.VOTES = VOTES;
    }
    public OrderLine() {
    }

    public OrderLine(String NAME, String PRICE, String CUSINE_CATEGORY, String CITY, String REGION, String URL, String PAGE_NO, String CUSINE_TYPE, String TIMING, String RATING_TYPE, String RATING, String VOTES) {
        this.NAME = NAME;
        this.PRICE = PRICE;
        this.CUSINE_CATEGORY = CUSINE_CATEGORY;
        this.CITY = CITY;
        this.REGION = REGION;
        this.URL = URL;
        this.PAGE_NO = PAGE_NO;
        this.CUSINE_TYPE = CUSINE_TYPE;
        this.TIMING = TIMING;
        this.RATING_TYPE = RATING_TYPE;
        this.RATING = RATING;
        this.VOTES = VOTES;
    }
}