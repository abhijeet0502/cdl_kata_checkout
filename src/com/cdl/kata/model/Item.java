package com.cdl.kata.model;

import java.util.Objects;

public class Item {
    private String sku;
    private String name;
    private float price;

    public Item(String sku, String name, float price) {
        this.sku = sku;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return Float.compare(item.getPrice(), getPrice()) == 0 && Objects.equals(getSku(), item.getSku()) && Objects.equals(getName(), item.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSku(), getName(), getPrice());
    }
}
