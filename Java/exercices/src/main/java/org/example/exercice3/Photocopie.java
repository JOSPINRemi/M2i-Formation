package org.example.exercice3;

import java.util.Scanner;

public class Photocopie {
    public static void getPrice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisir le nombre de photocopie : ");
        int number = scanner.nextInt();
        if (number <= 0){
            System.out.println("Le nombre de photocopie ne peut pas être négatif ou nul");
        }
        else if (number < 10){
            System.out.println("Vous allez payer : " + (float)(number * 0.15));
        }
        else if (number <= 20){
            System.out.println("Vous allez payer : " + (float)(number * 0.1));
        }
        else {
            System.out.println("Vous allez payer : " + (float)(number * 0.05));
        }
    }
}
