/*
https://leetcode.com/problems/burst-balloons/
*/
class Solution { // can also use divide & conquer (memoization)
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n+2];
        for(int i = 1; i < n+1; i++) {
            newNums[i] = nums[i-1];
        }
        newNums[0] = newNums[n+1] = 1;
        
        int[][] dp = new int[n+2][n+2]; // dp[l][r] => maxCoins[l, r]
        for(int l = n; l >= 1; l--) {
            for(int r = l; r <= n; r++) {
                if(l == r) {
                    dp[l][r] = newNums[l-1] * newNums[l] * newNums[l+1];
                }
                for(int i = l; i <= r; i++) { 
                    dp[l][r] = Math.max(dp[l][r], dp[l][i-1] + newNums[l-1] * newNums[i] * newNums[r+1] + dp[i+1][r]);
                }
            }
        }
        return dp[1][n]; 
    }
}


