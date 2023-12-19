package org.example.dao;

import org.example.models.Client;
import org.example.models.CompteBancaire;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CompteBancaireDAO extends BaseDAO<CompteBancaire> {
    private ClientDAO clientDAO;

    public CompteBancaireDAO(Connection connection) {
        super(connection);
    }

    public ClientDAO getClientDAO() {
        return clientDAO;
    }

    public void setClientDAO(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    @Override
    public boolean save(CompteBancaire element) throws SQLException {
        request = "INSERT INTO compte_bancaire (solde, client_id) VALUES (?, ?)";
        statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setDouble(1, element.getSolde());
        statement.setInt(2, element.getClient().getId());
        int nbRows = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if (resultSet.next()) {
            element.setId(resultSet.getInt("id"));
        }
        return nbRows == 1;
    }

    @Override
    public boolean update(CompteBancaire element) throws SQLException {
        request = "UPDATE compte_bancaire SET solde = ? WHERE id = ?";
        statement = _connection.prepareStatement(request);
        statement.setDouble(1, element.getSolde());
        statement.setInt(2, element.getId());
        int nbRows = statement.executeUpdate();
        return nbRows == 1;
    }

    @Override
    public boolean delete(CompteBancaire element) throws SQLException {
        request = "DELETE FROM compte_bancaire WHERE id = ?";
        statement = _connection.prepareStatement(request);
        statement.setInt(1, element.getId());
        int nbRows = statement.executeUpdate();
        return nbRows == 1;
    }

    @Override
    public CompteBancaire get(int id) throws SQLException {
        CompteBancaire compte = null;
        request = "SELECT * FROM compte_bancaire WHERE id = ?";
        statement = _connection.prepareStatement(request);
        statement.setInt(1, id);
        resultSet = statement.executeQuery();
        if (resultSet.next()) {
            Client client = clientDAO.get(resultSet.getInt("client_id"));
            if (client != null) {
                compte = new CompteBancaire(
                        resultSet.getInt("id"),
                        resultSet.getInt("solde"),
                        client
                );
                client.addCompte(compte);
            }
        }
        return compte;
    }

    @Override
    public List<CompteBancaire> get() throws SQLException {
        List<CompteBancaire> result = new ArrayList<>();
        request = "SELECT * FROM compte_bancaire";
        statement = _connection.prepareStatement(request);
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Client client = clientDAO.get(resultSet.getInt("client_id"));
            if (client != null) {
                CompteBancaire compte = new CompteBancaire(
                        resultSet.getInt("id"),
                        resultSet.getDouble("solde"),
                        client
                );
                client.addCompte(compte);
                result.add(compte);
            }
        }
        return result;
    }
}
