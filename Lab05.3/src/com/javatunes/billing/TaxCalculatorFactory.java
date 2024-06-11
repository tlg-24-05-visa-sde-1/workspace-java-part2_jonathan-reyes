package com.javatunes.billing;

public class TaxCalculatorFactory {



    public static TaxCalculator getTaxCalculator(Location location){
        TaxCalculator taxCalc = null;

        switch(location){
            case EUROPE:
                taxCalc = new EuropeTax();
                break;
            case USA:
                taxCalc = new USATax();
                break;
            case ONLINE:
                taxCalc = new OnlineTax();
        }

        return taxCalc;
    }
}