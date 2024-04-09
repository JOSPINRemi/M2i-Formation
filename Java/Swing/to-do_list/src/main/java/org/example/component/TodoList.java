package org.example.component;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TodoList extends JFrame {

    private JPanel headerPanel;
    private JTextField input;

    private DefaultListModel<String> todos;
    private int selectedIndex;

    private JPanel footerPanel;

    public TodoList() {
        setLayout(new BorderLayout());
        setTitle("To-Do List App");
        setSize(500, 700);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createHeader();

        createList();

        createFooter();
    }

    private void createHeader() {
        headerPanel = new JPanel();

        input = new JTextField(10);
        headerPanel.add(input);

        add(headerPanel, BorderLayout.NORTH);
    }

    private void createList() {
        todos = new DefaultListModel<>();
        JList<String> jListTodos = new JList<>(todos);

        jListTodos.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()){
                selectedIndex = jListTodos.getSelectedIndex();
            }
        });

        this.getContentPane().add(new JScrollPane(jListTodos), BorderLayout.CENTER);
    }

    private void createFooter() {
        footerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 20));

        JButton addButton = new JButton("Add");
        addButton.addActionListener(e -> {
//            System.out.println("input : " + input.getText());
            todos.addElement(input.getText());
//            System.out.println("todos : " + todos);
            input.setText("");
        });
        footerPanel.add(addButton);

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(e -> todos.remove(selectedIndex));
        footerPanel.add(deleteButton);

        JButton completeButton = new JButton("Complete");
        completeButton.addActionListener(e -> {
            todos.set(selectedIndex, todos.get(selectedIndex) + " [Complétée]");
        });
        footerPanel.add(completeButton);

        add(footerPanel, BorderLayout.SOUTH);
    }
}
