package org.example.poo.generique;

import org.example.model.Maison;

public class Main {
    public static void main(String[] args) {
        Boite<String> boite = new Boite<String>("toto");
        System.out.println(boite.getContenu());

        Boite<Maison> boite1 = new Boite<Maison>(new Maison("ma maison", 3));
        System.out.println(boite1.getContenu().nom);
    }
}
