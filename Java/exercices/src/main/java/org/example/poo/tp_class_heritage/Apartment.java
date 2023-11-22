package org.example.poo.tp_class_heritage;

public class Apartment extends House {

    public Apartment() {
        super(50);
    }

    public void Display() {
        System.out.println("Je suis un appartement, ma surface est de " + this.getSurface() + " m2");
    }

}
