package org.example.simulateur_zoo.entity;

public class Visitor implements Observer {
    private String name;

    public Visitor(String name) {
        this.name = name;
    }

    @Override
    public void update(Animal animal) {
        System.out.println("Hey " + name + ", a new animal has been added to the zoo.");
        System.out.println(animal + ", come and admire it!\n");
    }
}
