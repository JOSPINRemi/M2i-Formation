package org.example.dao;

import jdk.jshell.spi.ExecutionControl;
import org.example.Exception.CustomFormatException;
import org.example.entity.EventLocation;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EventLocationDAO extends BaseDAO<EventLocation> {
    public EventLocationDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(EventLocation element) throws SQLException {
        query = "INSERT INTO event_location (address, capacity, name) VALUES (?, ?, ?)";
        statement = _connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, element.getAddress());
        statement.setInt(1, element.getCapacity());
        statement.setString(1, element.getName());
        int nbRow = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if (resultSet.next()) {
            element.setId(resultSet.getInt(1));
        }
        return nbRow == 1;
    }

    @Override
    public boolean update(EventLocation element) throws SQLException, ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Méthode à implémenter");
    }

    @Override
    public boolean delete(EventLocation element) throws SQLException, ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Méthode à implémenter");
    }

    @Override
    public EventLocation get(int id) throws SQLException {
        EventLocation eventLocation = null;
        query = "SELECT * FROM event_location WHERE id = ?";
        statement = _connection.prepareStatement(query);
        statement.setInt(1, id);
        resultSet = statement.executeQuery();
        if (resultSet.next()) {
            try {
                eventLocation = new EventLocation(
                        resultSet.getString("name"),
                        resultSet.getString("address"),
                        resultSet.getInt("capacity")
                );
            } catch (CustomFormatException e) {
                System.out.println(e.getMessage());
            }
            eventLocation.setId(resultSet.getInt("id"));

        }
        return eventLocation;
    }

    @Override
    public List<EventLocation> get() throws SQLException {
        List<EventLocation> eventLocations = new ArrayList<>();
        query = "SELECT * FROM event_location";
        statement = _connection.prepareStatement(query);
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            EventLocation eventLocation = null;
            try {
                eventLocation = new EventLocation(
                        resultSet.getString("name"),
                        resultSet.getString("address"),
                        resultSet.getInt("capacity")
                );
            } catch (CustomFormatException e) {
                System.out.println(e.getMessage());
            }
            eventLocation.setId(resultSet.getInt("id"));
            eventLocations.add(eventLocation);
        }
        return eventLocations;
    }
}
