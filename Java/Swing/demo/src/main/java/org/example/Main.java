package org.example;

import org.example.component.Table;
import org.example.layout.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Demo Layout");
        jFrame.setSize(1200, 500);
        jFrame.setLocationRelativeTo(null);
        /*jFrame.setResizable(false);
        jFrame.add(new BorderLayoutDemo());
        jFrame.add(new FlowLayoutDemo().getJPanel());
        jFrame.add(new GridLayoutDemo().getJPanel());
        jFrame.add(new GridBagLayoutDemo().getJPanel());
        jFrame.add(new BoxLayoutDemo().getPanel());*/
        jFrame.add(new Table().getScrollPane());
//        jFrame.pack();
        jFrame.setVisible(true);
    }
}