package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
//        Connexion à ma BDD demo_jdbc MySQL
        String url = "jdbc:mysql://localhost:3306/demo_jdbc";

        try (Connection connection = DriverManager.getConnection(url, "root", "root")) {
            if (connection != null) {
                System.out.println("Connexion ok");
            } else {
                System.out.println("Connexion nok !!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

//        Meilleur pratique, mettre la connexion dans une classe à part
    }
}