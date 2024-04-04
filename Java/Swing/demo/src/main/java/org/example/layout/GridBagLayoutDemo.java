package org.example.layout;

import lombok.Data;

import javax.swing.*;
import java.awt.*;

@Data
public class GridBagLayoutDemo {

    private JPanel jPanel;

    GridBagLayout gridBagLayout = new GridBagLayout();

    public GridBagLayoutDemo() {
        jPanel = new JPanel();

        gridBagLayout.columnWidths = new int[6];
        gridBagLayout.rowHeights = new int[6];

        jPanel.setLayout(gridBagLayout);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton jButton = new JButton("i" + i + " j" + j);
                GridBagConstraints constraints = new GridBagConstraints();
                constraints.gridy = j;
                constraints.gridx = i;
                constraints.weightx = 1;
                constraints.weighty = 1;
                constraints.fill = GridBagConstraints.BOTH;
                if (i == 0 && j == 0) {
                    constraints.gridwidth = 2;
                }
                if (i == 1 && j == 1) {
                    constraints.gridheight = 2;
                }
                jPanel.add(jButton, constraints);
            }
        }
    }
}
