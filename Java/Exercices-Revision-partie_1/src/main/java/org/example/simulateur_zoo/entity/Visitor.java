package org.example.simulateur_zoo.entity;

public class Visitor implements Observer {
    @Override
    public void update(Animal animal) {
        System.out.println("New animal has been added to the zoo");
    }
}
