package org.example.gestion_de_bibliotheque;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Book paperBook = new PaperBook("Les Aventures d'Alice au pays des merveilles", "Lewis Carroll", 196, "Macmillan and Co");
        Book eBook = new eBook("La Symphonie des monstres", "Marc Levy", "ePub", 10_000);
        Person person = new Person("JOSPIN", "Rémi");

        if (library.getBooks().isEmpty()) {
            System.out.println("Nous sommes désolé aucun livre n'est disponible pour le moment");
        }


        library.addBook(paperBook);
        library.addBook(eBook);
        System.out.println("Voici la librairie");
        for (Book book : library.getBooks()) {
            System.out.println(book);
        }

        System.out.println("Recherche de livre par titre");
        for (Book book : library.findBooksByTitle("La Symphonie des monstres")) {
            System.out.println(book);
        }

        System.out.println("Recherche de livre par auteur");
        for (Book book : library.findBooksByAuthor("Lewis Carroll")) {
            System.out.println(book);
        }

        System.out.println("Emprunt d'un livre");
        if (library.borrowBook("1", person)) {
            for (Loan loan : library.getLoans()) {
                System.out.println(loan);
            }
        } else {
            System.out.println("Vous ne pouvez pas emprunter un livre déjà emprunté");
        }

        System.out.println("Emprunt d'un livre");
        if (library.borrowBook("1", person)) {
            for (Loan loan : library.getLoans()) {
                System.out.println(loan);
            }
        } else {
            System.out.println("Vous ne pouvez pas emprunter un livre déjà emprunté");
        }

        System.out.println("Remise d'un livre");
        library.returnBorrowedBook("1");

        System.out.println("Emprunt d'un livre");
        if (library.borrowBook("1", person)) {
            for (Loan loan : library.getLoans()) {
                System.out.println(loan);
            }
        } else {
            System.out.println("Vous ne pouvez pas emprunter un livre déjà emprunté");
        }

        System.out.println("Suppression d'un livre");
        if (library.removeBook("1")) {
            System.out.println("Le livre a été correctement supprimé");
        }

        for (Book book : library.getBooks()) {
            System.out.println(book);
        }
    }
}
