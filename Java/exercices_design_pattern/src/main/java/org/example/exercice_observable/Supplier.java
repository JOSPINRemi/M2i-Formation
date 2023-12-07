package org.example.exercice_observable;

public class Supplier implements Observer {
    @Override
    public void update(Product product) {
        System.out.println("Supplier : Stocklevel = " + product.getStockLevel());
    }
}
