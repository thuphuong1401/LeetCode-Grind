/*
https://leetcode.com/problems/integer-break/
*/
class Solution {
    public int integerBreak(int n) {
        if(n == 2) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++) {
            int maxProduct = -1;
            for(int j = 1; j < i; j++) {
                /*
                It could be that j > dp[j] therefore we need to get max
                Ex:
                dp[2] = 1 + 1 => 1 * 1 = 1 (constrant: need to separate into k >= 2 operands
                However, dp[4] = 2 + 2 => 2 * 2 = 4
                */
                maxProduct = Math.max(maxProduct, Math.max(j, dp[j]) * Math.max(i - j, dp[i-j]));
            }
            dp[i] = maxProduct;
        }
        return dp[n];
    }
}
