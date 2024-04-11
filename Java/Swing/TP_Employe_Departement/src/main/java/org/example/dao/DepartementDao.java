package org.example.dao;

import org.example.model.Departement;
import org.example.utils.ConnexionDb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartementDao {

    Connection connection;

    private PreparedStatement preparedStatement;

    public int add(Departement departement) {
        connection = ConnexionDb.getConnection();
        try {
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO `departement` " +
                            "(`name`)" +
                            "VALUES " +
                            "(?)"
            );
            preparedStatement.setString(1, departement.getName());
            int n = preparedStatement.executeUpdate();
            connection.close();
            return n;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public List<Departement> getAll() {
        connection = ConnexionDb.getConnection();
        List<Departement> departements;
        try {
            preparedStatement = connection.prepareStatement(
                    "SELECT *" +
                            "FROM `departement`"
            );
            ResultSet resultSet = preparedStatement.executeQuery();
            departements = new ArrayList<>();
            while (resultSet.next()) {
                Departement departement = new Departement();
                departement.setId(resultSet.getInt(1));
                departement.setName(resultSet.getString(2));
                departements.add(departement);
            }
            connection.close();
            return departements;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
