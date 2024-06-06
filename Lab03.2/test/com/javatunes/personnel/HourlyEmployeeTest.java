package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class HourlyEmployeeTest {
    private HourlyEmployee emp;

    @Before
    public void setUp() {
        emp = new HourlyEmployee("Mark", Date.valueOf("2012-05-05"), 25.0,35.00);
    }

    @Test
    public void testPay() {
        assertEquals(875.00,emp.pay(),.001);
    }

    @Test
    public void testPayTaxes() {
        assertEquals(218.75, emp.payTaxes(), 0.001);
    }
}