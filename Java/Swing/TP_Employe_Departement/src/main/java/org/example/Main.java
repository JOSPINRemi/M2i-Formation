package org.example;

import org.example.utils.SalarieTableModel;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    SalarieTableModel salarieTableModel = new SalarieTableModel();
                    salarieTableModel.setTitle("Gestion des salariés");
                    salarieTableModel.setLocationRelativeTo(null);
                    salarieTableModel.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}