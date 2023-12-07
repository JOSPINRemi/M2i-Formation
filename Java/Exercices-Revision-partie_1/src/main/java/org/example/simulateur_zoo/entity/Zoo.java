package org.example.simulateur_zoo.entity;

import java.util.ArrayList;
import java.util.List;

public class Zoo implements Subject {
    private static volatile Zoo instance = null;
    private static final Object lock = new Object();
    private List<Animal> animals;
    private List<Observer> observers;
    private Zoo() {
        this.animals = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    public static Zoo getInstance(){
        if (instance == null){
            synchronized (lock){
                instance = new Zoo();
            }
        }
        return instance;
    }

    public void addAnimal(Animal animal){
        this.animals.add(animal);
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
    public void notifyObservers(Animal animal) {
        observers.forEach(observer -> observer.update(animal));
    }
}
