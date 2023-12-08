package org.example.simulateur_zoo.builder;

import org.example.simulateur_zoo.entity.Animal;

public abstract class AnimalBuilder {
    protected String name;
    protected int age;

    public abstract AnimalBuilder name(String name);

    public abstract AnimalBuilder age(int age);

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public abstract Animal build();
}
