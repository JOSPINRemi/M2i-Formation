package org.example.poo.datastructure;

public class PetrolCar extends Engine implements Vehicule {

    public PetrolCar() {
        id = Engine.count;
    }

    @Override
    public void drive() {
        System.out.println("Je suis une petrolcar qui roule");
    }

    @Override
    public void startEngine() {
        System.out.println("Je suis une petrolcar qui roule");
    }

    @Override
    protected void test() {
        System.out.println("Je suis une petrolcar qui démarre");
    }
}
