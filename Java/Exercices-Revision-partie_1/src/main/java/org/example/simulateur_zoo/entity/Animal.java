package org.example.simulateur_zoo.entity;

public abstract class Animal {
    protected String name;
    protected int age;

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

    @Override
    public String toString() {
        return "It’s a "+age+"-year-old "+ this.getClass().getSimpleName() +" called " + name;
    }
}
