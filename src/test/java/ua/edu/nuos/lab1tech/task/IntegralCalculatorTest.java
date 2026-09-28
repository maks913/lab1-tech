package ua.edu.nuos.lab1tech.task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegralCalculatorTest {

    private final Function function = new Function();

    @Test
    void testWith1000() {
        IntegralCalculator calculator = new IntegralCalculator(1, 4, 1000, function);

        double result = calculator.calculate();

        assertEquals(4.7140, result, 0.0001);
    }

    @Test
    void testWithBoolean() {
        IntegralCalculator calculator = new IntegralCalculator(1, 4, 2, function);

        double result = calculator.calculate();

        assertTrue(result > 4.5);
        assertTrue(result < 5.8);
    }
}