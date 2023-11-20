package org.example.string;

import java.util.Arrays;

public class ChaineCharactere {
    public static void getMethodString() {
        System.out.println("--- Les chaîtnes de charactères ---");

        String s = " hello ";

        System.out.println("s.length() " + s.length());
        System.out.println("s.contains(\"he\") : " + s.contains("he"));
        System.out.println("s.isEmpty() : " + s.isEmpty());
        System.out.println("s.toUpperCase() " + s.toUpperCase());
        System.out.println("s.startsWith(\"h\") " + s.startsWith("h"));
        System.out.println("s.endsWith(\" \") " + s.endsWith(""));
        System.out.println("s.replace(\"ll\", \"LL\")" + s.replace("ll", "LL"));
        System.out.println("s.trim() " + s.trim());
        System.out.println("s.substring(0,3) " + s.substring(0,3));
        System.out.println("s.charAt(1) " + s.charAt(1));
        System.out.println("Arrays.toString(s.split(\"e\")) " + Arrays.toString(s.split("e")));
        System.out.println(s);
    }

    public static void getComparaisonString() {
        System.out.println("--- Comparaison String ---");

        String s = " hello ";
        String s2 = " hello ";

        System.out.println("s == s2 " + (s == s2));

        String s3 = new String(" hello ");

        System.out.println("s == s3 " + (s == s3));

        System.out.println("s.equals(s3) " + s.equals(s3));

        String firstname = "Alain";
        String firstname1 = "alain";

        System.out.println("firstname.equals(firstname1) " + firstname.equals(firstname1));
        System.out.println("firstname.equalsIgnoreCase(firstname1) " + firstname.equalsIgnoreCase(firstname1));
    }

    public static void main() {
        System.out.println("--- Formattage String ---");

        String firstname = "Alain";
        String sentence = "Salut, cher %s ! Good %s !";
        String morning = "morning";
        String evening = "evening";
        String afternoon = "afternoon";

        String newSentence = String.format(sentence, firstname, morning);
        System.out.println(newSentence);

        System.out.printf("Vous allez gagner %d€ à l'euro-millions dans %d jours\n", 1_000_000, 10);

        String productName = "Chocolat";
        double price = 2.99;
        int quantity = 10;
        System.out.printf("Total pour %d unités de %s : %.2f euros", quantity, productName, price * quantity);
    }
}
