package com.hendrick.simplescientificcalculator;

public class CalculationOperation {
    private CalculationOperation(){}

    public static double add(double argumentOne, double argumentTwo){
        return argumentOne + argumentTwo;
    }

    public static double subtract(double argumentOne, double argumentTwo){
        return argumentOne - argumentTwo;
    }

    public static double divide(double argumentOne, double argumentTwo){
        return argumentOne/argumentTwo;
    }

    public static double multiply(double argumentOne, double argumentTwo){
        return argumentOne*argumentTwo;
    }

    public static double logarithm(double argument){
        return Math.log10(argument);
    }

    public static double naturalLog(double argument){
        return Math.log(argument);
    }

    public static double root(double argument, int nthRoot){
        return Math.pow(argument, 1/nthRoot);
    }

    public static double power(double argument, int nthPow){
        return Math.pow(argument, nthPow);
    }
}
