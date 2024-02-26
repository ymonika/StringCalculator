package com;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {

    @Test
    public void testEmptyString() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(0, calculator.add(""));
    }

    @Test
    public void testTwoAndThreeNumberString() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(1, calculator.add("0,1"));
        assertEquals(6, calculator.add("1,5"));
        assertEquals(0, calculator.add(""));
    }

    @Test
    public void testNewLineInputWithNumbers() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.add("1\n2,3"));
        assertEquals(1, calculator.add("1, \n"));
    }

    @Test
    public void testChangeInDelimiterNewLineInputWithNumbers() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(3, calculator.add("//;\n1;2"));
    }

    @Test
    public void testNegativeNumbersInput() {
        StringCalculator calculator = new StringCalculator();
        RuntimeException exception = assertThrows(RuntimeException.class, () -> calculator.add("-1,-2,3,-5"));
        assertEquals("negative numbers not allowed [-1, -2, -5]", exception.getMessage());
    }


}
