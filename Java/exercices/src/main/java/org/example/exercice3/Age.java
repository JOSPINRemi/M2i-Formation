package org.example.exercice3;

import java.util.Scanner;

public class Age {
    public static void getCategory() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisir l'âge de l'enfant");
        int age = scanner.nextInt();
        if (age >= 6 && age <= 7) {
            System.out.println("Votre enfant est un poussin");
        }
        else if (age >= 8 && age <= 9) {
            System.out.println("Votre enfant est un pupille");
        }
        else if (age >= 10 && age <= 11) {
            System.out.println("Votre enfant est un minime");
        }
        else if (age >= 12) {
            System.out.println("Votre enfant est un cadet");
        }
    }
}
