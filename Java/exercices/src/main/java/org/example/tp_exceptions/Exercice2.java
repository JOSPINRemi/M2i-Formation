package org.example.tp_exceptions;

import java.util.Scanner;

public class Exercice2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisissez une chaîne de caractère :");
        String saisie;
        int intSaisie;
        try {
            saisie = scanner.nextLine().replaceAll(" ", "");
            intSaisie = Integer.parseInt(saisie);
            System.out.println(intSaisie);
        } catch (NumberFormatException e) {
            System.out.println("Le caractère saisi ne peut pas être converti en Integer");
        }
    }
}
