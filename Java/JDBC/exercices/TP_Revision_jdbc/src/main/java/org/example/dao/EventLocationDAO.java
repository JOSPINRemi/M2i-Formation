package org.example.dao;

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
        query = "INSERT INTO event_location " +
                    "(address, capacity, name, event_id) " +
                "VALUES " +
                    "(?, ?, ?, ?)";
        statement = _connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, element.getAddress());
        statement.setInt(2, element.getCapacity());
        statement.setString(3, element.getName());
        statement.setInt(4, 0);
        int nbRow = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if (resultSet.next()) {
            element.setId(resultSet.getInt(1));
        }
        return nbRow == 1;
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

    @Override
    public boolean update(EventLocation element) throws SQLException {
        query =
                "UPDATE event_location " +
                "SET " +
                    "name = ? " +
                    "address = ? " +
                    "capacity = ? " +
                    "event_id = ? " +
                "WHERE id = ?";
        statement = _connection.prepareStatement(query);
        statement.setString(1, element.getName());
        statement.setString(2, element.getAddress());
        statement.setInt(3, element.getCapacity());
//        FIXME clé étrangère
//        statement.setInt(4,);
        statement.setInt(5, element.getId());
        int nbRow = statement.executeUpdate();
        return nbRow == 1;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        query = "DELETE FROM event_location WHERE id = ?";
        statement = _connection.prepareStatement(query);
        statement.setInt(1, id);
        int nbRow = statement.executeUpdate();
        return nbRow == 1;
    }
}
