package com.searchit.tfg.TESTING;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class JsonOrderLine {
    private String item;
    private int quantity;
    private BigDecimal unitPrice;

    public JsonOrderLine() {

    }

    public JsonOrderLine(String item, int quantity, BigDecimal unitPrice) {
        super();
        this.item = item;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    @JsonProperty("item")
    public String getItem() {
        return item;
    }
    @JsonProperty("item")
    public void setItem(String item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "OrderLine [item=" + item + ", quantity=" + quantity + ", unitPrice=" + unitPrice + "]";
    }
}
