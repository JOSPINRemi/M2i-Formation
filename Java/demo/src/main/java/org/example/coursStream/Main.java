package org.example.coursStream;

public class Main {
    public static void main(String[] args) {
        Calculatrice calculatrice = new Calculatrice();
        double totalAddition = calculatrice.calcule(10, 30, (a,b) -> a + b);
        double totalSoustraction = calculatrice.calcule(10, 30, Calculatrice::soustraction);

        System.out.println("totalAddition : " + totalAddition);
        System.out.println("totalSoustraction : " + totalSoustraction);
    }
}
