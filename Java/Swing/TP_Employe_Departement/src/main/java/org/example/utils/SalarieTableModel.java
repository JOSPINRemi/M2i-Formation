package org.example.utils;

import org.example.controller.SalarieController;
import org.example.model.Salarie;
import org.example.view.SalarieUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class SalarieTableModel extends JFrame {

    private JPanel mainPanel;

    private JPanel tablePanel;

    private JPanel buttonsPanel;

    public SalarieTableModel() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 600);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

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
        mainPanel.add(tablePanel, BorderLayout.NORTH);

        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        JButton addBtn = new JButton("Ajouter");
        addBtn.addActionListener(e -> {
            SalarieUI dialog = new SalarieUI();
            dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
        });
        buttonsPanel.add(addBtn);

        JButton updateBtn = new JButton("Modifier");
        buttonsPanel.add(updateBtn);

        JButton deleteBtn = new JButton("Supprimer");
        deleteBtn.addActionListener(e -> {
            boolean deletedSalarie = salarieController.deleteSalarie(
                    (Integer) table.getModel()
                            .getValueAt(
                                    table
                                            .getSelectedRow()
                                    , 0
                            )
            );
//            System.out.println(deletedSalarie);
        });
        buttonsPanel.add(deleteBtn);

        JButton button = new JButton();
        button.setText("Departement");
        button.addActionListener(e -> {
            this.setTitle("Gestion des " + ((JButton) (e.getSource())).getText() + "s");
        });
        buttonsPanel.add(button, BorderLayout.CENTER);

        mainPanel.add(buttonsPanel);

        this.add(mainPanel);
    }
}
