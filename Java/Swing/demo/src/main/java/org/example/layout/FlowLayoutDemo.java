package org.example.layout;

import lombok.Data;

import javax.swing.*;
import java.awt.*;

@Data
public class FlowLayoutDemo {

    private JPanel jPanel;

    private JLabel jLabel;

    private JComboBox<String> comboBox;

    public FlowLayoutDemo() {
        jPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 20));

        JButton button = new JButton("Button1");
        button.setBackground(Color.GREEN);
        button.addActionListener(e -> System.out.println("Button click"));

        jPanel.add(button);

        jPanel.add(new JButton("Button 2"));
        jPanel.add(new JButton("Button 3"));

        jPanel.add(new JLabel("Label"));

        JTextField input = new JTextField(20);
        jPanel.add(input);

        comboBox = new JComboBox<>(new String[]{"option1", "option2", "option3"});
        jPanel.add(comboBox);

        jLabel = new JLabel("Résultat et Sélection s'afficheront ici");
        jPanel.add(jLabel);

        JButton validateButton = new JButton("Valider");
        validateButton.addActionListener(e -> {
            String selected = (String) comboBox.getSelectedItem();
            String inputText = input.getText();

            jLabel.setText("Input data : " + inputText + " Selected data : " + selected);
        });
        jPanel.add(validateButton);
    }
}
