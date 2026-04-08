package org.example.TP1.LineCoverageTest;

import org.example.TP1.EX06.FizzBuzz;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {
    @Test
    @DisplayName("n non positive?")
    void testInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> FizzBuzz.fizzBuzz(0));
    }

    @Test
    @DisplayName("3 && 5?")
    void testFizzBuzz() {
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(15));
    }

    @Test
    @DisplayName("3??")
    void testFizz() {
        assertEquals("Fizz", FizzBuzz.fizzBuzz(3));
    }

    @Test
    @DisplayName("5??")
    void testBuzz() {
        assertEquals("Buzz", FizzBuzz.fizzBuzz(5));
    }

    @Test
    @DisplayName("non 3 non 5?")
    void testNumber() {
        assertEquals("1", FizzBuzz.fizzBuzz(1)); // boundary testing
        assertEquals("2", FizzBuzz.fizzBuzz(2));
    }
    @Test
    void fizzBuzz() {
    }
}