/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
Idea: find increasing subarrays. Get (max - min) of such to add to profit.
*/

class Solution {
    int MAX = (int)1e4 + 1;
    
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 1) {
            return 0;
        }
        
        int profit = 0;
        boolean isIncreasing = false;
        int currMin = prices[0];
        int currMax = prices[0];
        
        for(int i = 1; i < n; i++) {
            
            int currPrice = prices[i];
            
            if(currPrice > prices[i-1]) {
                isIncreasing = true;
                currMax = currPrice;
            } else {
                isIncreasing = false;
                profit += (currMax - currMin);
            }
            
            if(!isIncreasing) {
                currMin = currMax = currPrice;
            }
        }
        
        if(isIncreasing) {
            profit += (currMax - currMin);
        }
        return profit;
    }
}

