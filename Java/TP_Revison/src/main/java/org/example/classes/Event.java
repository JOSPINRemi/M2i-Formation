package org.example.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@Getter
@ToString
public class Event {
    @Setter
    private String name;

    @Setter
    private LocalDate date;

    @Setter
    private LocalTime time;

    @Setter
    private Location location;

    @Setter
    private double price;

    @Setter
    private int numberOfTicketsSold;

    public Event(String name, Location location, double price) {
        this(name, LocalDate.now(), LocalTime.now(), location, price, 0);
    }

    public Event(String name, LocalDate date, LocalTime time, Location location, double price) {
        this(name, date, time, location, price, 0);
    }

    public boolean isTicketAvailable(){
        return numberOfTicketsSold <= location.getCapacity();
    }

    public void sellTicket(){
        numberOfTicketsSold++;
    }

    public void cancelTicketSale(){
        numberOfTicketsSold--;
    }
}
