/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.billing;

/**
 * European orders are taxed as follows:
 * VAT is 17% of taxable amount.
 * Luxury tax is an additional 25% on amount over $100.
 * 
 * TODO: implement this algorithm.
 */
public class EuropeTax implements TaxCalculator{
    public static final double VAT = 0.17;
    public static final double LUXURY_TAX = 0.25;
    public static final double TAXABLE_THRESHOLD = 100.00;

    @Override
    public double taxAmount(double taxable) {
        double totalTax = 0.0;

        if (taxable > TAXABLE_THRESHOLD) {
            totalTax = (taxable*VAT)+(LUXURY_TAX*(taxable-TAXABLE_THRESHOLD));
        }
        else{
            totalTax = taxable*VAT;
        }
      return totalTax;
    }
}