package org.example.exercice3;

import java.util.Scanner;

public class Divisible {
    public static void isDivisibleBy() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisir un entier : ");
        int number = scanner.nextInt();
        if (number % 3 == 0){
            System.out.println("L'entier saisi est divisible par 3");
        }
        else {
            System.out.println("L'entier saisi n'est pas divisible par 3");
        }
    }
}
