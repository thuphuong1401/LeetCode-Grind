/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
*/
class Solution {
    
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if(n == 0) {
            return 0;
        }
        int[][] dp = new int[k+1][n];
        
        /*
        dp[i][j] = max profit up to ith transaction, selling at jth day (by time j)
        dp[i][j] = max(dp[i][j-1], prices[j] - prices[k] + dp[i-1][k-1]) for k = [0...i]
        */
        
        for(int i = 1; i <= k; i++) {
            int min = prices[0];
            for(int j = 1; j < n; j++) {
                min = Math.min(min, prices[j] - dp[i-1][j-1]);
                dp[i][j] = Math.max(dp[i][j-1], prices[j] - min);
            }
        }
        
        return dp[k][n-1];
    }
}
