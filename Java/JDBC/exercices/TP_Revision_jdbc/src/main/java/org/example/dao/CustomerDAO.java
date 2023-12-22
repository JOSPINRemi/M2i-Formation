package org.example.dao;

import org.example.entity.Customer;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CustomerDAO extends BaseDAO<Customer> {
    public CustomerDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Customer element) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Customer element) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public Customer get(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Customer> get() throws SQLException {
        return null;
    }
}
