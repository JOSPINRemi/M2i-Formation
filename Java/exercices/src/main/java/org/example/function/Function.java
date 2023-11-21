package org.example.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Function {

    static Scanner scanner = new Scanner(System.in);

    public static void exo1() {
        System.out.println("Saisir des entiers séparés par un espace :");
        String numbers = scanner.nextLine();
        String[] tab = numbers.split(" ");
        int[] intTab = new int[tab.length];
        for (int i = 0; i < tab.length; i++) {
            intTab[i] = Integer.parseInt(tab[i]);
        }
        System.out.println("La valeur maximale est " + findMaxIntInArray(intTab));
    }

    public static int findMaxIntInArray(int[] intArray) {
        int max = intArray[0];
        for (int el : intArray) {
            if (el > max) {
                max = el;
            }
        }
        return max;
    }

    public static void exo2() {
        System.out.println("Saisir la hauteur du rectangle :");
        int h = scanner.nextInt();
        System.out.println("Saisir la largeur du rectangle :");
        int w = scanner.nextInt();

        drawRectangle(h, w);
    }

    public static void drawRectangle(int hauteur, int largeur) {
        for (int i = 0; i < hauteur; i++) {
            for (int j = 0; j < largeur; j++) {
                if ((i > 0 && i < hauteur - 1) && (j > 0 && j < largeur - 1)) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.print("\n");
        }
    }

    public static void exo3() {
        System.out.println("Saisir du texte :");
        String t = scanner.nextLine().trim();
        System.out.println("Il y a " + getWordsAmount(t) + " mots dans \"" + t + "\"");
    }

    public static int getWordsAmount(String texte) {
        return texte.split(" ").length;
    }

    public static void exo4() {
        System.out.println("Saisir des mots aléatoires séparés par un espace :");
        String words = scanner.nextLine().trim();

        System.out.println("Saisir la longueur minimale de la chaîne");
        int l = scanner.nextInt();

        String[] tab = words.split(" ");

        System.out.println("Voici les mots saisis dont la longueur est supérieur ou égale à " + l + " : " + Arrays.toString(filterWordsByLength(l, tab)));
    }

    public static String[] filterWordsByLength(int minLength, String[] mots){
        List<String> result = new ArrayList<>();
        for (int i = 0; i < mots.length; i++) {
            if (mots[i].length() >= minLength){
                result.add(mots[i]);
            }
        }
        return result.toArray(new String[0]);
    }
}
