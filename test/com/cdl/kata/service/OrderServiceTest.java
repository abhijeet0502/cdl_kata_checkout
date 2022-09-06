package com.cdl.kata.service;

import com.cdl.kata.model.Inventory;
import com.cdl.kata.model.Item;
import com.cdl.kata.model.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    private Inventory inventory = null;
    private Order order = null;


    @BeforeEach
    void setUp() {
        inventory = InventoryService.generateInventory();
        order = new Order();
        Map<Item, Integer> itemsMap = new HashMap<>();
        itemsMap.put(InventoryService.getInventoryItem("A", inventory), Integer.valueOf(2));
        itemsMap.put(InventoryService.getInventoryItem("B", inventory), Integer.valueOf(1));
        itemsMap.put(InventoryService.getInventoryItem("C", inventory), Integer.valueOf(4));
        order.setItemsMap(itemsMap);
        order.setOffersMap(new HashMap<>());

    }

    @Test
    void addItem() {

        //order total £2.1
        assertEquals(OrderService.getOrderTotal(order), 2.1);


        //Add item A to order so that it will be added to offer
        Order updatedOrder = OrderService.addItem(order, InventoryService.getInventoryItem("A", inventory), inventory);
        assertNotNull(updatedOrder);

        //Item A will be removed from the itemsMap
        assertNull(updatedOrder.getItemsMap().get(InventoryService.getInventoryItem("A", inventory)));

        //Offer Apple 3 will be added to the offersMap
        assertNotNull(updatedOrder.getOffersMap().get(inventory.getOffers().get(0)));

        //orderTotal updated to 2.40 instead of 2.60
        assertEquals(OrderService.getOrderTotal(order), 2.4);


        //Add item B to order so that it will be added to offer
        updatedOrder = OrderService.addItem(updatedOrder, InventoryService.getInventoryItem("B", inventory), inventory);
        assertNotNull(updatedOrder);

        //Item B will be removed from the itemsMap
        assertNull(updatedOrder.getItemsMap().get(InventoryService.getInventoryItem("B", inventory)));

        //Offer Banan 2 will be added to the offersMap
        assertNotNull(updatedOrder.getOffersMap().get(inventory.getOffers().get(1)));

        //orderTotal updated to 2.70 instead of 2.55
        assertEquals(OrderService.getOrderTotal(order), 2.55);


    }

    @Test
    void getOrderTotal() {

        //order total £2.1
        assertEquals(OrderService.getOrderTotal(order), 2.1);
    }


}