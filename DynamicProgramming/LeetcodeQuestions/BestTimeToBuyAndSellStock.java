package DynamicProgramming.LeetcodeQuestions;

/*
URL: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int buyingPrice = prices[0];
        int maxProfit = 0;

        for(int i = 1; i < prices.length; i++) {
            if(prices[i] < buyingPrice) {
                buyingPrice = prices[i];
            }

            int profit = prices[i] - buyingPrice;

            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }
}
