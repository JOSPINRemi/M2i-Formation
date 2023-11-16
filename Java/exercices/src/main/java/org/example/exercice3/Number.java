package org.example.exercice3;

import java.util.Scanner;

public class Number {
    public static void getPositiveNegative() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisir un nombre");
        int nombre = scanner.nextInt();
        if (nombre < 0) {
            System.out.println("Votre nombre est négatif");
        } else {
            System.out.println("Votre nombre est positif");
        }
    }
}
