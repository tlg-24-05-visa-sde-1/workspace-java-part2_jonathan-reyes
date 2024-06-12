package com.javatunes.billing;

public class TaxCalculatorFactory {



    public static TaxCalculator getTaxCalculator(Location location){

        /*switch(location){
            case ONLINE:
                return new OnlineTax();
            case USA:
                return new USATax();
            case EUROPE:
                return new EuropeTax();
        }

        return null;
*/

        return switch (location) {
            case EUROPE -> new EuropeTax();
            case USA -> new USATax();
            case ONLINE -> new OnlineTax();
        };

    }
}