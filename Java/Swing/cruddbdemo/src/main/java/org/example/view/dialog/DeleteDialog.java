package org.example.view.dialog;

import org.example.dao.ContactDao;
import org.example.model.Contact;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteDialog extends JDialog {

    private JPanel jPanel;

    public DeleteDialog() {
        setSize(300,100);
        setTitle("Delete Contact");

        jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        JLabel idL = new JLabel("Id : ");
        jPanel.add(idL);
        JTextField idTF = new JTextField();
        idTF.setColumns(5);
        jPanel.add(idTF);

        JButton jButton = new JButton("Delete");
        jButton.addActionListener(e -> {
            ContactDao contactDao = new ContactDao();
            int rowDeleted = contactDao.deleteContact(Integer.parseInt(idTF.getText()));
            if (rowDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Record delete successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Record can't deleted!");
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
