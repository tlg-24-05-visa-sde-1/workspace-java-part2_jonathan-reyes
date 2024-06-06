/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.math;

import static org.junit.Assert.*;

import org.junit.*;
public class CalculatorTest {
    //business object(s) under test - called a "fixture"
    private Calculator calc;

    @BeforeClass
    public static void beforeClass()  {
        System.out.println("Before Class");
    }

    @AfterClass
    public static void afterClass()  {
        System.out.println("After Class");
    }

    @Before
    public void setUp()  {
        System.out.println("setup");
        calc = new Calculator();
    }

    @After
    public void cleanUp() {
        System.out.println("cleanup");
    }

    @Test
    public void testIsEven() {
        System.out.println("test isEven");
        assertTrue(calc.isEven(10));
    }

    @Test
    public void testDivide() {
        System.out.println("test divide");
        assertEquals(2.5, calc.divide(5,2), .001);
    }

    @Test
    public void testAdd() {
        System.out.println("test add");
        assertEquals(5, calc.add(1, 4));  // expected, actual
    }
    
}