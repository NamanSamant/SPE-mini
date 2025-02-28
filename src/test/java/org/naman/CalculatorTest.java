package org.naman;

import org.junit.Test;
import static org.junit.Assert.*;


public class CalculatorTest {
    double delta = 0.01;
    @Test
    public void testSquareroot() {
        assertEquals(2, Calculator.squareRoot(4), delta);
        assertEquals(4, Calculator.squareRoot(16), delta);
        assertEquals(3, Calculator.squareRoot(9), delta);
        assertEquals(14, Calculator.squareRoot(196), delta);
    }

    @Test
    public void testFactorial() {
        assertEquals(24, Calculator.factorial(4),delta);
        assertEquals(6, Calculator.factorial(3),delta);
        assertEquals(5040, Calculator.factorial(7),delta);
        assertEquals(120, Calculator.factorial(5),delta);
    }

    @Test
    public void testNaturalLogarithm() {
        assertEquals(1.386, Calculator.logNatural(4), delta);
        assertEquals(1.791, Calculator.logNatural(6), delta);
        assertEquals(4.343, Calculator.logNatural(77), delta);
        assertEquals(6.907, Calculator.logNatural(1000), delta);
    }

    @Test
    public void testPower() {
        assertEquals(16, Calculator.powerFunction(4, 2), delta);
        assertEquals(27, Calculator.powerFunction(3, 3), delta);
        assertEquals(3125, Calculator.powerFunction(5, 5), delta);
        assertEquals(59049, Calculator.powerFunction(3, 10), delta);
    }
}
