package com.cdl.kata.service;


import com.cdl.kata.model.Inventory;
import com.cdl.kata.model.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryServiceTest {

    private Inventory inventory = null;

    @BeforeEach
    void setUp() {
        inventory = InventoryService.generateInventory();
    }

    @Test
    void generateInventoryTest() {

        assertNotNull(inventory.getStockItems());
        assertEquals(inventory.getStockItems().size(), 4);

        assertEquals(inventory.getStockItems().get(0).getItem().getSku(), "A");
        assertEquals(inventory.getStockItems().get(0).getItem().getPrice(), 50.0);

        assertEquals(inventory.getStockItems().get(1).getItem().getSku(), "B");
        assertEquals(inventory.getStockItems().get(1).getItem().getPrice(), 30.0);

        assertEquals(inventory.getStockItems().get(2).getItem().getSku(), "C");
        assertEquals(inventory.getStockItems().get(2).getItem().getPrice(), 20.0);

        assertEquals(inventory.getStockItems().get(3).getItem().getSku(), "D");
        assertEquals(inventory.getStockItems().get(3).getItem().getPrice(), 15.0);


        assertNotNull(inventory.getOffers());
        assertEquals(inventory.getOffers().size(), 2);

        assertEquals(inventory.getOffers().get(0).getItem().getSku(), "A");
        assertEquals(inventory.getOffers().get(0).getPrice(), 130.0);

        assertEquals(inventory.getOffers().get(1).getItem().getSku(), "B");
        assertEquals(inventory.getOffers().get(1).getPrice(), 45.0);
    }


    @Test
    void getItemNamesTest() {
        assertEquals(InventoryService.getItemNames(inventory), "[ Apple (code = A), Banana (code = B), Mango (code = C), Lemon (code = D) ]");
    }

    @Test
    void getInventoryItemTest() {

        Item inventoryItem = InventoryService.getInventoryItem("A", inventory);
        assertNotNull(inventoryItem);
        assertEquals(inventoryItem.getPrice(), 50.0);
        assertEquals(inventoryItem.getName(), "Apple");

        Item inventoryItem1 = InventoryService.getInventoryItem("X", inventory);
        assertNull(inventoryItem1);

    }
}