package com.searchit.tfg.TESTING;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Map;

public class Product {

    private String URL;

    @Override
    public String toString() {
        return "Product{" +
                "URL='" + URL + '\'' +
                '}';
    }
    @JsonProperty("URL")
    public String getURL() {
        return URL;
    }
    @JsonProperty("URL")
    public void setURL(String URL) {
        this.URL = URL;
    }

    public Product() {
    }

    public Product(String URL) {
        this.URL = URL;
    }
}
