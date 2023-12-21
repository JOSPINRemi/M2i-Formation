package org.example.service;

import org.example.Exception.CustomFormatException;
import org.example.dao.CustomerDAO;
import org.example.dao.EventDAO;
import org.example.dao.EventLocationDAO;
import org.example.entity.Customer;
import org.example.entity.Event;
import org.example.entity.EventLocation;
import org.example.utils.DatabaseManager;

import java.sql.Connection;
import java.sql.SQLException;

public class BilletterieService implements IBilletterieService {
    private Connection connection;
    private EventLocationDAO eventLocationDAO;
    private EventDAO eventDAO;
    private CustomerDAO customerDAO;

    public BilletterieService() {
        try {
            connection = DatabaseManager.getConnection();
            customerDAO = new CustomerDAO(connection);
            eventDAO = new EventDAO(connection);
            eventLocationDAO = new EventLocationDAO(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public EventLocation createAndSaveEventLocation(String name, String address, int capacity) {
        EventLocation eventLocation;
        try {
            eventLocation = new EventLocation(name, address, capacity);
            if (eventLocationDAO.save(eventLocation)) {
                return eventLocation;
            }
        } catch (SQLException | CustomFormatException e) {
            throw new RuntimeException(e);
        }
        return null;
    }


    @Override
    public Event createAndSaveEvent(int locationId) {
        Event event;
        try {
            event = new Event();
            if (eventDAO.save(event)) {
                return event;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Customer createAndSaveCustomer(String firstName, String lastName, String email) {
        Customer customer;
        try {
            customer = new Customer();
            customer.setFirstname(firstName);
            customer.setLastname(lastName);
            customer.setEmail(email);
            if (customerDAO.save(customer)) {
                return customer;
            }
        } catch (CustomFormatException | SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
