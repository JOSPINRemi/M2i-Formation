package org.example.utils;

import org.example.controller.SalarieController;
import org.example.dao.SalarieDao;
import org.example.model.Salarie;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class SalarieTableModel extends JFrame {

    private JPanel tablePanel;

    public SalarieTableModel() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);

        tablePanel = new JPanel();
        tablePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        String[] columnsName = {"ID", "Nom", "Prénom", "Rôle"};

        SalarieController salarieController = new SalarieController();
        List<Salarie> salaries = salarieController.getAllSalaries();
        JTable table = new JTable(new DefaultTableModel(columnsName, 0));
        for (Salarie salarie : salaries) {
            ((DefaultTableModel) (table.getModel()))
                    .addRow(
                            new Object[]{
                                    salarie.getId(),
                                    salarie.getLastName(),
                                    salarie.getFirstName(),
                                    salarie.getRole()
                            }
                    );
        }
        JScrollPane scrollPane = new JScrollPane(table);
        tablePanel.add(scrollPane);
        this.add(tablePanel);
    }
}
