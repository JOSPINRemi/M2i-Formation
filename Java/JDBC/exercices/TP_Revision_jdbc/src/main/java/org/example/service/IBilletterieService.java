package org.example.service;

import org.example.entity.Customer;
import org.example.entity.Event;
import org.example.entity.EventLocation;

public interface IBilletterieService {
    public EventLocation createAndSaveEventLocation(String name, String address, int capacity);

    public Event createAndSaveEvent(int locationId);

    public Customer createAndSaveCustomer(String firstName, String lastName, String email);


}
