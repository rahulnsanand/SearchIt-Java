package com.searchit.tfg.dataset.utils;


import com.fasterxml.jackson.annotation.JsonProperty;

public class FinalJsonOrder {
    private String res_no;
    private String res_id;
    private String res_name;
    private String res_city;
    private String res_cuisine;
    private String res_url;

    public String getRes_no() {
        return res_no;
    }

    public void setRes_no(String res_no) {
        this.res_no = res_no;
    }

    public String getRes_id() {
        return res_id;
    }

    public void setRes_id(String res_id) {
        this.res_id = res_id;
    }

    public String getRes_name() {
        return res_name;
    }

    public void setRes_name(String res_name) {
        this.res_name = res_name;
    }

    public String getRes_city() {
        return res_city;
    }

    public void setRes_city(String res_city) {
        this.res_city = res_city;
    }

    public String getRes_cuisine() {
        return res_cuisine;
    }

    public void setRes_cuisine(String res_cuisine) {
        this.res_cuisine = res_cuisine;
    }

    public String getRes_url() {
        return res_url;
    }

    public void setRes_url(String res_url) {
        this.res_url = res_url;
    }

    public FinalJsonOrder() {
    }

    @Override
    public String toString() {
        return "FinalJsonOrder{" +
                "res_no='" + res_no + '\'' +
                ", res_id='" + res_id + '\'' +
                ", res_name='" + res_name + '\'' +
                ", res_city='" + res_city + '\'' +
                ", res_cuisine='" + res_cuisine + '\'' +
                ", res_url='" + res_url + '\'' +
                '}';
    }

    public FinalJsonOrder(String res_no, String res_id, String res_name, String res_city, String res_cuisine, String res_url) {
        this.res_no = res_no;
        this.res_id = res_id;
        this.res_name = res_name;
        this.res_city = res_city;
        this.res_cuisine = res_cuisine;
        this.res_url = res_url;
    }
}