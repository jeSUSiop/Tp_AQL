package org.example.TP1;

public class Prime {
    public static boolean isPrime(int n) {
        if (n < 2) {//line
            return false;//line
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {//line
            if (n % i == 0) {//line
                return false;//line
            }
        }
        return true;//line
    }
}