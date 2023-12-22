package org.example.service;

import org.example.entity.Customer;
import org.example.entity.Event;
import org.example.entity.EventLocation;

import java.time.LocalDateTime;
import java.util.List;

public interface IBilletterieService {
    //    <editor-fold desc="EventLocation CRUD">
    public EventLocation createAndSaveEventLocation(String name, String address, int capacity);

    public EventLocation readEventLocationById(int eventLocationId);

    public List<EventLocation> readEventsLocations();

    public boolean updateEventLocation(EventLocation eventLocation);

    public boolean deleteEventLocation(int eventLocationId);
//    </editor-fold>

    //    <editor-fold desc="Event CRUD">
    public Event createAndSaveEvent(String name, LocalDateTime dateTime, EventLocation eventLocation, double price);

    public Event readEventById(int eventId);

    public List<Event> readEvents();

    public boolean updateEvent(Event event);

    public boolean deleteEvent(int eventId);
//    </editor-fold>

    //    <editor-fold desc="Customer CRUD">
    public Customer createAndSaveCustomer(String firstName, String lastName, String email);

    public Customer readCustomerById(int customerId);

    public List<Customer> readCustomers();

    public boolean updateCustomer(Customer customer);

    public boolean deleteCustomer(int customerId);
//    </editor-fold>
}
