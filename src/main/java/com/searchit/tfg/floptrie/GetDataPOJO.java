package com.searchit.tfg.floptrie;

public class GetDataPOJO {
    String res_id;
    String res_name;
    String res_city;
    String res_url;
    String res_region;

    public String getRes_id() {
        return res_id;
    }

    @Override
    public String toString() {
        return  "==================================\n"+
                "Restaurant ID      :" + res_id  + "\n"+
                "Restaurant Name    :" + res_name  + "\n"+
                "Restaurant City    :" + res_city  + "\n"+
                "Restaurant URL     :" + res_url  + "\n"+
                "==================================\n";
                //"Restaurant Region  :" + res_region + '\'';
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

    public String getRes_url() {
        return res_url;
    }

    public void setRes_url(String res_url) {
        this.res_url = res_url;
    }

    public String getRes_region() {
        return res_region;
    }

    public void setRes_region(String res_region) {
        this.res_region = res_region;
    }

    public GetDataPOJO() {
    }

    public GetDataPOJO(String res_id, String res_name, String res_city, String res_url, String res_region) {
        this.res_id = res_id;
        this.res_name = res_name;
        this.res_city = res_city;
        this.res_url = res_url;
        this.res_region = res_region;
    }
}
