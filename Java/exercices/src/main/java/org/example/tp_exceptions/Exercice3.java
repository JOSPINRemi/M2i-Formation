package org.example.tp_exceptions;

public class Exercice3 {
    public static void main(String[] args) {
        int[] tab = new int[5];
        for (int i = 0; i < tab.length; i++) {
            tab[i] = i;
        }
        int indice = 6;
        try {
            int out = tab[indice];
            System.out.println("L'élément à l'indice " + indice + " est " + out);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("L'indice est supérieur à la taille du tableau");
        }
    }
}
