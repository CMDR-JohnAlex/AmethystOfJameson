package com.cmdr_johnalex;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TestExample
{
    @Test
    public void testAddition()
    {
        int result = 2 + 3;
        assertEquals(5, result);
    }

    @Test
    public void testSubtraction()
    {
        int result = 5 - 3;
        assertEquals(2, result);
    }

    @Test
    public void testMultiplication()
    {
        int result = 2 * 3;
        assertEquals(6, result);
    }

    @Test
    public void testDivision()
    {
        int result = 6 / 3;
        assertEquals(2, result);
    }

    @Test
    public void testModulo()
    {
        int result = 5 % 2;
        assertEquals(1, result);
    }
}
