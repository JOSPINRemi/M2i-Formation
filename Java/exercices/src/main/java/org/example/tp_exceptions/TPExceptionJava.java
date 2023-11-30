package org.example.tp_exceptions;

import java.util.Scanner;

public class TPExceptionJava {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        System.out.println("Saisir les valeurs d'un tableau d'entier séparées par un espace :");
        String numbers = scanner.nextLine();
        String[] stringNumbers = numbers.split(" ");
        try {
            for (int i = 0; i < stringNumbers.length; i++) {
                sum += Integer.parseInt(stringNumbers[i]);
            }
            System.out.println(sum);
        } catch (NumberFormatException e) {
            System.out.println("Une valeur du tableau ne peut pas être convertie en entier");
        }
    }
}
