package Recursion;

/*
URL: https://leetcode.com/problems/count-good-numbers/
 */

public class CountGoodNumbers {
    int mod = (int)(1e9 + 7);

    private long calculateXPowerY(long x, long y) {
        if(y == 0) {
            return 1;
        }

        if(y == 1) {
            return x;
        }

        long temp = calculateXPowerY(x, y / 2) % mod;

        if(y % 2 == 0) {
            temp = temp * temp;
        }
        else {
            temp = x * temp * temp;
        }

        return temp;
    }

    public int countGoodNumbers(long n) {
        long oddCount = n / 2;
        long evenCount = n - oddCount;

        long oddGoodNumbers = calculateXPowerY(4, oddCount) % mod;
        long evenGoodNumbers = calculateXPowerY(5, evenCount) % mod;

        int result = (int)((oddGoodNumbers * evenGoodNumbers) % mod);

        return result;
    }
}
