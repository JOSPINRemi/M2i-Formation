package org.example.exercice_observable;

import java.util.ArrayList;
import java.util.List;

public class Product implements Subject {
    private int stockLevel;
    private List<Observer> observers;

    public Product(int stockLevel) {
        this.stockLevel = stockLevel;
        this.observers = new ArrayList<>();
    }

    public int getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(int stockLevel) {
        this.stockLevel = stockLevel;
        notifyObservers(this);
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Product product) {
        observers.forEach(observer -> observer.update(product));
    }
}
