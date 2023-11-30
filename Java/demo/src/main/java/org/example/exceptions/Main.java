package org.example.exceptions;

public class Main {
    public static void main(String[] args) {
        Cards cards = new Cards();
        cards.trade(1);
        try {
            cards.draw(3);
        }
        catch (MyException me){
            System.out.println(me.getMessage());
        }
    }
}
