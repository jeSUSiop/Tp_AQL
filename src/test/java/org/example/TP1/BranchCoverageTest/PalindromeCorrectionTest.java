package org.example.TP1.BranchCoverageTest;

import org.example.TP1.EX01.PalindromeCorrection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeCorrectionTest {
    @Test
    @DisplayName("is empty palindrome?")
    void emptyStringTest(){
        assertTrue(PalindromeCorrection.isPalindrome(""));
    }
    @Test
    @DisplayName("mee => non palindrome?")
    void nonValidTest(){
        assertFalse(PalindromeCorrection.isPalindrome("mee"));
    }
    @Test
    @DisplayName("null=>exception?")
    void nullTest(){
        assertThrows(NullPointerException.class, ()->PalindromeCorrection.isPalindrome(null));
    }
    @Test
    @DisplayName("papa => palindrome?")
    void isPalindrome() {
        assertTrue(PalindromeCorrection.isPalindrome("aka"));
    }
    @Test
    @DisplayName("sigle characterer")
    void testSingleCharacter() {
        assertTrue(PalindromeCorrection.isPalindrome("a"));
    }
}