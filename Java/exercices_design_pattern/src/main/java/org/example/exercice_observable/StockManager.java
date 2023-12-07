package org.example.exercice_observable;

public class StockManager implements Observer {
    @Override
    public void update(Product product) {
        System.out.println("StockManager : Stocklevel = " + product.getStockLevel());
    }
}
