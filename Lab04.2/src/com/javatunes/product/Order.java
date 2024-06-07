/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.product;

import java.util.Collection;

public class Order {
    private final String id;

    public Order(String id) {
        this.id = id;
    }

    /**
     *
     * get the items from the cart and iterate over them, print each item's product code
     * get cart total and print
     */
    /*This method commented out below is the same as the method below that
    it is just a different way. If you choose T you're defining T within the
    method parameters
    public <T extends Product> void processCart(ShoppingCart<T> cart) {
        System.out.println("Order: "+getId()+ " contains the following:");
        for(Product product: cart.allItems()){
            System.out.println(product);
        }
        System.out.println("Order total: "+ cart.total());

    }
    */
    public void processCart(ShoppingCart<? extends Product> cart) {
        System.out.println("Order: "+getId()+ " contains the following:");
        for(Product product: cart.allItems()){
            System.out.println(product);
        }
        System.out.println("Order total: "+ cart.total());

    }

    public String getId() {
        return id;
    }
}