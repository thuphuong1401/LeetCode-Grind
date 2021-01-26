/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
*/

class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];
        
        for(int i = 1; i < prices.length; i++) {
            int currPrice = prices[i];
            minPrice = Math.min(minPrice, currPrice);
            int currProfit = currPrice - minPrice;
            maxProfit = Math.max(maxProfit, currProfit);
        }
        return maxProfit;
    }
}
