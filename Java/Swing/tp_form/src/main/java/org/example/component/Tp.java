package org.example.component;

import lombok.Data;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Enumeration;

@Data
public class Tp extends JPanel {

    private JPanel form;
    private JLabel nameLabel;
    private TextField nameTextField;
    private JLabel emailLabel;
    private TextField emailTextField;
    private JLabel genderLabel;
    private ButtonGroup genderButtonGroup;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private String genderSelected;
    private JButton addButton;

    private JPanel personTable;
    JScrollPane scrollPane;
    private JTable table;

    public Tp() {
        createForm();
        add(form);
        add(new JSeparator(JSeparator.HORIZONTAL));
        createTable();
        add(personTable);
    }

    private void createForm() {
        form = new JPanel();

        nameLabel = new JLabel("Nom:");
        add(nameLabel);
        nameTextField = new TextField();
        add(nameTextField);

        emailLabel = new JLabel("Email:");
        add(emailLabel);
        emailTextField = new TextField();
        add(emailTextField);

        genderLabel = new JLabel("Genre:");
        add(genderLabel);
        genderButtonGroup = new ButtonGroup();
        maleRadioButton = new JRadioButton("Homme");
        genderButtonGroup.add(maleRadioButton);
        femaleRadioButton = new JRadioButton("Femme");
        genderButtonGroup.add(femaleRadioButton);
        add(maleRadioButton);
        add(femaleRadioButton);

        addButton = new JButton("Ajouter");
        addButton.addActionListener(e -> {
            Enumeration<AbstractButton> radioButtons = genderButtonGroup.getElements();
            while (radioButtons.hasMoreElements()) {
                AbstractButton selectedRadioButton = radioButtons.nextElement();
                if (selectedRadioButton.isSelected()) {
                    genderSelected = selectedRadioButton.getText();
                    /*System.out.println(
                            "Name : " + nameTextField.getText() +
                                    "\nEmail : " + emailTextField.getText() +
                                    "\nGender : " + genderSelected
                    );*/
                    ((DefaultTableModel) (table.getModel()))
                            .addRow(
                                    new Object[]{
                                            nameTextField.getText(),
                                            emailTextField.getText(),
                                            genderSelected
                                    }
                            );

                    nameTextField.setText("");
                    emailTextField.setText("");
                    genderButtonGroup.clearSelection();
                }
            }

        });
        add(addButton);
    }

    private void createTable() {
        personTable = new JPanel();
        String[] column = {"Nom", "Email", "Genre"};

        table = new JTable(new DefaultTableModel(column, 0));
        table.setBounds(30, 40, 100, 100);

        scrollPane = new JScrollPane(table);

        personTable.add(scrollPane);
    }

//    TODO: Ajouter le bouton de détails et afficher le détails d'une personne
}
