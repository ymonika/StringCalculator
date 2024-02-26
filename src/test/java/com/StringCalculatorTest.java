package com;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {

    @Test
    public void testEmptyString() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    public void testTwoAndThreeNumberString() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(1, calculator.add("0,1"));
        assertEquals(6, calculator.add("1,5"));
        assertEquals(0, calculator.add(""));
    }
}
