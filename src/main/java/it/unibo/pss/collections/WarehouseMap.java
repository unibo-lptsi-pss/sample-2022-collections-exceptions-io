package it.unibo.pss.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

class WarehouseMap {
    private final Map<String, Integer> products = new HashMap<>();

    /**
     * Adds a product to the warehouse
     * 
     * @param product the product
     * @param quantity the quantity. Must be positive.
     * @throws IllegalArgumentException if the quantity is negative
     */
    public void addProduct(String product, int quantity) {
        if (quantity < 1) {
            final var exception = new IllegalArgumentException(
                "The quantity must be a positive number (provided: "
                + quantity
                + "for product "
                + product
                + ")"
            );
            throw exception;
        }
        final var currentQuantity = products.get(product);
        if (currentQuantity == null) {
            products.put(product, quantity);
        } else {
            products.put(product, quantity + currentQuantity);
        }
    }

    public Set<String> getProducts() {
        // final var copy = new ArrayList<String>(products.size());
        // Collections.copy(products, copy);
        // return copy;
        return Collections.unmodifiableSet(products.keySet());
    }

    @Override
    public String toString() {
        return products.toString();
    }

    public static void main(String[] args) {
        final WarehouseMap w = new WarehouseMap();
        w.addProduct("Nutella Biscuits", 1);
        w.addProduct("Qualunque cosa", 45678);
        w.addProduct("Caffè", 5);
        try {
            w.addProduct("Drogaaaa", 0);
        } catch (IllegalArgumentException | ArithmeticException e) {
            System.out.println("No alla droga");
            e.printStackTrace();
        } catch (IllegalStateException e) {
            System.out.println("Inatteso");
        } finally {
            System.out.println("FINALLY");
        }
        w.addProduct("Nutella Biscuits", 100);
        try {
            w.addProduct("Nutella Biscuits", -10);
        } finally {
            System.out.println(w);
        }
    }
}