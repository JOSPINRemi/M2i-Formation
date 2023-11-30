package org.example.exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SimpleExemple {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer dividende = 0;
        Integer diviseur = 0;
        double resultat = 0;

        System.out.println("**** Division ****");
        try {
            System.out.println("Donnez-moi un dividende :");
            dividende = scanner.nextInt();
            System.out.println("Donnez-moi un diviseur :");
            diviseur = scanner.nextInt();
            resultat = dividende / diviseur;
            System.out.println("Résultat = " + resultat);
        }
        catch (ArithmeticException | InputMismatchException e){
            System.out.println("Message : " + e.getMessage());
        }
        /*catch (ArithmeticException ae){
            System.out.println(ae.getMessage());
        }
        catch (InputMismatchException ime){
            System.out.println("Problème de saisie !!! ");
        }*/
        catch (Exception e){
            System.out.println("Une exception !!!");
        }
        System.out.println("Fin du programme !!!");
    }
}
