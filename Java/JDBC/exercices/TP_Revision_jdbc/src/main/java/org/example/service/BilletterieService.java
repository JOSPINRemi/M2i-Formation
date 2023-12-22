package org.example.service;

import jdk.jshell.spi.ExecutionControl;
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
import java.time.LocalDateTime;
import java.util.List;

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
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //    <editor-fold desc="EventLocation CRUD">
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

    public EventLocation readEventLocationById(int eventLocationId) {
        try {
            return eventLocationDAO.get(eventLocationId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<EventLocation> readEventsLocations() {
        try {
            return eventLocationDAO.get();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateEventLocation(EventLocation eventLocation) {
        try {
            return eventLocationDAO.update(eventLocation);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteEventLocation(int eventLocationId) {
        try {
            return eventLocationDAO.delete(eventLocationId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
//    </editor-fold>

    //    <editor-fold desc="Event CRUD">
    @Override
    public Event createAndSaveEvent(String name, LocalDateTime dateTime, EventLocation eventLocation, double price) {
        Event event;
        try {
            event = new Event(name, dateTime, eventLocation, price);
            if (eventDAO.save(event)) {
                return event;
            }
        } catch (SQLException | CustomFormatException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Event readEventById(int eventId) {
        try {
            return eventDAO.get(eventId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Event> readEvents() {
        try {
            return eventDAO.get();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updateEvent(Event event) {
        try {
            return eventDAO.update(event);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteEvent(int eventId) {
        try {
            return eventDAO.delete(eventId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
//    </editor-fold>

    //    <editor-fold desc="Customer CRUD">
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

    @Override
    public Customer readCustomerById(int customerId) {
        try {
            return customerDAO.get(customerId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Customer> readCustomers() {
        try {
            return customerDAO.get();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        try {
            return customerDAO.update(customer);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteCustomer(int customerId) {
        try {
            return customerDAO.delete(customerId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
//    </editor-fold>
}
