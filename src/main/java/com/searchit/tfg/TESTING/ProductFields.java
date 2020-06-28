package com.searchit.tfg.TESTING;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "id",
        "name",
        "brandname",
        "ownername"

})

public abstract class ProductFields {


    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("brandname")
    private String brandname;
    @JsonProperty("ownername")
    private String ownername;

}
