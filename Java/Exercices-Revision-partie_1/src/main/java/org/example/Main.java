package org.example;

import org.example.simulateur_zoo.builder.impl.LionBuilder;
import org.example.simulateur_zoo.entity.Visitor;
import org.example.simulateur_zoo.entity.Zoo;
import org.example.simulateur_zoo.factory.impl.LionFactory;

public class Main {
    public static void main(String[] args) {
//        Simulateur de zoo
        Zoo zoo = Zoo.getInstance();
        LionFactory lionFactory = new LionFactory();
        Visitor visitor = new Visitor("Albert");

        zoo.registerObserver(visitor);

//        Add a lion
        zoo.addAnimal(lionFactory.createAnimal(new LionBuilder()
                .name("Leo")
                .age(5)
        ));

//        Add a lion
        zoo.addAnimal(lionFactory.createAnimal(new LionBuilder()
                .name("Nala")
        ));
    }
}