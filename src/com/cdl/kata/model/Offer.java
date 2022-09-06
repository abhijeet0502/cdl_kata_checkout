package com.cdl.kata.model;

import java.util.Objects;

public class Offer {

    private String name;
    private Item item;
    private int quantity;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Offer(String name, Item item, int quantity, double price) {
        this.name = name;
        this.item = item;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Offer)) return false;
        Offer offer = (Offer) o;
        return getQuantity() == offer.getQuantity() && Double.compare(offer.getPrice(), getPrice()) == 0 && Objects.equals(getName(), offer.getName()) && Objects.equals(getItem(), offer.getItem());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getItem(), getQuantity(), getPrice());
    }
}
