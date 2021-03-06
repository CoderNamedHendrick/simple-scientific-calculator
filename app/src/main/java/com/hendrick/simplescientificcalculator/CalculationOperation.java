package com.hendrick.simplescientificcalculator;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class CalculationOperation {
    static DecimalFormat df = new DecimalFormat("#.#########");

    private CalculationOperation(){ df.setRoundingMode(RoundingMode.CEILING);}

    public static String add(double argumentOne, double argumentTwo){
        return df.format(argumentOne + argumentTwo);
    }

    public static String subtract(double argumentOne, double argumentTwo){
        return df.format(argumentOne - argumentTwo);
    }

    public static String divide(double argumentOne, double argumentTwo){
        return df.format(argumentOne/argumentTwo);
    }

    public static String multiply(double argumentOne, double argumentTwo){
        return df.format(argumentOne*argumentTwo);
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
