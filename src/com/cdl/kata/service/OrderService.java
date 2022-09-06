package com.cdl.kata.service;

import com.cdl.kata.model.Inventory;
import com.cdl.kata.model.Item;
import com.cdl.kata.model.Offer;
import com.cdl.kata.model.Order;

import java.util.concurrent.atomic.AtomicReference;

public class OrderService {
    private OrderService() {

    }


    /**
     * This method adds an item to the order and updates the itemsMap and offersMap depending on the item that has to be added
     *
     * @param order
     * @param newItem
     * @param inventory
     * @return
     */
    public static Order addItem(Order order, Item newItem, Inventory inventory) {

        Integer newItemQuantity = getNewItemQuantity(newItem, order);
        Offer offer = getOfferForItem(newItem, inventory);

        if (offer == null) {
            order.addItemAndQuantity(newItem, newItemQuantity);
        } else if (newItemQuantity == offer.getQuantity()) {
            addOfferInToOrder(newItem, order, offer);
        } else {
            order.addItemAndQuantity(newItem, newItemQuantity);
        }
        return order;
    }


    /**
     * This method will add an offer to the order by removing all the previous quantities of that item from the itemsMap.
     *
     * @param newItem
     * @param order
     * @param offer
     */
    private static void addOfferInToOrder(Item newItem, Order order, Offer offer) {
        order.removeItem(newItem);
        Integer offerCount = order.getOfferQuantity(offer);
        if (offerCount == null) {
            offerCount = 0;
        }
        offerCount = offerCount + 1;
        order.addOfferAndQuantity(offer, offerCount);
    }


    /**
     * This method will the quantity of the item present including the current Item.
     *
     * @param item
     * @param order
     * @return
     */
    private static Integer getNewItemQuantity(Item item, Order order) {
        Integer qty = order.getItemQuantity(item);
        return qty == null ? 1 : qty + 1;
    }

    /**
     * This method will return the offer corresponding the given item.
     *
     * @param item
     * @param inventory
     * @return
     */
    private static Offer getOfferForItem(Item item, Inventory inventory) {
        return inventory.getOffers().stream().filter(offer -> offer.getItem().equals(item)).findFirst().orElse(null);
    }


    /**
     * This method will return the order total in £
     *
     * @param order
     * @return
     */
    public static double getOrderTotal(Order order) {

        AtomicReference<Double> orderTotal = new AtomicReference<>(0.0);

        order.getItemsMap().forEach((item, qty) -> orderTotal.updateAndGet(d -> d + (item.getPrice() * qty)));
        order.getOffersMap().forEach((offer, qty) -> orderTotal.updateAndGet(d -> d + (offer.getPrice() * qty)));
        return orderTotal.get() / 100;
    }

    /**
     * This method will print the Final order details and order total after user enters the exit string.
     *
     * @param order
     */
    public static void printOrderDetails(Order order) {

        order.getItemsMap().forEach((item, qty) -> {
            System.out.println(item.getName() + " x " + qty + " = £ " + (item.getPrice() * qty) / 100);
        });
        order.getOffersMap().forEach((offer, qty) -> {
            System.out.println(offer.getName() + " x " + qty + " = £ " + (offer.getPrice() * qty) / 100);
        });
        System.out.println("Order Total = £ " + getOrderTotal(order));
    }
}
