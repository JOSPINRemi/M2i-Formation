package org.example.poo.datastructure;

public class MotorCycle extends Engine implements Vehicule {

    public MotorCycle() {
        id = Engine.count;
    }

    @Override
    protected void test() {

    }

    @Override
    public void drive() {
        System.out.println("Je suis une motorcycle qui roule");
    }

    @Override
    public void startEngine() {
        System.out.println("Je suis une motorcycle qui démarre");
    }
}
