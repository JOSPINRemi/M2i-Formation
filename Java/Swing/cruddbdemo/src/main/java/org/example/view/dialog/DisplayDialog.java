package org.example.view.dialog;

import org.example.dao.ContactDao;
import org.example.model.Contact;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class DisplayDialog extends JDialog {

    private JPanel jPanel;

    private JTable jTable;

    public DisplayDialog() {
        setSize(500, 500);
        setTitle("Show All Contacts");

        jPanel = new JPanel();

        ContactDao contactDao = new ContactDao();
        List<Contact> contacts = contactDao.getAllContacts();
        String[] columnsName = {"ID", "Name", "Number"};

        jTable = new JTable(new DefaultTableModel(columnsName, 0));
        for (Contact c : contacts) {
            ((DefaultTableModel) (jTable.getModel()))
                    .addRow(
                            new Object[]{
                                    c.getId(), c.getName(), c.getNumber()
                            }
                    );
        }
        JScrollPane scrollPane = new JScrollPane(jTable);
        jPanel.add(scrollPane);

        JButton jButton = new JButton("Quitter");
        jButton.addActionListener(e -> dispose());
        jPanel.add(jButton);

        this.add(jPanel);
    }
}
