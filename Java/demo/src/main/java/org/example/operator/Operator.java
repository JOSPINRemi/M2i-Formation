package org.example.operator;

import org.example.model.Maison;

import java.util.Arrays;

public class Operator {

    // region getOperator
    public static void getOperator() {
        System.out.println("**** Le opérateurs ****");

        int i = 10;
        int i2 = -10;

        int i3 = ++i;
        System.out.println("i3 " +i3);

        int i4 = i++;
        System.out.println("i4 " + i4);

        int i5 = i;
        System.out.println("i5 " +i5);

        int i6 = --i;
        System.out.println("i6 " + i6);

        int i7 = i--;
        System.out.println("i7 " + i7);

        int i8 = i;
        System.out.println("i8 " + i8);
    }
    // endregion

    // region getExpression
    public static void getExpression(){
        byte b = 1;
        short s = 1;
        int i = 1;
        long l = 1;
        float f = 1;
        double d = 1;
        char c = 1;

        int express = b + b;
        System.out.println("express : " + express);

        int express2 = b + s;
        System.out.println("express2 : " + express2);

        int express3 = b + i + s;
        System.out.println("express3 : " + express3);

        long express4 = l + i;
        System.out.println("express4 : " + express4);

        float express5 = l + f;
        System.out.println("express5 : " + express5);

        double express6 = d + f;
        System.out.println("express6 : " + express6);

        int t = 2_000_887_697;
        int t2 = 2_000_887_697;

        int total = t + t2;
        System.out.println("La valeur de total : " + total);
    }
    // endregion

    // region getOperatorAndComparaison
    public static void getOperatorAndComparaison() {
        int int1 = 128;
        int int2 = 128;
        System.out.println("int1 == int2 : " + (int1 == int2));

        Integer int3 = 128;
        Integer int4 = 128;
        System.out.println("int3 == int4 : " + (int3 == int4));

        Integer int5 = 127;
        Integer int6 = 127;
        System.out.println("int5 == int6 : " + (int5 == int6));

        Integer int7 = new Integer(127);
        Integer int8 = new Integer(127);
        System.out.println("int7 == int8 : " + (int7 == int8));

        Integer int9 = Integer.valueOf(127);
        Integer int10 = Integer.valueOf(127);
        System.out.println("int9 == int10 : " + (int9 == int10));

        System.out.println("int3 equal int4 " + int3.equals(int4));

        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3};
        System.out.println("arr1 == arr2 " + (arr1 == arr2));
        System.out.println("arr1 equals arr2 " + arr1.equals(arr2));
        System.out.println("Arrays " + Arrays.equals(arr1, arr2));

        arr1 = arr2;
        System.out.println("arr1 == arr2 " + (arr1 == arr2));

        Maison maison = new Maison("maison", 5);
        Maison maison1 = new Maison("maison", 5);
        System.out.println("maison == maison1 " + (maison == maison1));
        System.out.println("maison.nom == maison1.nom " + (maison.nom == maison1.nom));
    }
    // endregion
}
