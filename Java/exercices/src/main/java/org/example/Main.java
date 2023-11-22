package org.example;

import org.example.array.ArrayMatrix;
import org.example.chaineCaractere.chaineCaractere;
import org.example.function.Function;
import org.example.function.Recursivity;
import org.example.poo.tp_class.Chaise;
import org.example.poo.tp_class_heritage.*;
import org.example.poo.tp_heritage.Compte;
import org.example.poo.tp_heritage.CompteEpargne;
import org.example.poo.tp_heritage.ComptePayant;
import org.example.poo.tp_heritage.CompteSimple;

import java.util.Scanner;


public class Main {

    public static void displayChaise(Chaise chaise) {
        System.out.println("------------------------------------------ Affichage d'un nouvel objet ------------------------------------------");
        System.out.println("Je suis une Chaise, avec " + chaise.getNbPieds() + " pieds en " + chaise.getMatériaux() + " et de couleur " + chaise.getCouleur());
        System.out.println("-----------------------------------------------------------------------------------------------------------------");
    }

    public static void main(String[] args) {
//        Exercice 2
//        Exercice 2.3
//        Person.getFirstname();
//        Exercice 2.4
//        Price.getPrice();
//        Exercice 3
//        Exercice 3.1
//        Number.getPositiveNegative();
//        Exercice 3.2
//        TwoNumbers.getProductPositiveNegative();
//        Exercice 3.3
//        ThreeNames.getOrder();


//        Exercice 3.4
//        Number2.getPositiveNegativeOrNull();
//        Exercice 3.5
//        Age.getCategory();
//        Exercice 3.6
//        Divisible.isDivisibleBy();
//        Exercice 3.7
//        Photocopie.getPrice();

//        Exercice 5.1
//        Number5.numberBetweenOneAndThree();
//        Exercice 5.2
//        Number5.numberBetweenTenAndTwenty();
//        Exercice 5.3
//        Number5.getNextNumbers();
//        Exercice 5.4
//        Number5.getNextNumbersWithFor();
//        Exercice 5.5
//        Number5.getTable();
//        Exercice 5.6
//        Number5.getIntegerSum();
//        Exercice 5.7
//        Number5.getMax();
//        Exercice 5.7.2
//        Number5.getMaxWithIndex();
//        Exercice 5.8
//        Number5.factorielle();
//        Exercice 5.9
//        Number5.getMaxWithIndexAndEnd();
//        Exercice 5.10
//        TODO: Revoir le code de l'exo
//        Number5.achat();

//        chaineCaractere.exoComptageMot();
//        chaineCaractere.exoComptageOccurence();
//        chaineCaractere.anagramme("navire", "amerrir");
//        chaineCaractere.anagramme("avenir", "navire");
//        chaineCaractere.palindrome("test");
//        chaineCaractere.palindrome("kayak");
//        chaineCaractere.pyramide();

//        ArrayMatrix.exo8_1();
//        ArrayMatrix.exo8_2();
//        ArrayMatrix.exo8_3();

//        Function.exo1();
//        Function.exo2();
//        Function.exo3();
//        Function.exo4();

//        Recursivity.exoFactorielle();

        /*Chaise chaise = new Chaise(4, "Bleue", "Bois");
        displayChaise(chaise);
        Chaise chaise1 = new Chaise(4, "Blanche", "métal");
        displayChaise(chaise1);
        Chaise chaise2 = new Chaise(1, "Tansparente", "Pléxiglas");
        displayChaise(chaise2);*/

        /*Person person = new Person();
        person.sayHello();
        Student student = new Student();
        student.setAge(15);
        student.GoToClasses();
        student.sayHello();
        student.DisplayAge();
        Teacher teacher = new Teacher();
        teacher.setAge(40);
        teacher.sayHello();
        teacher.Explain();*/

        /*Apartment apartment = new Apartment();
        apartment.getDoor().setColor("bleue");
        Person2 person2 = new Person2("Thomas", apartment);
        person2.Display();*/

        /*Compte compte = new Compte(100);
        System.out.println(compte);
        compte.retrait(150);
        System.out.println(compte);
        compte.versement(1_000);
        System.out.println(compte);

        CompteSimple compteSimple = new CompteSimple(100, 10);
        System.out.println(compteSimple);
        compteSimple.retrait(150);
        System.out.println(compteSimple);
        compteSimple.versement(1_000);
        System.out.println(compteSimple);

        CompteEpargne compteEpargne = new CompteEpargne(100, 15);
        System.out.println(compteEpargne);
        compteEpargne.retrait(150);
        System.out.println(compteEpargne);
        compteEpargne.versement(1_000);
        System.out.println(compteEpargne);
        compteEpargne.calculInteret();
        System.out.println(compteEpargne);*/

        ComptePayant comptePayant = new ComptePayant(100);
        System.out.println(comptePayant);
        comptePayant.retrait(150);
        System.out.println(comptePayant);
        comptePayant.versement(1_000);
        System.out.println(comptePayant);
    }
}