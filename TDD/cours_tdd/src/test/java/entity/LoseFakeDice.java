package entity;

import org.example.entity.Dice;

public class LoseFakeDice implements Dice {
    @Override
    public int getValue() {
        return 3;
    }
}
