package org.example.dao;

import org.example.connexion.ConnectionUtil;
import org.example.model.Contact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactDao {

    Connection con;

    private PreparedStatement ps;

    public int addContact(Contact contact) {
        con = ConnectionUtil.getConnection();

        try {
            ps = con.prepareStatement("INSERT INTO `contact`(`name`, `number`) VALUES(?,?)");
            ps.setString(1, contact.getName());
            ps.setString(2, contact.getNumber());
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Contact> getAllContacts() {
        con = ConnectionUtil.getConnection();
        List<Contact> contacts;

        try {
            ps = con.prepareStatement("SELECT  * FROM `contact`");
            ResultSet result = ps.executeQuery();
            contacts = new ArrayList<>();
            while (result.next()) {
                Contact contact = new Contact();
                contact.setId(result.getInt(1));
                contact.setName(result.getString(2));
                contact.setNumber(result.getString(3));
                contacts.add(contact);
            }
            return contacts;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Contact getOneContact(int id) {
        con = ConnectionUtil.getConnection();
        Contact contact = new Contact();

        try {
            ps = con.prepareStatement("SELECT * FROM `contact` WHERE id = ?");
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                contact.setId(result.getInt(1));
                contact.setName(result.getString(2));
                contact.setNumber(result.getString(3));
            }
            return contact;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int updateContact(Contact contact) {
        con = ConnectionUtil.getConnection();

        try {
            ps = con.prepareStatement("UPDATE `contact` SET `name` = ?, `number` = ? WHERE id = ?");
            ps.setString(1, contact.getName());
            ps.setString(2, contact.getNumber());
            ps.setInt(3, contact.getId());
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int deleteContact(int id) {
        con = ConnectionUtil.getConnection();

        try {
            ps = con.prepareStatement("DELETE FROM `contact` WHERE id = ?");
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
