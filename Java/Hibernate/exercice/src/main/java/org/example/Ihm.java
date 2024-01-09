package org.example;

import org.example.entities.Produit;
import org.example.services.ProduitService;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class Ihm {

    private ProduitService produitService;

    private Scanner scanner;

    public Ihm() {
        produitService = new ProduitService();
        scanner = new Scanner(System.in);
    }

    public void start() {
        produitService.begin();
        int choice;
        do {
            menu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    System.out.println("Bye");
                    break;
                case 1:
                    createProduct();
                    break;
                case 2:
                    showProducts();
                    break;
                case 3:
                    showProduct();
                    break;
                case 4:
                    updateProduct();
                    break;
                case 5:
                    deleteProduct();
                    break;
                    case 6:
                    showProductsBetweenDates();
                    break;
                default:
                    System.out.println("Choix invalide");
                    break;
            }
        } while (choice != 0);
        produitService.end();
    }

    private void menu() {
        System.out.println("1 - Créer un produit");
        System.out.println("2 - Afficher tous les produits");
        System.out.println("3 - Afficher un produit");
        System.out.println("4 - Modifier un produit");
        System.out.println("5 - Supprimer un produit");
        System.out.println("6 - Afficher une produit entre deux dates");
        System.out.println("0 - Quitter");
        System.out.print("Choix : ");
    }

    private void createProduct() {
        Produit produit = new Produit();
        System.out.print("Saisir la marque : ");
        produit.setMarque(scanner.nextLine());
        System.out.print("Saisir la référence : ");
        produit.setReference(scanner.nextLine());
        System.out.print("Saisir la date d'achat (yyyy-MM-dd : ");
        produit.setDateAchat(Date.valueOf(scanner.nextLine()));
        System.out.print("Saisir le prix : ");
        produit.setPrix(scanner.nextDouble());
        scanner.nextLine();
        if (produitService.create(produit)) {
            System.out.println("Produit ajouté\nDétails du produit : " + produit);
        }
    }

    private void showProducts() {
        List<Produit> produits = produitService.findAll();
        if (produits.isEmpty()){
            System.out.println("Aucun produit enregistré");
        }
        else {
            System.out.println("Produits :");
            produits.forEach(System.out::println);
        }
    }

    private void showProduct() {
        produitService.findAll().forEach(System.out::println);
        System.out.print("Saisir l'id du produit recherché : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Produit produit = produitService.findById(id);
        if (produit == null) {
            System.out.println("Le produit avec l'id " + id + " n'existe pas");
        } else {
            System.out.println("Produit recherché : " + produit);
        }
    }

    private void updateProduct() {
        produitService.findAll().forEach(System.out::println);
        System.out.print("Saisir l'id du produit à modifier : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Produit produit = produitService.findById(id);
        if (produit == null) {
            System.out.println("Le produit avec l'id " + id + " n'existe pas");
        } else {
            System.out.println("Produit à modifier : " + produit);
            System.out.print("Saisir la nouvelle marque : ");
            produit.setMarque(scanner.nextLine());
            System.out.print("Saisir la nouvelle référence : ");
            produit.setReference(scanner.nextLine());
            System.out.print("Saisir la nouvelle date d'achat (yyyy-MM-dd : ");
            produit.setDateAchat(Date.valueOf(scanner.nextLine()));
            System.out.print("Saisir le nouveau prix : ");
            produit.setPrix(scanner.nextDouble());
            scanner.nextLine();
            if (produitService.update(produit)) {
                System.out.println("Produit modifié\nDétails du produit : " + produit);
            }
        }
    }

    private void deleteProduct() {
        produitService.findAll().forEach(System.out::println);
        System.out.print("Saisir l'id du produit à supprimer : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Produit produit = produitService.findById(id);
        if (produit == null) {
            System.out.println("Le produit avec l'id " + id + " n'existe pas");
        } else {
            if (produitService.delete(produit)) {
                System.out.println("Produit supprimé");
            }
        }
    }

    private void showProductsBetweenDates(){
        System.out.print("Saisir la date de début : ");
        Date dateDebut = Date.valueOf(scanner.nextLine());
        System.out.print("Saisir la date de fin : ");
        Date dateFin = Date.valueOf(scanner.nextLine());
        List<Produit> produits = null;
        try {
            produits = produitService.filterByDate(dateDebut, dateFin);
            if (produits.isEmpty()) {
                System.out.println("Aucun produit entre ces dates");
            } else {
                System.out.println("Produits entre le " + dateDebut + " et le " + dateFin);
                produits.forEach(System.out::println);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
