package org.example.dao;

import org.example.model.Role;
import org.example.model.Salarie;
import org.example.utils.ConnexionDb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalarieDao {

    Connection connection;

    private PreparedStatement preparedStatement;

    public int add(Salarie salarie) {
        connection = ConnexionDb.getConnection();
        try {
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO `salarie` " +
                            "(`lastName`, `firstName`, `role`)" +
                        "VALUES " +
                            "(?, ?, ?)"
            );
            preparedStatement.setString(1, salarie.getLastName());
            preparedStatement.setString(2, salarie.getFirstName());
            preparedStatement.setString(3, salarie.getRole().name());
            int n = preparedStatement.executeUpdate();
            connection.close();
            return n;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public List<Salarie> getAll() {
        connection = ConnexionDb.getConnection();
        List<Salarie> salaries;
        try {
            preparedStatement = connection.prepareStatement(
                    "SELECT *" +
                            "FROM `salarie`"
            );
            ResultSet resultSet = preparedStatement.executeQuery();
            salaries = new ArrayList<>();
            while (resultSet.next()){
                Salarie salarie = new Salarie();
                salarie.setId(resultSet.getInt(1));
                salarie.setLastName(resultSet.getString(2));
                salarie.setFirstName(resultSet.getString(3));
                salarie.setRole(Role.valueOf(resultSet.getString(4)));
                salaries.add(salarie);
            }
            connection.close();
            return salaries;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
