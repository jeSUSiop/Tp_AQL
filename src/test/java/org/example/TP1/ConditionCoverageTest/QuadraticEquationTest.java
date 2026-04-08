package org.example.TP1.ConditionCoverageTest;

import org.example.TP1.EX04.QuadraticEquation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuadraticEquationTest {
    @Test
    @DisplayName("a=0->exception??")
    void aZeroTest(){
        assertThrows(IllegalArgumentException.class, () -> QuadraticEquation.solve(0, 1, 1));
    }
    @Test
    @DisplayName("a!=0 and delta = -4 < 0??")
    void negativeDeltaTest(){
        assertNull(QuadraticEquation.solve(1, 0, 1));
    }
    @Test
    @DisplayName("delat=0?")
    void zeroDeltaTest(){
        double[] result = QuadraticEquation.solve(1, 2, 1);
        assertArrayEquals(new double[]{-1.0}, result, 0.0001);
    }

    @Test
    @DisplayName("delta>0??")
    void solve() {
        double[] result = QuadraticEquation.solve(1, 0, -1); // delta = 4 → roots = 1, -1
        assertArrayEquals(new double[]{1.0, -1.0}, result, 0.0001);
    }
}