package org.example.exercice3;

import java.util.Scanner;

public class TwoNumbers {
    public static void getProductPositiveNegative() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Saisir un premier nombre");
        int nombre1 = scanner.nextInt();

        System.out.println("Saisir un second nombre");
        int nombre2 = scanner.nextInt();

        if ((nombre1 * nombre2) < 0) {
            System.out.println("Le produit des nombres est négatif");
        } else {
            System.out.println("Le produit des nombres est positif");
        }
    }
}
