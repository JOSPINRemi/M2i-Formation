package org.example;

import org.example.component.Tp;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Complex Two Panel Example");
        jFrame.setSize(500, 700);
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jFrame.add(new Tp());

        jFrame.setVisible(true);
    }
}