package org.example.view.dialog;

import org.example.dao.ContactDao;
import org.example.model.Contact;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateDialog extends JDialog {

    private JPanel jPanel;

    public UpdateDialog() {
        setSize(300, 250);

        jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        JLabel idL = new JLabel("Id : ");
        jPanel.add(idL);
        JTextField idTF = new JTextField();
        idTF.setColumns(15);
        jPanel.add(idTF);

        JLabel nameL = new JLabel("Nom : ");
        JTextField nameTF = new JTextField();
        JLabel numberL = new JLabel("Number : ");
        JTextField numberTF = new JTextField();

        JButton searchBtn = new JButton("Search");
        searchBtn.addActionListener(e -> {
            Contact contact;
            ContactDao contactDao = new ContactDao();
            contact = contactDao.getOneContact(Integer.parseInt(idTF.getText()));
            if (contact.getName() != null && contact.getNumber() != null) {
                nameTF.setText(contact.getName());
                numberTF.setText(contact.getNumber());
            } else {
                JOptionPane.showMessageDialog(null, "Record not found for given id");
            }
        });
        jPanel.add(searchBtn);


        jPanel.add(nameL);
        nameTF.setColumns(15);
        jPanel.add(nameTF);


        jPanel.add(numberL);
        numberTF.setColumns(15);
        jPanel.add(numberTF);

        JButton jButton = new JButton("OK");
        jButton.addActionListener(e -> {
            Contact contact = new Contact();
            contact.setId(Integer.parseInt(idTF.getText()));
            contact.setName(nameTF.getText());
            contact.setNumber(numberTF.getText());
            ContactDao contactDao = new ContactDao();
            int count = contactDao.updateContact(contact);
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
