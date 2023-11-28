package org.example.collections;

import java.util.Vector;

public class DemoCollections {
    public static void main(String[] args) {
//        Vector
        Vector<String> vector = new Vector<>();
        vector.add("Apple");
        vector.add("Banana");
        vector.add("Orange");
        System.out.println("Vector : " + vector);
//        Méthodes pour le vector
        System.out.println("1. Taille du vector : " + vector.size());
        System.out.println("2. Element à l'index 1 : " + vector.get(1));
        System.out.println("3. Est-ce que Apple est présent : " + vector.contains("Apple"));
    }
}
