package com.cdl.kata;

import com.cdl.kata.model.Inventory;
import com.cdl.kata.model.Item;
import com.cdl.kata.model.Order;
import com.cdl.kata.service.InventoryService;
import com.cdl.kata.service.OrderService;

import java.util.Scanner;

public class CDLKataCheckoutMain {

    public static final String EXIT = "exit";

    public static void main(String[] args) {

        Inventory inventory = InventoryService.generateInventory();
        String itemNames = InventoryService.getItemNames(inventory);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter item that you to scan.");
        Order order = new Order();
        String input = null;

        while (!EXIT.equalsIgnoreCase(input)) {
            System.out.println("Available products " + itemNames);
            System.out.println("For checkout type : exit");
            input = scanner.nextLine();
            if (!EXIT.equals(input)) {
                final Item inventoryItem = InventoryService.getInventoryItem(input, inventory);
                if (inventoryItem == null) {
                    System.out.println("Please a valid item ");
                    System.out.println("Available products " + itemNames);
                } else {
                    order = OrderService.addItem(order, inventoryItem, inventory);
                    System.out.println("Order Total = £ " + OrderService.getOrderTotal(order));
                }
            }
        }
        OrderService.printOrderDetails(order);


    }
}
