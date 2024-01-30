package org.example.entity;

import java.util.Random;

public class RealDice implements Dice {
    public Random random;

    public RealDice() {
        random = new Random();
    }

    @Override
    public int getValue() {
        return random.nextInt(1, 7);
    }
}
