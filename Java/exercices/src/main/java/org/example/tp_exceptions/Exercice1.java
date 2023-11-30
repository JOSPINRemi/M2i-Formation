package org.example.tp_exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercice1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dividende, diviseur;
        double resultat;
        try {
            System.out.println("Saisir le dividende :");
            dividende = scanner.nextInt();
            System.out.println("Saisir le diviseur :");
            diviseur = scanner.nextInt();
            resultat = dividende / diviseur;
            System.out.println("Résultat = " + resultat);
        } catch (ArithmeticException e) {
            System.out.println("Impossible de diviser par 0");
        } catch (InputMismatchException e) {
            System.out.println("Erreur dans la saisie");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
