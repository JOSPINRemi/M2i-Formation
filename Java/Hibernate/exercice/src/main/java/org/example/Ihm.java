package org.example;

import org.example.entities.Commentaire;
import org.example.entities.Image;
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
                    showProductsPriceGT();
                    break;
                case 7:
                    showProductsBetweenDates();
                    break;
                case 8:
                    showProductsStockLT();
                    break;
                case 9:
                    showProductsByBrand();
                    break;
                case 10:
                    deleteProductsByBrand();
                    break;
                case 11:
                    addImageToProduct();
                    break;
                case 12:
                    addCommentToProduct();
                    break;
                case 13:
                    showProductsNoteGE();
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
        System.out.println("6 - Afficher les produits dont le prix est supérieur");
        System.out.println("7 - Afficher les produits commandés entre deux dates");
        System.out.println("8 - Afficher les produits dont le stock est inférieur");
        System.out.println("9 - Afficher les produits d'une marque");
        System.out.println("10 - Supprimer les produits d'une marque");
        System.out.println("11 - Ajouter une image à un produit");
        System.out.println("12 - Ajouter un commentaire à un produit");
        System.out.println("13 - Afficher les produits avec une note supérieure ou égale");
        System.out.println("0 - Quitter");
        System.out.print("Choix : ");
    }

    private void createProduct() {
        Produit produit = new Produit();
        System.out.print("Saisir la marque : ");
        produit.setMarque(scanner.nextLine());
        System.out.print("Saisir la référence : ");
        produit.setReference(scanner.nextLine());
        System.out.print("Saisir la date d'achat (yyyy-MM-dd) : ");
        produit.setDateAchat(Date.valueOf(scanner.nextLine()));
        System.out.print("Saisir le prix : ");
        produit.setPrix(scanner.nextDouble());
        scanner.nextLine();
        System.out.print("Saisir le stock : ");
        produit.setStock(scanner.nextInt());
        scanner.nextLine();
        if (produitService.create(produit)) {
            System.out.println("Produit ajouté\nDétails du produit : " + produit);
        }
    }

    private void showProducts() {
        List<Produit> produits = produitService.findAll();
        if (produits.isEmpty()) {
            System.out.println("Aucun produit enregistré");
        } else {
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
            System.out.print("Saisir la nouvelle date d'achat (yyyy-MM-dd) : ");
            produit.setDateAchat(Date.valueOf(scanner.nextLine()));
            System.out.print("Saisir le nouveau prix : ");
            produit.setPrix(scanner.nextDouble());
            scanner.nextLine();
            System.out.print("Saisir le nouveau stock : ");
            produit.setStock(scanner.nextInt());
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

    private void showProductsPriceGT() {
        System.out.print("Saisir un prix : ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Produits dont le prix est supérieur à " + price + " :");
        try {
            produitService.filterByPrice(price).forEach(System.out::println);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void showProductsBetweenDates() {
        System.out.print("Saisir la date de début : ");
        Date startDate = Date.valueOf(scanner.nextLine());
        System.out.print("Saisir la date de fin : ");
        Date endDate = Date.valueOf(scanner.nextLine());
        try {
            List<Produit> produits = produitService.filterByDate(startDate, endDate);
            if (produits.isEmpty()) {
                System.out.println("Aucun produit entre ces dates");
            } else {
                System.out.println("Produits entre le " + startDate + " et le " + endDate);
                produits.forEach(System.out::println);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void showProductsStockLT() {
        System.out.print("Saisir le stock maximum : ");
        int stock = scanner.nextInt();
        scanner.nextLine();
        try {
            List<Produit> produits = produitService.filterByStock(stock);
            if (produits.isEmpty()) {
                System.out.println("Aucun produit dont le stock est inférieur à " + stock);
            } else {
                System.out.println("Produits dont le stock est inférieur à " + stock + " :");
                produits.forEach(produit -> System.out.println("Id:" + produit.getId() + " Ref:" + produit.getReference()));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void showProductsByBrand() {
        System.out.print("Saisir la marque : ");
        String brand = scanner.nextLine();
        try {
            List<Produit> produits = produitService.filterByBrand(brand);
            if (produits.isEmpty()) {
                System.out.println("Aucun produit dont la marque est " + brand);
            } else {
                System.out.println("Produits dont la marque est " + brand + " :");
                produits.forEach(System.out::println);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteProductsByBrand() {
        System.out.print("Saisir la marque : ");
        String brand = scanner.nextLine();
        try {
            List<Produit> produits = produitService.filterByBrand(brand);
            if (produits.isEmpty()) {
                System.out.println("Aucun produit dont la marque est " + brand);
            } else {
                produits.forEach(produit -> produitService.delete(produit));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void addImageToProduct() {
        produitService.findAll().forEach(System.out::println);
        System.out.print("Saisir l'id du produit : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Produit produit = produitService.findById(id);
        if (produit == null) {
            System.out.println("Le produit avec l'id " + id + " n'existe pas");
        } else {
            Image image = new Image();
            System.out.print("Saisir l'url de l'image : ");
            image.setUrl(scanner.nextLine());
            produit.getImages().add(image);
            produitService.update(produit);
        }
    }

    private void addCommentToProduct() {
        produitService.findAll().forEach(System.out::println);
        System.out.print("Saisir l'id du produit : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Produit produit = produitService.findById(id);
        if (produit == null) {
            System.out.println("Le produit avec l'id " + id + " n'existe pas");
        } else {
            System.out.println("Création du commentaire :");
            Commentaire commentaire = new Commentaire();
            System.out.print("Saisir le contenu : ");
            commentaire.setContenu(scanner.nextLine());
            System.out.print("Saisir la date (yyyy-MM-dd) : ");
            commentaire.setDate(Date.valueOf(scanner.nextLine()));
            System.out.print("Saisir la note du produit (entre 0 et 5) : ");
            try {
                commentaire.setNote(scanner.nextDouble());
                scanner.nextLine();
                produit.getCommentaires().add(commentaire);
                produitService.update(produit);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void showProductsNoteGE() {
        System.out.print("Saisir le note minimum : ");
        double note = scanner.nextDouble();
        scanner.nextLine();
        try {
            List<Produit> produits = produitService.filterByNote(note);
            if (produits.isEmpty()) {
                System.out.println("Aucun produit dont la note est supérieure ou égale à " + note);
            } else {
                System.out.println("Produits dont la note est supérieure ou égale à " + note + " :");
                produits.forEach(System.out::println);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
