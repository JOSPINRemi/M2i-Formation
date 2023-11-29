package org.example.collections;

import java.util.*;

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

//        SortedSet (TreeSet)
        SortedSet<String> sortedSet = new TreeSet<>();
        sortedSet.add("Java");
        sortedSet.add("Python");
//        sortedSet.add("Python"); // Pas de doublon
        sortedSet.add("C++");
        System.out.println("SortedSet : " + sortedSet);
//        Méthodes pour les SortedSet
        System.out.println("1. Premier élément : " + sortedSet.first());
        System.out.println("2. Dernier élément : " + sortedSet.last());
        SortedSet<String> headSet = sortedSet.headSet("Python");
        System.out.println("3. Sous-ensemble avant 'Python' : " + headSet);

//        LinkedList
        LinkedList<Double> linkedList = new LinkedList<>();
        linkedList.add(3.14);
        linkedList.add(2.71);
        linkedList.add(1.85);
        System.out.println("LinkedList : " + linkedList);
//        Méthodes pour les LinkedList
        System.out.println("1. Premier élément : " + linkedList.getFirst());
        System.out.println("2. Dernier élément : " + linkedList.getLast());
        linkedList.removeFirst();
        System.out.println("3. Suppression du premier élément : " + linkedList);

//        SortedMap (TreeMap)
        SortedMap<String, Integer> sortedMap = new TreeMap<>();
        sortedMap.put("Java", 20);
        sortedMap.put("Python", 20);
        sortedMap.put("C++", 20);
        System.out.println("SortedMap : " + sortedMap);
//        Méthodes pour les SortedMap
        System.out.println("1. Clés de sortedMap : " + sortedMap.keySet());
        System.out.println("2. Valeurs de la sortedMap : " + sortedMap.values());
        System.out.println("3. Supprimer l'entrée avec la clé 'Java'");
        sortedMap.remove("Java");
        System.out.println("sortedMap après suppression : " + sortedMap);
        for (String k : sortedMap.keySet()) {
            System.out.println("Clé : " + k + " Valeur : " + sortedMap.get(k));
        }

//        HashMap
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Java", 20);
        hashMap.put("Python", 10);
        hashMap.put("C++", 30);
        System.out.println("HashMap : " + hashMap);
//        Méthodes pour les HashMap
        System.out.println("1. Taille du hashmap " + hashMap.size());
        System.out.println("2. Valeur associée à la clé 'Java'" + hashMap.get("Java"));
        System.out.println("3. La clé 'javascript' est elle présente : " + hashMap.containsKey("javascript"));
        System.out.println("Suppression de l'entrée avec la clé 'Python'");
        hashMap.remove("Python");
        System.out.println("hashMap : " + hashMap);
    }
}
