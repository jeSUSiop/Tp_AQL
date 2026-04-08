package org.example.TP1.ConditionCoverageTest;

import org.example.TP1.EX03.BinarySearchCorrection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BinarySearchCorrectionTest {
    @Test
    @DisplayName("null array???")
    void nullArrayTest() {
        assertThrows(NullPointerException.class, () -> BinarySearchCorrection.binarySearch(null, 5));
    }

    @Test
    @DisplayName("[] ????")
    void emptyArrayTest() {
        assertEquals(-1, BinarySearchCorrection.binarySearch(new int[]{}, 5));
    }

    @Test
    @DisplayName("found in mid???")
    void elementFoundAtMidTest() {
        int[] array = {1, 3, 5, 7, 9};
        assertEquals(2, BinarySearchCorrection.binarySearch(array, 5));
    }
    @Test
    @DisplayName("1st element???")
    void elementFoundAtStartTest() {
        int[] array = {1, 3, 5};
        assertEquals(0, BinarySearchCorrection.binarySearch(array, 1));
    }

    @Test
    @DisplayName("last element???")
    void elementFoundAtEndTest() {
        int[] array = {1, 3, 5};
        assertEquals(2, BinarySearchCorrection.binarySearch(array, 5));
    }

    @Test
    @DisplayName("non exist??")
    void elementNotFoundTest() {
        int[] array = {1, 3, 5};
        assertEquals(-1, BinarySearchCorrection.binarySearch(array, 2));
    }
    @Test
    void binarySearch() {
    }
}