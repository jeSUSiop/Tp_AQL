package org.example.TP1.LineCoverageTest;

import org.example.TP1.EX05.RomanNumeral;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RomanNumeralTest {
    @Test
    @DisplayName("n not in range???")
    void testInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(0));
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(4000));
    }

    @Test
    @DisplayName("min boundary?")
    void testMinimumValue() {
        assertEquals("I", RomanNumeral.toRoman(1));
    }

    @Test
    @DisplayName("max boundary?")
    void testMaximumValue() {
        assertEquals("MMMCMXCIX", RomanNumeral.toRoman(3999));
    }

    @Test
    void testStandardNumerals() {
        assertEquals("V", RomanNumeral.toRoman(5));
        assertEquals("X", RomanNumeral.toRoman(10));
        assertEquals("L", RomanNumeral.toRoman(50));
    }

    @Test
    void testSubtractiveNotation() {
        assertEquals("IV", RomanNumeral.toRoman(4));
        assertEquals("IX", RomanNumeral.toRoman(9));
        assertEquals("XL", RomanNumeral.toRoman(40));
    }
    @Test
    void toRoman() {
    }
}