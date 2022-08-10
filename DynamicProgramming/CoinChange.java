package DynamicProgramming;

/*
URL: https://leetcode.com/problems/coin-change/
 */

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int coinTable[] = new int[amount + 1];

        for(int i = 1; i <= amount; i++) {
            int minimum = Integer.MAX_VALUE;

            for(int j = 0; j < coins.length; j++) {
                if(coins[j] <= i) {
                    int remainingAmount = i - coins[j];
                    int remainingAmountMinimum = coinTable[remainingAmount];

                    if(remainingAmountMinimum != -1) {
                        if(remainingAmountMinimum < minimum) {
                            minimum = remainingAmountMinimum;
                        }
                    }
                }
            }

            if(minimum == Integer.MAX_VALUE) {
                coinTable[i] = -1;
            }
            else {
                coinTable[i] = minimum + 1;
            }
        }

        return coinTable[amount];
    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();

        int coins[] = {1, 2, 5};
        int amount = 11;

        int result = coinChange.coinChange(coins, amount);

        System.out.println(result);
    }
}
