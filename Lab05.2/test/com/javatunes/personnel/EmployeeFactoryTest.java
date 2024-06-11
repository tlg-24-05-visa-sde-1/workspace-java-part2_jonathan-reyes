package com.javatunes.personnel;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class EmployeeFactoryTest {
    private Map<String,String> seMap;
    private Map<String,String> heMap;

    /**
     * client input request is a Map<String,String>, here's a sample
     * key        value
     * ---        -----
     * type       HE or SE
     * name       Jackie
     * hireDate   1990-08-24
     * 
     * salary     50000.00
     * OR
     * rate       50.0
     * hours      40.0
     * 
     * NOTES:
     * 1. yes, we have redundant setup code, and even some redundant test code (to keep it simple)
     * 2. this is representative of how UIs send user input data to an application:
     * - Java Swing UI components all return their input data as strings
     * - in webapps, HTTP requests from browsers (e.g., a form submission) carry all values as strings
     */
    @Before
    public void init() {
        seMap = new HashMap<>();
        seMap.put("type", "SE");
        seMap.put("name", "Jackie");
        seMap.put("hireDate", "1990-08-24");
        seMap.put("salary", "50000.0");

        heMap = new HashMap<>();
        heMap.put("type", "HE");
        heMap.put("name", "Jackie");
        heMap.put("hireDate", "1990-08-24");
        heMap.put("rate", "50.0");
        heMap.put("hours", "40.0");
    }

    /**
     * TASK: verify that passing seMap into your factory returns a SalariedEmployee, with all properties set.
     * to check an object's type, you can use instanceof or check its Class object (preferred):
     * assertEquals(SalariedEmployee.class, emp.getClass())
     */
    @Test
    public void createEmployee_returnsSalariedEmployee_whenTypeSE() {
        Employee emp = EmployeeFactory.createEmployee(seMap);
                assertEquals(SalariedEmployee.class, emp.getClass());       //making sure same class
        //assertTrue(emp instanceof SalariedEmployee);                //making sure that the employee class created is a salaried employee, dont due as executive would pass in this scenario

        verifyNameAndHireDate(emp);

        SalariedEmployee semp = (SalariedEmployee) emp;
        assertEquals(Double.valueOf("50000.0"), semp.getSalary(),.001);
    }

    /**
     * TASK: verify that passing heMap into your factory returns a HourlyEmployee, with all properties set.
     */
    @Test
    public void createEmployee_returnsHourlyEmployee_whenTypeHE() {
        Employee emp = EmployeeFactory.createEmployee(heMap);
        assertEquals(HourlyEmployee.class, emp.getClass());       //making sure same class
        //assertTrue(emp instanceof HourlyEmployee);

        verifyNameAndHireDate(emp);

        //we need to call hourly employee specific methods
        HourlyEmployee hemp = (HourlyEmployee) emp;
        assertEquals(Double.valueOf("50.0"), hemp.getRate(), .001);
        assertEquals(Double.valueOf("40.0"), hemp.getHours(),.001);
        //if trying to do one of the above in inline and downcasting in one:
        //assertEquals(Double.valueOf("40.0"), ((HourlyEmployee)emp).getHours(),.001);
    }

    private static void verifyNameAndHireDate(Employee emp) {
        assertEquals("Jackie", emp.getName());
        assertEquals(Date.valueOf("1990-08-24"), emp.getHireDate());
    }

    /**
     * TASK: verify that passing a map with an invalid "type" value results in IllegalArgumentException.
     * The only valid values for "type" are "HE" or "SE".
     */
    @Test (expected = IllegalArgumentException.class)
    public void testCreateEmployeeInvalidTypeThrowsIllegalArgumentException() {
        heMap.put("type", "INVALID-TYPE");
        EmployeeFactory.createEmployee(heMap);
    }
}