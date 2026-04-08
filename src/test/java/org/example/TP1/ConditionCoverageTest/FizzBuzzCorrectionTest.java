package org.example.TP1.ConditionCoverageTest;

import org.example.TP1.EX06.FizzBuzzCorrection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FizzBuzzCorrectionTest {
    @Test
    @DisplayName("n non positive?")
    void testInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> FizzBuzzCorrection.fizzBuzz(0));
    }

    @Test
    @DisplayName("3 && 5?")
    void testFizzBuzz() {
        assertEquals("FizzBuzz", FizzBuzzCorrection.fizzBuzz(15));
    }

    @Test
    @DisplayName("3??")
    void testFizz() {
        assertEquals("Fizz", FizzBuzzCorrection.fizzBuzz(3));
    }

    @Test
    @DisplayName("5??")
    void testBuzz() {
        assertEquals("Buzz", FizzBuzzCorrection.fizzBuzz(5));
    }

    @Test
    @DisplayName("non 3 non 5?")
    void testNumber() {
        assertEquals("1", FizzBuzzCorrection.fizzBuzz(1)); // boundary testing
        assertEquals("2", FizzBuzzCorrection.fizzBuzz(2));
    }
    @Test
    void fizzBuzz() {
    }
}