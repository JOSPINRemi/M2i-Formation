package org.example.simulateur_zoo.entity.impl;

import org.example.simulateur_zoo.builder.impl.LionBuilder;
import org.example.simulateur_zoo.entity.Animal;

public class Lion extends Animal {
    public Lion(LionBuilder builder) {
        this.name = builder.getName();
        this.age = builder.getAge();
    }
}
