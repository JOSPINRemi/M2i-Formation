package org.example;

import org.example.simulateur_zoo.builder.impl.LionBuilder;
import org.example.simulateur_zoo.entity.Visitor;
import org.example.simulateur_zoo.entity.Zoo;
import org.example.simulateur_zoo.factory.impl.LionFactory;

public class Main {
    public static void main(String[] args) {
        Zoo zoo = Zoo.getInstance();
        LionFactory lionFactory = new LionFactory();
        Visitor visitor = new Visitor();

        zoo.registerObserver(visitor);

        // FIXME: 07/12/2023 Problème lors de la notification
//        Ajouter un lion
        zoo.addAnimal(lionFactory.createAnimal(new LionBuilder()
                .name("leo")
                .age(5)
        ));
    }
}