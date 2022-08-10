package DynamicProgramming;

/*
URL: https://leetcode.com/problems/coin-change-2/
 */

public class CoinChangeII {
    private int getNumberOfWaysByRecursion(int coin[], int amount, int numberOfCoins) {
        if(numberOfCoins <= 0 || amount < 0) {
            return 0;
        }
        if(amount == 0) {
            return 1;
        }

        return getNumberOfWaysByRecursion(coin, amount, numberOfCoins - 1)
                + getNumberOfWaysByRecursion(coin, amount - coin[numberOfCoins - 1], numberOfCoins);
    }

    private int getNumberOfWaysByDP(int coin[], int amount) {
        int numberOfWaysTable[] = new int[amount + 1];

        numberOfWaysTable[0] = 1;

        for(int i = 0; i < coin.length; i++) {
            for(int j = coin[i]; j <= amount; j++) {
                numberOfWaysTable[j] = numberOfWaysTable[j] + numberOfWaysTable[j - coin[i]];
            }
        }

        return numberOfWaysTable[amount];
    }

    public static void main(String[] args) {
        int coin[] = {1, 2, 3};
        int amount = 5;

        CoinChangeII coinChangeII = new CoinChangeII();

        int numberOfWays;

        numberOfWays = coinChangeII.getNumberOfWaysByDP(coin, amount);
        System.out.println("Number of Ways By DP: " + numberOfWays);

        numberOfWays = coinChangeII.getNumberOfWaysByRecursion(coin, amount, coin.length);
        System.out.println("Number of Ways By Recursion: " + numberOfWays);
    }
}
