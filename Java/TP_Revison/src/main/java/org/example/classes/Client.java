package org.example.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

@AllArgsConstructor
@Getter
@ToString
public class Client {
    @Setter
    private String lastName;

    @Setter
    private String firstName;

    @Setter
    private String email;

    @Setter
    private ArrayList<Event> purchasedTickets;

    public Client(String lastName, String firstName, String email) {
        this(lastName, firstName, email, new ArrayList<>());
    }

    public Client(String lastName, String firstName) {
        this(lastName, firstName, null, new ArrayList<>());
    }

    public boolean buyTicket(Event event){
        return purchasedTickets.add(event);
    }

    public boolean cancelTicketPurchase(Event event){
        return purchasedTickets.remove(event);
    }
}
