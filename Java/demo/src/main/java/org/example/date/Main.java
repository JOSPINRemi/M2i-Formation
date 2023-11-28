package org.example.date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        LocalDate dateDuJour = LocalDate.now();
        System.out.println("Date du jour : " + dateDuJour);

//        date choisie
        LocalDate dateChoisie = LocalDate.of(2026, 11, 28);
        System.out.println("Date choisie : " + dateChoisie);

//        Récupération délément de ma date
        int anneeEnCour = dateDuJour.getYear();
        int mois = dateDuJour.getMonthValue();
        int jour = dateDuJour.getDayOfMonth();
        System.out.println("Nous somme le " + jour + " jour du " + mois + " mois de l'année " + anneeEnCour);

//        Ajouter ou soustraire des jours
        LocalDate dateDansTroisJours = dateDuJour.plusDays(3);
        System.out.println("Dans 3 jours nous seront le " + dateDansTroisJours);
        System.out.println(dateDuJour.isBefore(dateDansTroisJours));
        System.out.println(dateDuJour.isAfter(dateDansTroisJours));
        System.out.println(dateDuJour.isEqual(dateDansTroisJours));

        LocalDate dateMoinsTroisJours = dateDuJour.minusDays(3);
        System.out.println("Il y 3 jours nous étions le " + dateMoinsTroisJours);
        System.out.println(dateDuJour.isBefore(dateMoinsTroisJours));
        System.out.println(dateDuJour.isAfter(dateMoinsTroisJours));
        System.out.println(dateDuJour.isEqual(dateMoinsTroisJours));

//        Formatage de la date
        String dateEnChaine = "2023-01-25";
        LocalDate dateSaisie = LocalDate.parse(dateEnChaine, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println("Date saisie : " + dateSaisie);
        System.out.println(dateDuJour.isBefore(dateSaisie));
    }
}
