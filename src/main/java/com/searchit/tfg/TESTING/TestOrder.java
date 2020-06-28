package com.searchit.tfg.TESTING;

public class TestOrder {
    private String item;
    private String quantity;

    @Override
    public String toString() {
        return "TestOrder{" +
                "item='" + item + '\'' +
                ", quantity='" + quantity + '\'' +
                ", unitPrice='" + unitPrice + '\'' +
                '}';
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public TestOrder() {
    }

    public TestOrder(String item, String quantity, String unitPrice) {
        this.item = item;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    private String unitPrice;

}
