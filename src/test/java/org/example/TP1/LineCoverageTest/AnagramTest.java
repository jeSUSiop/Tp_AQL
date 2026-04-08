package org.example.TP1.LineCoverageTest;

import org.example.TP1.EX02.Anagram;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnagramTest {
    @Test
    @DisplayName("null ???")
    void nullTest(){
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram(null, "test"));
    }
    @Test
    @DisplayName("len1!=len2 ??")
    void differentLenTest(){
        assertFalse(Anagram.isAnagram("azert", "azerty"));
    }
    @Test
    @DisplayName("same len, non anagram?")
    void nonAnagram(){
        assertFalse(Anagram.isAnagram("azert", "qsdfg"));
    }
    @Test
    @DisplayName("a normal true case???")
    void isAnagram() {
        assertTrue(Anagram.isAnagram("azert", "treza"));
    }
}