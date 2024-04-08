package org.example;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Jeu du taquin");
        jFrame.setSize(500, 500);
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        jFrame.add(new Taquin().getPanel());
        jFrame.setVisible(true);
    }
}