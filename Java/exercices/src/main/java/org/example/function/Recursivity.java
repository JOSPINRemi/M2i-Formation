package org.example.function;

import java.util.Scanner;

public class Recursivity {

    public static void exoFactorielle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisir un nombre :");
        int number = scanner.nextInt();
        System.out.println("La factorielle de " + number + " est " + factorielle(number));
    }

    public static int factorielle(int value) {
        if (value == 0) {
            return 1;
        }
        return value * factorielle(value - 1);
    }
}
