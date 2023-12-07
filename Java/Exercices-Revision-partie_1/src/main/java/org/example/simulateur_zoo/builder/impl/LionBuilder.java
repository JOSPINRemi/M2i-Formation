package org.example.simulateur_zoo.builder.impl;

import org.example.simulateur_zoo.builder.AnimalBuilder;
import org.example.simulateur_zoo.entity.Animal;
import org.example.simulateur_zoo.entity.impl.Lion;

public class LionBuilder extends AnimalBuilder {
    private String name;
    private int age;

    @Override
    public AnimalBuilder name(String name) {
        this.name = name;
        return this;
    }

    @Override
    public AnimalBuilder age(int age) {
        this.age = age;
        return this;
    }

    @Override
    public Animal build() {
        return new Lion(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
