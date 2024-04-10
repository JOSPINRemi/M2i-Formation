package org.example.view.dialog;

import org.example.dao.ContactDao;
import org.example.model.Contact;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InsertDialog extends JDialog {

    private JPanel jPanel;

    private JTextField nameTF;

    private JTextField numberTF;

    public InsertDialog() {
        setSize(300, 200);

        jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));


        JLabel nameL = new JLabel("Nom : ");
        jPanel.add(nameL);

        nameTF = new JTextField();
        nameTF.setColumns(15);
        jPanel.add(nameTF);


        JLabel numberL = new JLabel("Number : ");
        jPanel.add(numberL);

        numberTF = new JTextField();
        numberTF.setColumns(15);
        jPanel.add(numberTF);

        JButton jButton = new JButton("OK");
        jButton.addActionListener(e -> {
            Contact contact = new Contact();
            contact.setName(nameTF.getText());
            contact.setNumber(numberTF.getText());
            ContactDao contactDao = new ContactDao();
            int count = contactDao.addContact(contact);
            if (count > 0) {
                JOptionPane.showConfirmDialog(null, "Operation succeed");
            } else {
                JOptionPane.showConfirmDialog(null, "Operation failed");
            }
            dispose();
        });
        jPanel.add(jButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> dispose());
        jPanel.add(cancelButton);

        this.add(jPanel);
    }
}
