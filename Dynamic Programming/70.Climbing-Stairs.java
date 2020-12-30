/*
https://leetcode.com/problems/climbing-stairs/
*/

// Simplest DP solution
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i < n+1; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}


// Recursion with memoization
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        return climbStairsHelper(n, dp);
    }
    
    public int climbStairsHelper(int n, int[] dp) {
        if(n == 0 || n == 1) {
            return 1;    
        }
        if(dp[n-1] != 0 && dp[n-2] != 0) {
            return dp[n-1] + dp[n-2];
        } else {
            int x = climbStairsHelper(n-2, dp);
            dp[n-2] = x;
            int y = climbStairsHelper(n-1, dp);
            dp[n-1] = y;
            return x + y;
        }
    }
}

