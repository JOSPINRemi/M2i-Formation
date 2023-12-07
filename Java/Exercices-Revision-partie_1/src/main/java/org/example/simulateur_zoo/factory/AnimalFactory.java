package org.example.simulateur_zoo.factory;

import org.example.simulateur_zoo.builder.AnimalBuilder;
import org.example.simulateur_zoo.entity.Animal;

public abstract class AnimalFactory {
    protected abstract Animal createAnimal(AnimalBuilder builder);
}
