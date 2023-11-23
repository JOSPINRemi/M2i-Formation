package org.example.poo.datastructure;

public class ElectricCar extends Engine implements Vehicule {

    public ElectricCar() {
        id = Engine.count;
    }

    @Override
    protected void test() {

    }

    @Override
    public void drive() {
        System.out.println("Je suis une electriccar qui roule");
    }

    @Override
    public void startEngine() {
        System.out.println("Je suis une electriccar qui démarre");
    }
}
