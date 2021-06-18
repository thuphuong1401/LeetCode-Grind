/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
*/

/*
TLE DP solution
*/
class Solution {
    
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 0) {
            return 0;   
        }
        /*
        dp[i][j]: best profit for i transactions and sell on jth day
        dp[i][j] = max(dp[i][j-1], prices[j] - prices[k] + dp[i-1][k-1]) for k=[0...j]. k = buy date
        */
        int[][] dp = new int[3][n]; 
        for(int i = 1; i < 3; i++) {
            for(int j = 1; j < n; j++) {
                int min = prices[0];
                for(int k = 1; k <= j; k++) {
                    min = Math.min(min, (prices[k] - dp[i-1][k-1]));
                }
                dp[i][j] = Math.max(dp[i][j-1], prices[j] - min);
            }
        } 
        return dp[2][n-1];
    }
}

/*
Accepted solution
*/
class Solution {
    
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 0) {
            return 0;   
        }
        /*
        dp[i][j]: best profit for i transactions and sell on jth day
        dp[i][j] = max(dp[i][j-1], prices[j] - prices[k] + dp[i-1][k-1]) for k=[0...j]. k = buy date
        */
        int[][] dp = new int[3][n]; 
        for(int i = 1; i < 3; i++) {
            int min = prices[0];
            for(int j = 1; j < n; j++) {
                min = Math.min(min, prices[j] - dp[i-1][j-1]);
                dp[i][j] = Math.max(dp[i][j-1], prices[j] - min);
            }
        }
        
        return dp[2][n-1];
    }
}
