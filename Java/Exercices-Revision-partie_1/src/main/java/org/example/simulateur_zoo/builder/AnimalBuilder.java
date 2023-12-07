package org.example.simulateur_zoo.builder;

import org.example.simulateur_zoo.entity.Animal;

public abstract class AnimalBuilder {
    public abstract AnimalBuilder name(String name);
    public abstract AnimalBuilder age(int age);
    public abstract Animal build();
}
