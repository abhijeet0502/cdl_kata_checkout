package com.cdl.kata.service;

import com.cdl.kata.model.Inventory;
import com.cdl.kata.model.Item;
import com.cdl.kata.model.Offer;
import com.cdl.kata.model.StockItem;

import java.util.Arrays;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

public class InventoryService {

    private InventoryService() {

    }

    /**
     * This method generates Inventory can be replaced with DAO
     *
     * @return
     */
    public static Inventory generateInventory() {

        Inventory inventory = new Inventory();

        Item item1 = new Item("A", "Apple", 50);
        Item item2 = new Item("B", "Banana", 30);
        Item item3 = new Item("C", "Mango", 20);
        Item item4 = new Item("D", "Lemon", 15);

        inventory.setStockItems(
                Arrays.asList(
                        new StockItem(item1, 100),
                        new StockItem(item2, 100),
                        new StockItem(item3, 100),
                        new StockItem(item4, 100)));

        Offer offer1 = new Offer("Apple 3", item1, 3, 130);
        Offer offer2 = new Offer("Banana 2", item2, 2, 45);

        inventory.setOffers(Arrays.asList(offer1, offer2));
        return inventory;
    }


    /**
     * This method prints the list of available items and the corresponding SKU code.
     *
     * @param inventory
     * @return
     */
    public static String getItemNames(Inventory inventory) {
        StringBuilder sb = new StringBuilder();
        AtomicBoolean isFirst = new AtomicBoolean(true);
        sb.append("[ ");
        inventory.getStockItems().forEach(stockItem -> {
            if (isFirst.get()) {
                sb.append(stockItem.getItem().getName() + " (code = " + stockItem.getItem().getSku() + ")");
                isFirst.set(false);
            } else {
                sb.append(", ");
                sb.append(stockItem.getItem().getName() + " (code = " + stockItem.getItem().getSku() + ")");
            }
        });
        sb.append(" ]");
        return sb.toString();
    }


    /**
     * This method checks the SKU code provided by the customer to return the Item associated with it.
     *
     * @param sku
     * @param inventory
     * @return
     */
    public static Item getInventoryItem(String sku, Inventory inventory) {
        Optional<StockItem> optionalStockItem = inventory.getStockItems().stream().filter(stockItem ->
                stockItem.getItem().getSku().equalsIgnoreCase(sku)).findFirst();

        return optionalStockItem.isPresent() ? optionalStockItem.get().getItem() : null;
    }


}
