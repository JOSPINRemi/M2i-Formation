package org.example.exercice3;

import java.util.Scanner;

public class ThreeNames {
    public static void getOrder() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisir un premier nom : ");
        String name1 = scanner.next();

        System.out.println("Saisir un second nom : ");
        String name2 = scanner.next();

        System.out.println("Saisir un dernier nom : ");
        String name3 = scanner.next();

        if (name1.compareToIgnoreCase(name2) <= 0 && name2.compareToIgnoreCase(name3) <= 0) {
            System.out.println("Les noms sont dans l'ordre");
        } else {
            System.out.println("Les noms ne sont pas dans l'ordre");
        }
    }
}