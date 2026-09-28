package ua.edu.nuos.lab1tech.task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class FunctionTest {
    private final Function function = new Function();

    @Test
    void testForOne() {
        double result = function.calculate(1);

        assertEquals(Math.sqrt(2), result, 0.000001);
    }

    @Test
    void testForTwo() {
        double result = function.calculate(2);

        assertEquals(3.0 / 2.0, result, 0.000001);
    }

    @Test
    void testForThree() {
        double result = function.calculate(4);

        assertEquals(5.0 / Math.sqrt(8), result, 0.000001);
    }

    @Test
    void testOnPositive() {
        double result = function.calculate(5);

        assertTrue(result > 0);
    }
}