package org.example.dao;

import org.example.entity.Event;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EventDAO extends BaseDAO<Event> {
    public EventDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Event element) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Event element) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public Event get(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Event> get() throws SQLException {
        return null;
    }
}
