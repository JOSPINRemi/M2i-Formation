package org.example;

import lombok.Data;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

@Data
public class Taquin {

    private JPanel panel;

    GridBagLayout gridBagLayout = new GridBagLayout();

    public Taquin() {
        panel = new JPanel(gridBagLayout);

        ArrayList<Integer> values = new ArrayList<>();
        for (int i = 1; i < 9; i++) {
            values.add(i);
        }

        Collections.shuffle(values);

        int index = 0;

        int[] labelCoord = {2, 2};

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                GridBagConstraints constraints = new GridBagConstraints();
                constraints.gridy = j;
                constraints.gridx = i;
                constraints.weightx = 1;
                constraints.weighty = 1;
                constraints.fill = GridBagConstraints.BOTH;
                if (i == labelCoord[0] && j == labelCoord[1]) {
                    JLabel label = new JLabel();
                    panel.add(label, constraints);
                    labelCoord[0] = gridBagLayout.getConstraints(label).gridx;
                    labelCoord[1] = gridBagLayout.getConstraints(label).gridy;
                } else {
                    JButton button = new JButton(String.valueOf(values.get(index)));
                    index++;
                    button.addActionListener(e -> {

                    });
                    panel.add(button, constraints);
                }
            }
        }
    }
}
