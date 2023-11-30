package org.example.tp_exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercice4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Compte compte = new Compte();
        System.out.println("Votre solde est de " + compte.getSolde());
        System.out.println("Combien voulez vous retirer : ");
        try {
            compte.retirer(scanner.nextDouble());
            System.out.println("Votre solde est désormais de : " + compte.getSolde());
        } catch (InputMismatchException e) {
            System.out.println("Saisie invalide");
        } catch (SoldeInsuffisantException e) {
            System.out.println(e.getMessage());
        }
    }
}
