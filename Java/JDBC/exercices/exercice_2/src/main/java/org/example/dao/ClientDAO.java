package org.example.dao;

import org.example.models.Client;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO extends BaseDAO<Client> {
    public ClientDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Client element) throws SQLException {
        request = "INSERT INTO client (nom, prenom, telephone) VALUES (?, ?, ?)";
        statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, element.getNom());
        statement.setString(2, element.getPrenom());
        statement.setString(3, element.getTelephone());
        int nbRows = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if (resultSet.next()) {
            element.setId(resultSet.getInt(1));
        }
        return nbRows == 1;
    }

    @Override
    public boolean update(Client element) throws SQLException {
        request = "UPDATE client SET nom = ?, prenom = ?, telephone = ? WHERE id = ?";
        statement = _connection.prepareStatement(request);
        statement.setString(1, element.getNom());
        statement.setString(2, element.getPrenom());
        statement.setString(3, element.getTelephone());
        statement.setInt(4, element.getId());
        int nbRows = statement.executeUpdate();
        return nbRows == 1;
    }

    @Override
    public boolean delete(Client element) throws SQLException {
        request = "DELETE FROM client WHERE id = ?";
        statement = _connection.prepareStatement(request);
        statement.setInt(1, element.getId());
        int nbRows = statement.executeUpdate();
        return nbRows == 1;
    }

    @Override
    public Client get(int id) throws SQLException {
        Client client = null;
        request = "SELECT * FROM client WHERE id = ?";
        statement = _connection.prepareStatement(request);
        statement.setInt(1, id);
        resultSet = statement.executeQuery();
        if (resultSet.next()) {
            client = new Client(
                    resultSet.getString("nom"),
                    resultSet.getString("prenom"),
                    resultSet.getInt("id"),
                    resultSet.getString("telephone")
            );
        }
        return client;
    }

    @Override
    public List<Client> get() throws SQLException {
        List<Client> result = new ArrayList<>();
        request = "SELECT * FROM person";
        statement = _connection.prepareStatement(request);
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Client client = new Client(
                    resultSet.getString("nom"),
                    resultSet.getString("prenom"),
                    resultSet.getInt("id"),
                    resultSet.getString("telephone")
            );
            result.add(client);
        }
        return result;
    }
}
