package org.example;

import org.example.exercice_builder.Pizza;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//        Exercice builder
        Pizza pizza = new Pizza.Builder()
                .taille("moyenne")
                .typeDePate("fine")
                .fromage("mozzarella")
                .garnitures(new ArrayList<>(Arrays.asList("jambon", "champignons")))
                .typeDeSauce("tomate")
                .build();
        System.out.println(pizza);
    }
}