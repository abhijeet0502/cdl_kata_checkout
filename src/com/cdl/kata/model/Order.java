package com.cdl.kata.model;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private Map<Item, Integer> itemsMap = new HashMap<>();
    private Map<Offer, Integer> offersMap = new HashMap<>();

    public Map<Item, Integer> getItemsMap() {
        return itemsMap;
    }

    public void setItemsMap(Map<Item, Integer> itemsMap) {
        this.itemsMap = itemsMap;
    }


    public Integer getItemQuantity(Item item) {
        return itemsMap.get(item);
    }

    public void addItemAndQuantity(Item item, Integer quantity) {
        removeItem(item);
        itemsMap.put(item, quantity);
    }

    public void removeItem(Item item) {
        itemsMap.remove(item);
    }

    public Map<Offer, Integer> getOffersMap() {
        return offersMap;
    }

    public void setOffersMap(Map<Offer, Integer> offersMap) {
        this.offersMap = offersMap;
    }

    public Integer getOfferQuantity(Offer offer) {
        return this.offersMap.get(offer);
    }

    public void addOfferAndQuantity(Offer offer, Integer qty) {
        this.offersMap.put(offer, qty);

    }
}
