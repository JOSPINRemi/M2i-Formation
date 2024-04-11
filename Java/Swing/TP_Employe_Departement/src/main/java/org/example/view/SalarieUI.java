package org.example.view;

import org.example.controller.DepartementController;
import org.example.controller.SalarieController;
import org.example.model.Departement;
import org.example.model.Role;
import org.example.model.Salarie;

import javax.swing.*;
import java.util.Collections;

public class SalarieUI extends JDialog {

    private JPanel panel;

    private DepartementController departementController;

    private SalarieController salarieController;

    public SalarieUI() {
        this.setSize(300, 200);
        this.setTitle("Ajouter un salarie");
        this.setLocationRelativeTo(null);

        departementController = new DepartementController();
        salarieController = new SalarieController();

        panel = new JPanel();

        JLabel lastNameL = new JLabel("Nom:");
        panel.add(lastNameL);
        JTextField lastNameTF = new JTextField(10);
        panel.add(lastNameTF);

        JLabel firstNameL = new JLabel("Prénom:");
        panel.add(firstNameL);
        JTextField firstNameTF = new JTextField(10);
        panel.add(firstNameTF);

        JLabel roleL = new JLabel("Rôle:");
        panel.add(roleL);
        ButtonGroup roleGroup = new ButtonGroup();
        for (Role role : Role.values()) {
            JRadioButton radioButton = new JRadioButton(role.name());
            roleGroup.add(radioButton);
            panel.add(radioButton);
        }

        JLabel departementL = new JLabel("Départment:");
        panel.add(departementL);
        JComboBox<String> comboBox = new JComboBox<>();
        for (Departement departement : departementController.getAllDepartements()) {
            comboBox.addItem(departement.getName());
        }
        panel.add(comboBox);

        JButton addBtn = new JButton("Ajouter");
        addBtn.addActionListener(e -> {
            Salarie salarie = new Salarie();
            salarie.setLastName(lastNameTF.getText());
            salarie.setFirstName(firstNameTF.getText());
            for (AbstractButton radioButton : Collections.list((roleGroup.getElements()))) {
                if (radioButton.isSelected()) {
                    salarie.setRole(Role.valueOf(radioButton.getText()));
                }
            }
            if (salarieController.addSalarie(salarie)) {
                JOptionPane.showConfirmDialog(null, "Salarie ajouté avec succès");
            }
            dispose();
        });
        panel.add(addBtn);

        JButton cancelBtn = new JButton("Annuler");
        cancelBtn.addActionListener(e -> dispose());
        panel.add(cancelBtn);

        this.add(panel);
    }

    public static void main(String[] args) {
        SalarieUI dialog = new SalarieUI();
        dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
    }
}
