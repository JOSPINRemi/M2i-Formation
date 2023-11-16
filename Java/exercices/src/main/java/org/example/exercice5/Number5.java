package org.example.exercice5;

import java.util.Scanner;

public class Number5 {
    public static void numberBetweenOneAndThree() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisir un nombre compris entre 1 et 3 : ");
        int number = scanner.nextInt();
        while (number < 1 || number > 3) {
            System.out.println("Nombre incorrect\n");
            System.out.println("Saisir un nombre compris entre 1 et 3 : ");
            number = scanner.nextInt();
        }
        System.out.println("Number : " + number);
        scanner.close();
    }

    public static void numberBetweenTenAndTwenty() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisir un nombre compris entre 10 et 20 : ");
        int number = scanner.nextInt();
        while (number < 10 || number > 20) {
            if (number > 20) {
                System.out.println("Plus petit !");
            } else if (number < 10) {
                System.out.println("Plus grand !");
            }
            System.out.println("Saisir un nombre compris entre 10 et 20 : ");
            number = scanner.nextInt();
        }
        System.out.println("Number : " + number);
        scanner.close();
    }

    public static void getNextNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisir un nombre : ");
        int number = scanner.nextInt();
        int tmp = number + 10;
        while (number < tmp) {
            System.out.println(++number);
        }
        scanner.close();
    }

    public static void getNextNumbersWithFor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisir un nombre : ");
        int number = scanner.nextInt();
        for (int i = 0; i < 10; i++) {
            System.out.println(++number);
        }
        scanner.close();
    }

    public static void getTable() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisir un nombre : ");
        int number = scanner.nextInt();
        System.out.println("Table de " + number);
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " x " + i + " = " + (number * i));
        }
        scanner.close();
    }

    public static void getIntegerSum() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisir un nombre : ");
        int number = scanner.nextInt();
        int sum = 0;
        for (int i = 1; i <= number; i++) {
            sum += i;
        }
        System.out.println("Sum = " + sum);
        scanner.close();
    }

    public static void getMax() {
        Scanner scanner = new Scanner(System.in);
        int max = 0;
        for (int i = 0; i < 20; i++) {
            System.out.println("Entrer le nombre numéro " + (i + 1) + " : ");
            int number = scanner.nextInt();
            if (number > max) {
                max = number;
            }
        }
        System.out.println("Le plus grand de ces nombres est : " + max);
        scanner.close();
    }

    public static void getMaxWithIndex() {
        Scanner scanner = new Scanner(System.in);
        int max = 0, index = 0;
        for (int i = 0; i < 20; i++) {
            System.out.println("Entrer le nombre numéro " + (i + 1) + " : ");
            int number = scanner.nextInt();
            if (number > max) {
                max = number;
                index = (i + 1);
            }
        }
        System.out.println("Le plus grand de ces nombres est : " + max);
        System.out.println("Il était en position : " + index);
        scanner.close();
    }

    public static void factorielle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisir un nombre : ");
        int number = scanner.nextInt();
        int factorielle = 1;
        if (number > 1) {
            for (int i = 2; i <= number; i++) {
                factorielle *= i;
            }
        }
        System.out.println(number + "! = " + factorielle);
        scanner.close();
    }

    public static void getMaxWithIndexAndEnd() {
        Scanner scanner = new Scanner(System.in);
        int number = 0, max = number, index = 1, maxIndex = -1;
        do {
            System.out.println("Entrer le nombre numéro " + index + " : ");
            number = scanner.nextInt();
            if (number >= max) {
                max = number;
                maxIndex = index;
            }
            index++;
        } while (number != -1);
        if (maxIndex == -1) {
            System.out.println("Vous devez saisir au minimun une valeur");
        } else {
            System.out.println("Le plus grand de ces nombres est : " + max);
            System.out.println("Il était en position : " + maxIndex);
        }
        scanner.close();
    }

    public static void achat() {
        Scanner scanner = new Scanner(System.in);
        int price, sum = 0, paye, rendu;
        do {
            System.out.println("Saisir un prix entier : ");
            price = scanner.nextInt();
            sum += price;
        } while (price != 0);
        System.out.println("Vous devez " + sum + "€");
        do {
            System.out.println("Saisir la somme payée : ");
            paye = scanner.nextInt();
            if (paye > sum) {
                rendu = Math.abs(sum - paye);
                System.out.println("Nous vous rendons " + rendu + "€");
                while (rendu != 0){
                    if (rendu % 10 >= 0){
                        System.out.println("10 €");
                        rendu -= 10;
                        paye -= 10;
                    }
                    else if (rendu % 5 >= 0){
                        System.out.println("5 €");
                        rendu -= 5;
                        paye -= 5;
                    }
                    else if (rendu % 1 >= 0){
                        System.out.println("1 €");
                        rendu -= 1;
                        paye -= 1;
                    }
                }
                paye = sum;
            }
        }while (paye != sum);
    }
}
