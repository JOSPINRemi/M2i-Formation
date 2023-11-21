package org.example.function;

import org.example.model.Maison;

import java.util.ArrayList;
import java.util.List;

public class DemoFunction {

    public static void getFunction() {
        int result = sum(1, 5, 5);
        System.out.println(result);
        result = sum(5, 8);
        System.out.println(result);
        double result1 = sum(45, 98, 12547, 548, 48);
        System.out.println(result1);

    }
    public static Integer sum(int i1, int i2) {
        int result = i2 + i1;
        return result;
    }

    public static Integer sum(int i1, int i2, int i3) {
        int result = i2 + i1 + i3;
        return result;
    }

    public static double sum(String[] val, double ...doubles) {
        double result = 0;
        for (double d : doubles){
            result += d;
        }
        return result;
    }

    public static List<Maison> sum(Maison[] val) {
        List<Maison> maisons = new ArrayList<>();
        return maisons;
    }
}
