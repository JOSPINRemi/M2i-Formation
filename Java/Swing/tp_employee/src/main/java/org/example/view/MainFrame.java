package org.example.view;

import org.example.controller.EmployeeController;
import org.example.model.Gender;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainFrame extends JFrame {

    private EmployeeController employeeController;

    private List<String> qualifications;

    public MainFrame() {
        employeeController = new EmployeeController();
        qualifications = new ArrayList<>();
        qualifications.add("DOCT");
        qualifications.add("DESS");
        qualifications.add("MAST");
        qualifications.add("LICE");
        qualifications.add("BTS");
        qualifications.add("DEUG");
        qualifications.add("DUT");
        qualifications.add("BAC");

        init();
    }

    private void init() {
        setTitle("Gestion des employés");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);

        JPanel form = new JPanel();

        Dimension textFieldDimensions = new Dimension(100, 20);

        form.add(new JLabel("EmployeeID"));
        JTextField employeeIdTF = new JTextField();
        employeeIdTF.setPreferredSize(textFieldDimensions);
        form.add(employeeIdTF);

        form.add(new JLabel("Name"));
        JTextField nameTF = new JTextField();
        nameTF.setPreferredSize(textFieldDimensions);
        form.add(nameTF);

        form.add(new JLabel("Gender"));
        ButtonGroup genderGroup = new ButtonGroup();
        for (Gender gender : Gender.values()) {
            JRadioButton radioButton = new JRadioButton(gender.name());
            genderGroup.add(radioButton);
            form.add(radioButton);
        }

        form.add(new JLabel("Age"));
        JTextField ageTF = new JTextField();
        ageTF.setPreferredSize(textFieldDimensions);
        form.add(ageTF);

        form.add(new JLabel("BloodGroup"));
        JTextField bloodGroupTF = new JTextField();
        bloodGroupTF.setPreferredSize(textFieldDimensions);
        form.add(bloodGroupTF);

        form.add(new JLabel("ContactNo"));
        JTextField contactNumber = new JTextField();
        contactNumber.setPreferredSize(textFieldDimensions);
        form.add(contactNumber);

        form.add(new JLabel("Qualifiaction"));
        JComboBox<String> qualificationCB = new JComboBox<>();
        for (String q : qualifications) {
            qualificationCB.addItem(q);
        }
        form.add(qualificationCB);

        add(form);

        setVisible(true);
    }
}
