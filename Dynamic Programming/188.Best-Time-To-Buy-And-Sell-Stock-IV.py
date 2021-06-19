# https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/


# TLE solution. Does not TLE in Java though
class Solution:
    
    def maxProfit(self, k: int, prices: List[int]) -> int:
        # dp[i][j]: profit up to ith transaction and possibly sell at jth day
        # dp[i][j] = max(dp[i][j], prices[j] - prices[k] + dp[i-1][k-1]) for k=[0...j]
        n = len(prices)
        if n == 0:
            return 0;
        dp = [[0 for i in range(n)] for j in range(k+1)]
        for i in range(1, k+1):
            for j in range(1, n):
                minPrice = prices[0]
                for l in range(1, j+1):
                    minPrice = min(minPrice, prices[l] - dp[i-1][l-1])
                
                dp[i][j] = max(dp[i][j-1], prices[j] - minPrice)
                
        return dp[k][n-1]
      
      
# AC solution
class Solution:
    
    def maxProfit(self, k: int, prices: List[int]) -> int:
        n = len(prices)
        if n == 0:
            return 0
        dp = [[0 for i in range(n)] for k in range(k+1)]
        
        for l in range(1, k+1):
            minPrice = prices[0]
            for m in range(1, n):
                minPrice = min(minPrice, prices[m] - dp[l-1][m-1])
                dp[l][m] = max(dp[l][m-1], prices[m] - minPrice)
        
        
        return dp[k][n-1]
