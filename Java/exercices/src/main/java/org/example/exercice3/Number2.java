package org.example.exercice3;

import java.util.Scanner;

public class Number2 {
    public static void getPositiveNegativeOrNull() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisir un nombre");
        int number = scanner.nextInt();
        if (number < 0){
            System.out.println("Le nombre est négatif");
        }
        else if (number == 0){
            System.out.println("Le nombre est nul");
        }
        else {
            System.out.println("Le nombre est positif");
        }
    }
}
