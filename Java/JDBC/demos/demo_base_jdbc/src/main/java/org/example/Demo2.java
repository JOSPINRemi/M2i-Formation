package org.example;

import org.example.utils.ConnectionUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
//        Test de connexion
        /*try (Connection connection = ConnectionUtils.getMySQLConnection()) {
            if (connection != null) {
                System.out.println("Connexion ok");
            } else {
                System.out.println("Connexion nok !!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/

        Scanner scanner = new Scanner(System.in);
        Connection connection = null;
        try {
            connection = ConnectionUtils.getMySQLConnection();
            System.out.println("Connexion ok");

            /*System.out.println("Merci de saisir le prénom :");
            String firstName = scanner.nextLine();
            System.out.println("Merci de saisir le nom :");
            String lastName = scanner.nextLine();*/

//            Un requête pour l'insertion de données
//            String query = "INSERT INTO person(first_name, last_name) VALUES ('" + firstName + "', '" + lastName+ "')";

//            première solution => exécution d'une requête sans retour
            /*Statement statement = connection.createStatement();
            boolean res = statement.execute(query);
            System.out.println("Requête exécutée");
            System.out.println(res);*/

//            Deuxième solution => avec une requête préparée
//            Version sans récupération de l'id
            /*String query = "INSERT INTO person(first_name, last_name) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.execute(); // retour boolean

            int nbRows = preparedStatement.executeUpdate(); // retour int
            System.out.println("Nombre de ligne : " + nbRows);*/

//            Version avec récupération de l'id
            /*String query = "INSERT INTO person(first_name, last_name) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            int nbRows = preparedStatement.executeUpdate(); // retour int
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            System.out.println("Nombre de ligne : " + nbRows);
            if (resultSet.next()){
                System.out.println(resultSet.getInt(1));
            }*/

//            Avec une requête de lecture
            String query = "SELECT * FROM person";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.println(
                        resultSet.getInt("id") + ") " +
                                resultSet.getString("first_name") + " " +
                                resultSet.getString("last_name")
                );
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
//            Fermer la connexion à la BDD
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("Connexion fermée");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
