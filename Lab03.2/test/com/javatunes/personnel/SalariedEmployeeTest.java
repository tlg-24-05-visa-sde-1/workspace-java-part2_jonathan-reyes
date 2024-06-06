package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class SalariedEmployeeTest {
    private SalariedEmployee emp;

    @Before
    public void setUp()  {
        emp = new SalariedEmployee("John", Date.valueOf("2020-02-02"), 1250.0);
    }
    @Test
    public void testPay() {
        assertEquals(1250, emp.pay(),.001) ;
    }

    @Test
    public void testPayTaxes() {
        assertEquals(375, emp.payTaxes(),.001) ;        //REMEMBER with doubles  you have to put in .001 as the 3rd part
    }


}