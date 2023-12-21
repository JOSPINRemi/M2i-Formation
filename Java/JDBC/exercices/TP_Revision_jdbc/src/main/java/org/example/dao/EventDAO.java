package org.example.dao;

import jdk.jshell.spi.ExecutionControl;
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
    public boolean update(Event element) throws SQLException, ExecutionControl.NotImplementedException {
        return false;
    }

    @Override
    public boolean delete(Event element) throws SQLException, ExecutionControl.NotImplementedException {
        return false;
    }

    @Override
    public Event get(int id) throws SQLException, ExecutionControl.NotImplementedException {
        return null;
    }

    @Override
    public List<Event> get() throws SQLException, ExecutionControl.NotImplementedException {
        return null;
    }
}
