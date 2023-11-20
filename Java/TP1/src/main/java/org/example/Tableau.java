package org.example;

import java.util.Arrays;

public class Tableau {
    public static void exo5_1(int[] tab, int val) {
        int count = 0;
        for (int el : tab) {
            if (el == val) {
                count++;
            }
        }
        System.out.println("La valeur " + val + " est présente " + count + " fois dans le tableau");
    }

    public static void exo5_2(int[] tab) {
        boolean sorted = true;
        int previous = tab[0];
        for (int el : tab) {
            if (previous > el) {
                sorted = false;
                break;
            } else {
                previous = el;
            }
        }
        if (sorted) {
            System.out.println("Le tableau est trié par ordre croissant");
        } else {
            System.out.println("Le tableau n'est pas trié par ordre croissant");
        }
    }

    public static void exo5_3(int[] tab) {
        int previous = tab[0];
        int ecart = 0;
        for (int el : tab) {
            if (Math.abs(previous - el) > ecart) {
                ecart = Math.abs(previous - el);
            }
            previous = el;
        }
        System.out.println("Le plus grand écart dans le tableau est " + ecart);
    }

    public static void exo5_4(int[] tab) {
        int previous = tab[tab.length - 1];
        int tmp;
        for (int i = 0; i < tab.length; i++) {
            tmp = tab[i];
            tab[i] = previous;
            previous = tmp;
        }

        System.out.println(Arrays.toString(tab));
    }


    public static void exo5_5(int[] tab) {
        int tmp;
        for (int i = 0, j = tab.length - 1; i < j; i++, j--) {
            tmp = tab[i];
            tab[i] = tab[j];
            tab[j] = tmp;
        }

        System.out.println("Voici le tableau inversé :\n" + Arrays.toString(tab));
    }

    public static void exo5_6(int[] tab) {
        int min;
        int tmp;
        for (int i = 0; i < tab.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < tab.length; j++) {
                if (tab[j] < tab[min]) {
                    min = j;
                }
            }
            if (min != i) {
                tmp = tab[i];
                tab[i] = tab[min];
                tab[min] = tmp;
            }
        }

        System.out.println("Voici le tableau trié par sélection :\n" + Arrays.toString(tab));
    }

    public static void exo5_7(int[] tab) {
        int tmp;
        for (int i = 0; i < tab.length - 1; i++) {
            for (int j = 0; j < tab.length - 1 - i; j++) {
                if (tab[j] > tab[j + 1]) {
                    tmp = tab[j];
                    tab[j] = tab[j + 1];
                    tab[j + 1] = tmp;
                }
            }
        }

        System.out.println("Voici le tableau trié par tri à bulle :\n" + Arrays.toString(tab));
    }

    public static void exo5_8(int[] t1, int[] t2) {
        if (t1.length != t2.length) {
            System.out.println("Les tableaux ne sont pas de la même longueur");
        } else {
            int[] t = new int[t1.length];
            for (int i = 0; i < t1.length; i++) {
                t[i] = t1[i] + t2[i];
            }
            System.out.println(Arrays.toString(t1) + "\n+\n" + Arrays.toString(t2) + "\n=\n" + Arrays.toString(t));
        }
    }
}
