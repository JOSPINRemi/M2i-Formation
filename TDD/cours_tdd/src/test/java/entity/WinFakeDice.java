package entity;

import org.example.entity.Dice;

public class WinFakeDice implements Dice {
    @Override
    public int getValue() {
        return 4;
    }
}
