package utils;

import dao.IAccountDAO;
import dao.IBranchDAO;
import dao.ICustomerDAO;
import dao.impl.AccountDAOImpl;
import dao.impl.BranchDAOImpl;
import dao.impl.CustomerDAOImpl;
import entity.Account;
import entity.Branch;
import entity.Customer;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IHM {
    private static EntityManagerFactory entityManagerFactory;
    private static IAccountDAO accountDAO;
    private static IBranchDAO branchDAO;
    private static ICustomerDAO customerDAO;
    private static Scanner scanner;

    public IHM() {
        entityManagerFactory = Persistence.createEntityManagerFactory("banque_bdd");

        accountDAO = new AccountDAOImpl(entityManagerFactory);
        branchDAO = new BranchDAOImpl(entityManagerFactory);
        customerDAO = new CustomerDAOImpl(entityManagerFactory);

        scanner = new Scanner(System.in);
    }

    public void start() {
        int choice;
        do {
            menu();

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    System.out.print("Bye");
                    entityManagerFactory.close();
                    break;
                case 1:
                    createBranch();
                    break;
                case 2:
                    createCustomer();
                    break;
                case 3:
                    createAccount();
                    break;
                default:
                    System.out.println("Choix invalide");
                    break;
            }
        } while (choice != 0);
    }

    private void menu() {
        System.out.println("#### Banque ####");
        System.out.println("1. Créer une agence");
        System.out.println("2. Créer un client");
        System.out.println("3. Créer un compte");
        System.out.println("0. Quitter");
        System.out.print("Choix : ");
    }

    private void createBranch() {
        Branch branch = new Branch();
        System.out.print("Saisir l'adresse de l'agence : ");
        branch.setAddress(scanner.nextLine());
        branchDAO.save(branch);
        System.out.println("Agence créée");
    }

    private void createCustomer() {
        if (branchDAO.get().isEmpty()) {
            System.out.println("Veuillez préalablement créer une banque avant la création d'un client");
        } else {
            System.out.println(branchDAO.get());
            System.out.print("Saisir l'id de l'agence : ");
            long branchId = scanner.nextLong();
            scanner.nextLine();

            Branch branch = branchDAO.get(branchId);
            if (branch == null) {
                System.out.println("L'agence avec l'id " + branchId + " n'existe pas");
            } else {
                Customer customer = new Customer();
                System.out.print("Saisir le nom du client : ");
                customer.setLastName(scanner.nextLine());
                System.out.print("Saisir le prénom du client : ");
                customer.setFirstName(scanner.nextLine());
                System.out.print("Saisir la date de naissance du client : ");
                customer.setBirthDate(Date.valueOf(scanner.nextLine()));
                customerDAO.save(customer);
                System.out.println("Personne créée");
            }
        }

    }

    private void createAccount() {
        if (branchDAO.get().isEmpty()) {
            System.out.println("Veuillez préalablement créer une banque avant la création d'un compte");
        } else {
            if (customerDAO.get().isEmpty()) {
                System.out.println("Veuillez préalablement créer un client avant la création d'un compte");
            } else {
                System.out.println(branchDAO.get());
                System.out.print("Saisir l'id de l'agence : ");
                long branchId = scanner.nextLong();
                scanner.nextLine();
                Branch branch = branchDAO.get(branchId);
                if (branch == null){
                    System.out.println("L'agence avec l'id " + branchId + " n'existe pas");
                }
                else {
                    System.out.println(customerDAO.get());
                    System.out.print("Saisir l'id du client : ");
                    long customerId = scanner.nextInt();
                    scanner.nextLine();
                    Customer customer = customerDAO.get(customerId);
                    if (customer == null) {
                        System.out.println("Le client avec l'id " + customerId + " n'existe pas");
                    } else {
                        Account account = new Account();
                        account.setBranch(branch);
                        List<Customer> customers = new ArrayList<>();
                        customers.add(customer);
                        account.setCustomers(customers);
                        System.out.print("Saisir le libellé du compte : ");
                        account.setLabel(scanner.nextLine());
                        System.out.print("Saisir l'IBAN du compte : ");
                        account.setIBAN(scanner.nextLine());
                        System.out.print("Saisir le balance : ");
                        account.setBalance(scanner.nextDouble());
                        scanner.nextLine();
                        accountDAO.save(account);
                        customer.addAccount(account);
                        customerDAO.update(customer);
                        System.out.println("Compte créé");
                    }
                }
            }
        }
    }
}
