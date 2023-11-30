package org.example.exceptions;

import java.util.ArrayList;

public class Cards {
    private ArrayList<String> cards;

    public Cards() {
        this.cards = new ArrayList<>();
    }

    public ArrayList<String> draw(int nbCards) throws MyException {
        if (nbCards > 4){
            throw new MyException("Tricheur !!!");
        }
        return new ArrayList<>();
    }

    public String trade(int nbCards){
        if (nbCards > 2){
            throw new MySecondException("Moins de 2 cartes !!!");
        }
        return "Voilà vos cartes";
    }
}
