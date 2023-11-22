package org.example.poo.tp_class_heritage;

public class House {
    private int surface;
    private Door door;

    public House(int surface) {
        this.surface = surface;
        door = new Door();
    }

    public int getSurface() {
        return surface;
    }

    public void setSurface(int surface) {
        this.surface = surface;
    }

    public Door getDoor() {
        return door;
    }

    public void Display() {
        System.out.println("Je suis une maison, ma surface est de " + this.surface + " m2");
    }
}
