package org.example.TP1.ConditionCoverageTest;

import org.example.TP1.EX05.RomanNumeralCorrection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RomanNumeralCorrectionTest {

    @Test
    @DisplayName("n not in range???")
    void testInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeralCorrection.toRoman(0));
        assertThrows(IllegalArgumentException.class, () -> RomanNumeralCorrection.toRoman(4000));
    }

    @Test
    @DisplayName("min boundary?")
    void testMinimumValue() {
        assertEquals("I", RomanNumeralCorrection.toRoman(1));
    }

    @Test
    @DisplayName("max boundary?")
    void testMaximumValue() {
        assertEquals("MMMCMXCIX", RomanNumeralCorrection.toRoman(3999));
    }
    @Test
    void testStandardNumerals() {
        assertEquals("V", RomanNumeralCorrection.toRoman(5));
        assertEquals("X", RomanNumeralCorrection.toRoman(10));
        assertEquals("L", RomanNumeralCorrection.toRoman(50));
    }
    @Test
    void testSubtractiveNotation() {
        assertEquals("IV", RomanNumeralCorrection.toRoman(4));
        assertEquals("IX", RomanNumeralCorrection.toRoman(9));
        assertEquals("XL", RomanNumeralCorrection.toRoman(40));
    }
    @Test
    void toRoman() {
    }
}