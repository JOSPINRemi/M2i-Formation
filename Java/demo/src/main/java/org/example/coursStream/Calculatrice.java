package org.example.coursStream;

public class Calculatrice {
    public double addition(double a, double b){
        return a + b;
    }

    public static double soustraction(double a, double b){
        return a - b;
    }

    public static double multiplication(double a, double b){
        return a * b;
    }

    public double calcule(double a, double b, MethodeCalcule methode){
        return methode.run(a, b);
    }
}
