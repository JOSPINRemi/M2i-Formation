package org.example.poo.tp_class_heritage;

public class Person2 {
    private String nom;
    private House house;

    public Person2(String nom, House house) {
        this.nom = nom;
        this.house = house;
    }

    public void Display() {
        System.out.println("Je m'appelle " + this.nom + ".");
        this.house.Display();
        this.house.getDoor().Display();
    }
}
