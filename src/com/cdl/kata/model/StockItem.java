package com.cdl.kata.model;

public class StockItem {

    private Item item;
    private int quantity;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public StockItem(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }
}
