package com.searchit.tfg.TESTING;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "has_online_delivery",
        "price_range",
        "rating_text",
        "rating_color",
        "votes",
        "aggregate_rating",
        "res_id",
        "name",
        "cuisines",
        "average_cost_for_two",
        "has_table_booking",
        "latitude",
        "address",
        "city",
        "country_id",
        "locality_verbose",
        "city_id",
        "zipcode",
        "longitude",
        "locality",
        "featured_image",
        "currency",
        "id"
})

public abstract class JsonFields {
    @JsonProperty("votes")
    private String votes;
    @JsonProperty("has_online_delivery")
    private int has_online_delivery;
    @JsonProperty("price_range")
    private int price_range;
    @JsonProperty("rating_text")
    private String rating_text;
    @JsonProperty("rating_color")
    private String rating_color;
    @JsonProperty("aggregate_rating")
    private String aggregate_rating;
    @JsonProperty("res_id")
    private int res_id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("cuisines")
    private String cuisines;
    @JsonProperty("average_cost_for_two")
    private int average_cost_for_two;
    @JsonProperty("has_table_booking")
    private int has_table_booking;
    @JsonProperty("latitude")
    private String latitude;
    @JsonProperty("address")
    private String address;
    @JsonProperty("city")
    private String city;
    @JsonProperty("country_id")
    private int country_id;
    @JsonProperty("locality_verbose")
    private String locality_verbose;
    @JsonProperty("city_id")
    private int city_id;
    @JsonProperty("zipcode")
    private String zipcode;
    @JsonProperty("longitude")
    private String longitude;
    @JsonProperty("locality")
    private String locality;
    @JsonProperty("featured_image")
    private String featured_image;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("id")
    private String id;

    @JsonIgnore
    private int results_found;
    @JsonIgnore
    private String photos_url;
    @JsonIgnore
    private String url;
    @JsonIgnore
    private String apikey;
    @JsonIgnore
    private String deeplink;
    @JsonIgnore
    private String menu_url;
    @JsonIgnore
    private String book_url;
    @JsonIgnore
    private int switch_to_order_menu;
    @JsonIgnore
    private int is_delivering_now;
    @JsonIgnore
    private String[] offers;
    @JsonIgnore
    private String thumb;
    @JsonIgnore
    private String[] establishment_types;
    @JsonIgnore
    private String events_url;

}
