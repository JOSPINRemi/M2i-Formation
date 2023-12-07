package org.example.simulateur_zoo.factory.impl;

import org.example.simulateur_zoo.builder.AnimalBuilder;
import org.example.simulateur_zoo.entity.Animal;
import org.example.simulateur_zoo.factory.AnimalFactory;

public class LionFactory extends AnimalFactory {
    @Override
    public Animal createAnimal(AnimalBuilder builder) {
        return builder.build();
    }
}
