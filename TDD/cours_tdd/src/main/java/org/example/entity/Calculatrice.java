package org.example.entity;

import java.util.Arrays;
import java.util.List;

public class Calculatrice {

    public double addition(double a, double b) {
        return a + b;
    }

    public double division(double a, double b) {
        if (b != 0) {
            return a / b;
        } else
            throw new RuntimeException("B must be not equal to 0");
    }

    public List<Integer> getList() {
        return Arrays.asList(1,2, 3);
    }
}
