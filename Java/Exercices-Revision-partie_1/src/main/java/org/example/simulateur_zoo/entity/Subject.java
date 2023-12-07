package org.example.simulateur_zoo.entity;

public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);

    void notifyObservers(Animal animal);
}
