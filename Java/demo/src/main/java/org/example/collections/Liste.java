package org.example.collections;

import java.util.ArrayList;

public class Liste {
    public static void main(String[] args) {
//        Déclaration de l'ArrayList
        ArrayList<String> prenoms = new ArrayList<String>();
//        Ajout de valeurs dans l'ArrayList
        prenoms.add("toto");
        prenoms.add("titi");
        prenoms.add("tutu");
//        prenoms.add(42); // erreur
//        Récupération de valeur dans l'ArrayList
        System.out.println(prenoms.get(0));
        System.out.println(prenoms.get(1));
        System.out.println(prenoms.get(2));
//        Modification de valeur dans l'ArrayList
        prenoms.set(1, "Nassim");
        System.out.println(prenoms.get(1));
//        Suppression de valeur dans l'ArrayList
//        Récupération de la taille de l'ArrayList
        System.out.println(prenoms.size());
        prenoms.remove(0);
        System.out.println(prenoms.size());
//        Parcours avec la boucle for
        for (int cpt = 0; cpt < prenoms.size(); cpt++) {
            System.out.println(prenoms.get(cpt));
        }
//        Parcours avec la boucle foreach
        for (String prenom: prenoms) {
            System.out.println(prenom);
        }
    }
}
