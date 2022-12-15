package it.unibo.pss.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class Warehouse {
    private final List<String> products = new ArrayList<>();

    public void addProduct(String product) {
        products.add(product);
    }

    public List<String> getProducts() {
        // final var copy = new ArrayList<String>(products.size());
        // Collections.copy(products, copy);
        // return copy;
        return Collections.unmodifiableList(products);
    }

    public void sortItems() {
        Collections.sort(products);
    }

    @Override
    public String toString() {
        return products.toString();
    }

    public static void main(String[] args) {
        final Warehouse w = new Warehouse();
        w.addProduct("Nutella Biscuits");
        w.addProduct("Qualunque cosa");
        w.addProduct("Caffè");
        w.addProduct("Drogaaaa");
        w.sortItems();
        System.out.println(w);
        // Escobar
        var products = w.getProducts();
        Collections.shuffle(products);
        System.out.println(w);
    }
}