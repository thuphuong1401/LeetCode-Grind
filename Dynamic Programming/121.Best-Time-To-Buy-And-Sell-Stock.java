/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
*/


/*
One pass - Time O(n), Space O(1)
Idea: 
- Loop through every element of the array
- At every point, update the minPrice (lowest buy point so far) and maxProfit. 
- Update maxProfit so far if the difference (currProfit - minPriceSoFar) is larger 
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
