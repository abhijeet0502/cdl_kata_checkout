package com.cdl.kata.model;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    List<StockItem> stockItems = new ArrayList<>();
    List<Offer> offers = new ArrayList<>();

    public List<StockItem> getStockItems() {
        return stockItems;
    }

    public void setStockItems(List<StockItem> stockItems) {
        this.stockItems = stockItems;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

}
