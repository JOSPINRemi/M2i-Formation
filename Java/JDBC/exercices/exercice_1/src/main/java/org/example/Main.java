package org.example;

import org.example.HCI.CLI;
import org.example.utils.ConnectionUtils;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
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

        Connection connection = null;
        try {
            connection = ConnectionUtils.getMySQLConnection();
            Student.connection = connection;
            CLI.start();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (connection != null){
                try {
                    connection.close();
                }
                catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
}