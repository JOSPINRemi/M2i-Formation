package org.example.dao;

import org.example.models.Operation;
import org.example.models.OperationStatut;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OperationDAO extends BaseDAO<Operation> {

    private CompteBancaireDAO compteBancaireDAO;

    public OperationDAO(Connection connection) {
        super(connection);
    }

    public CompteBancaireDAO getCompteBancaireDAO() {
        return compteBancaireDAO;
    }

    public void setCompteBancaireDAO(CompteBancaireDAO compteBancaireDAO) {
        this.compteBancaireDAO = compteBancaireDAO;
    }

    @Override
    public boolean save(Operation element) throws SQLException {
        request = "INSERT INTO operation (montant, statut) VALUES (?, ?)";
        statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setDouble(1, element.getMontant());
        statement.setString(2, element.getStatut().toString());
        int nbRows = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if (resultSet.next()) {
            element.setNumero(resultSet.getInt(1));
        }
        return nbRows == 1;
    }

    @Override
    public boolean update(Operation element) throws SQLException {
        request = "UPDATE operation SET montant = ?, statut = ? WHERE id = ?";
        statement = _connection.prepareStatement(request);
        statement.setDouble(1, element.getMontant());
        statement.setString(1, element.getStatut().toString());
        int nbRows = statement.executeUpdate();
        return nbRows == 1;
    }

    @Override
    public boolean delete(Operation element) throws SQLException {
        request = "DELETE FROM operation WHERE id = ?";
        statement = _connection.prepareStatement(request);
        statement.setInt(1, element.getNumero());
        int nbRows = statement.executeUpdate();
        return nbRows == 1;
    }

    @Override
    public Operation get(int id) throws SQLException {
        Operation operation = null;
        request = "SELECT * FROM operation WHERE id = ?";
        statement = _connection.prepareStatement(request);
        statement.setInt(1, id);
        resultSet = statement.executeQuery();
        if (resultSet.next()) {
            operation = new Operation(
                    resultSet.getInt("numero"),
                    resultSet.getDouble("montant"),
                    OperationStatut.valueOf(resultSet.getString("statut"))
            );
        }
        return operation;
    }

    @Override
    public List<Operation> get() throws SQLException {
        List<Operation> result = new ArrayList<>();
        request = "SELECT * FROM compte_bancaire";
        statement = _connection.prepareStatement(request);
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Operation operation = new Operation(
                    resultSet.getInt("numero"),
                    resultSet.getDouble("montant"),
                    OperationStatut.valueOf(resultSet.getString("statut"))
            );
            result.add(operation);
        }
        return result;
    }
}
