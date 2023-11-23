package org.example.poo;

import org.example.poo.enums.Priority;

public class Phone extends Product {
    int prix;
    Priority priority;
    public Phone(){


    }

    public Phone(int id, String name, int prix) {
        super(id, name);
        this.prix = prix;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public void setPriority(String priority) {
        this.priority = Priority.valueOf(priority);
    }
}
