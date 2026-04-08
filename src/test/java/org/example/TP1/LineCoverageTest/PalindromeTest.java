package org.example.TP1.LineCoverageTest;

import org.example.TP1.EX01.Palindrome;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeTest {
    @Test
    @DisplayName("null=>exception?")
    void nullTest(){
        assertThrows(NullPointerException.class, ()->Palindrome.isPalindrome(null));
    }
    @Test
    @DisplayName("is empty palindrome?")
    void emptyStringTest(){
        assertTrue(Palindrome.isPalindrome(""));
    }
    @Test
    @DisplayName("akar => non palindrome?")
    void nonValidTest(){
        assertFalse(Palindrome.isPalindrome("akar"));
    }
    @Test
    @DisplayName("aka => palindrome?")
    void isPalindrome() {
        assertTrue(Palindrome.isPalindrome("aka"));
    }
}