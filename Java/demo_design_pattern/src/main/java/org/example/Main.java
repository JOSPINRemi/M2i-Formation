package org.example;

import org.example.demo_abstractfactory.Application;
import org.example.demo_abstractfactory.MacFactory;
import org.example.demo_abstractfactory.WinFactory;
import org.example.demo_builder.Voiture;
import org.example.demo_singleton.Person;
import org.example.demo_singleton.Storage;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        Demo Builder
        /*Voiture voiture = new Voiture.Builder()
                .marque("tesla")
                .modele("3")
                .build();

        voiture = new Voiture.Builder()
                .marque("m1")
                .build();*/

//        Demo Abstract Factory
//        Application Mac
//        Application applicationMac = new Application(new MacFactory());

//        Application Windows
//        Application applicationWindows = new Application(new WinFactory());

//        Demo Singleton
        List<Person> liste = Storage.getInstance().getPersonList();
        liste = Storage.getInstance().getPersonList();
    }
}
