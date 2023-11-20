package org.example.chaineCaractere;

import java.util.Arrays;
import java.util.Scanner;

public class chaineCaractere {
    static String sentence = "Bonjour tout le monde";
    static String word = "Bonjour";
    static char letter = 'o';
    static String anagramme = "kayak";

    public static void exoComptageMot() {
        int counter = sentence.trim().split(" ").length;
        System.out.println("Il y a " + counter + " mots dans la phrase : \"" + sentence + "\"");
    }

    public static void exoComptageOccurence() {
        int occurence = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                occurence++;
            }
        }
        System.out.println("Il y a " + occurence + " occurence(s) de la lettre " + letter + " dans le mot " + word);
    }

    public static void anagramme(String w1, String w2) {
        if (w1.length() == w2.length()) {
            System.out.println(w1 + " est l'anagramme de " + w2);
        } else {
            System.out.println(w1 + " n' est pas l'anagramme de " + w2);
        }
    }

    public static void palindrome(String w) {
        boolean isPalindrome = false;
        for (int i = 0, j = w.length() - 1; i < j; i++, j--) {
            if (w.charAt(i) != w.charAt(j)) {
                isPalindrome = false;
                break;
            } else {
                isPalindrome = true;
            }
        }
        if (isPalindrome) {
            System.out.println(w + " est un palindrome");
        } else {
            System.out.println(w + " n'est pas un palindrome");
        }
    }

    public static void pyramide() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bonjour,\nVeuillez saisir la hauteur de la pyramide :");
//        int h = scanner.nextInt();
    }
}
