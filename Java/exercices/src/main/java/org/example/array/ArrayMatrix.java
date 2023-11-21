package org.example.array;

import java.util.Scanner;

public class ArrayMatrix {

    public static void exo8_1() {
        int[][] m = {{45, 23, 34, 56, 30}, {67, 75, 21, 52, 59}, {89, 34, 19, 19, 15}, {1, 78, 90, 48, 42}};
        int max = m[0][0];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] > max) {
                    max = m[i][j];
                }
            }
        }
        System.out.println("La valeur maximale de la matrice est : " + max);
    }

    public static void exo8_2() {
        int[][] m2 = new int[4][5];
        int value = 1;
        float sum = 0;
        float product = 1;
        for (int i = 0; i < m2.length; i++) {
            for (int j = 0; j < m2[i].length; j++) {
                m2[i][j] = value++;
                sum += m2[i][j];
                product *= m2[i][j];
            }
        }

        /*for (int i = 0; i < m2.length; i++) {
            for (int j = 0; j < m2[i].length; j++) {
                System.out.println("m2[" + i + "][" + j + "] = " + m2[i][j]);
            }
        }*/

        System.out.println("Somme de cette matrice = " + sum);
        System.out.println("Produit de cette matrice = " + product);
        System.out.println("Moyenne de cette matrice = " + sum / (m2.length * m2[0].length));
    }

    public static void exo8_3() {
        Scanner scanner = new Scanner(System.in);
//        String[][] m3 = new String[4][4];

        System.out.println("Combien voulez-vous de vendeur ?");
        int nbVendeur = scanner.nextInt();

        System.out.println("Combien voulez-vous de marque ?");
        int nbMarque = scanner.nextInt();
        scanner.nextLine();

        String[][] m3 = new String[nbVendeur + 1][nbMarque + 1];

        for (int i = 1; i < m3.length; i++) {
            System.out.println("Saisir le nom du vendeur :");
            String vendeur = scanner.nextLine();
            m3[i][0] = vendeur;
        }
        System.out.println();
        for (int i = 1; i < m3[0].length; i++) {
            System.out.println("Saisir la marque du véhicule :");
            String marque = scanner.nextLine();
            m3[0][i] = marque;
        }
        System.out.println();

        for (int i = 1; i < m3.length; i++) {
            for (int j = 1; j < m3[0].length; j++) {
                System.out.println("Combien de " + m3[0][j] + " à vendu le vendeur " + m3[i][0]);
                m3[i][j] = scanner.nextLine();
            }
            System.out.println();
        }

        System.out.println("\nRésumé : ");
        for (int i = 1; i < m3.length; i++) {
            for (int j = 1; j < m3[i].length; j++) {
                System.out.println("Le vendeur " + m3[i][0] + " a vendu " + m3[i][j] + " " + m3[0][j]);
            }
        }

        System.out.println("\nTableau récapitulatif : ");
        for (int i = 0; i < m3.length; i++) {
            System.out.printf("[");
            for (int j = 0; j < m3[0].length; j++) {
                if (i == 0 && j == 0){
                    System.out.printf("%s", "");
                }
                else {
                System.out.printf("%s", m3[i][j]);
                }
                if (j < m3.length - 1) {
                    System.out.printf("\t");
                }
            }
            System.out.printf("]\n");
        }
    }
}
