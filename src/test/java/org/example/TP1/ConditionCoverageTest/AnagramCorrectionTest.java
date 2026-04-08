package org.example.TP1.ConditionCoverageTest;

import org.example.TP1.EX02.AnagramCorrection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnagramCorrectionTest {
    @Test
    @DisplayName("null ???")
    void nullTest(){
        assertThrows(NullPointerException.class, () -> AnagramCorrection.isAnagram(null, "test"));
    }
    @Test
    @DisplayName("len1!=len2 ??")
    void differentLenTest(){
        assertFalse(AnagramCorrection.isAnagram("azert", "azerty"));
    }
    @Test
    @DisplayName("same len, non anagram?")
    void nonAnagram(){
        assertFalse(AnagramCorrection.isAnagram("azert", "qsdfg"));
    }
    @Test
    @DisplayName("a normal true case???")
    void isAnagram() {
        assertTrue(AnagramCorrection.isAnagram("azert", "treza"));
    }
}