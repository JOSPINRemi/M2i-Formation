package org.example.layout;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutDemo extends JPanel {

    private JButton jButton;

    private JButton jButton1;

    private JButton jButton2;

    private JButton jButton3;

    private JButton jButton4;

    public BorderLayoutDemo() {
        setLayout(new BorderLayout());
        jButton = new JButton("NORTH");
        jButton1 = new JButton("CENTER");
        jButton2 = new JButton("SOUTH");
        jButton3 = new JButton("WEST");
        jButton4 = new JButton("EAST");

        jButton.setForeground(Color.BLUE);
        jButton1.setForeground(Color.ORANGE);
        jButton2.setForeground(Color.GRAY);
        jButton3.setForeground(Color.MAGENTA);
        jButton4.setForeground(Color.BLACK);

        add(jButton, BorderLayout.NORTH);
        add(jButton1, BorderLayout.CENTER);
        add(jButton2, BorderLayout.SOUTH);
        add(jButton3, BorderLayout.WEST);
        add(jButton4, BorderLayout.EAST);
    }
}
