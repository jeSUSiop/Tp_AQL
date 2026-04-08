package org.example.TP1.BranchCoverageTest;

import org.example.TP1.EX03.BinarySearch;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {
    @Test
    @DisplayName("null array???")
    void nullArrayTest() {
        assertThrows(NullPointerException.class, () -> BinarySearch.binarySearch(null, 5));
    }

    @Test
    @DisplayName("[] ????")
    void emptyArrayTest() {
        assertEquals(-1, BinarySearch.binarySearch(new int[]{}, 5));
    }

    @Test
    @DisplayName("found in mid???")
    void elementFoundAtMidTest() {
        int[] array = {1, 3, 5, 7, 9};
        assertEquals(2, BinarySearch.binarySearch(array, 5));
    }
    @Test
    @DisplayName("1st element???")
    void elementFoundAtStartTest() {
        int[] array = {1, 3, 5};
        assertEquals(0, BinarySearch.binarySearch(array, 1));
    }

    @Test
    @DisplayName("last element???")
    void elementFoundAtEndTest() {
        int[] array = {1, 3, 5};
        assertEquals(2, BinarySearch.binarySearch(array, 5));
    }

    @Test
    @DisplayName("non exist??")
    void elementNotFoundTest() {
        int[] array = {1, 3, 5};
        assertEquals(-1, BinarySearch.binarySearch(array, 2));
    }
    @Test
    void binarySearch() {
    }
}