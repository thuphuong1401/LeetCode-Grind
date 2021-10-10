/*
https://leetcode.com/problems/count-number-of-special-subsequences/
*/
class Solution {
    
    public int countSpecialSubsequences(int[] nums) {
        int n = nums.length;
        long[][] dp = new long[n][3];
        int MOD = (int)1e9 + 7;
        
        if(nums[0] == 0) {
            dp[0][0] = 1L;
        }
        
        for(int i = 1; i < n; i++) {
            int curr = nums[i];
            
            dp[i][0] = dp[i-1][0];
            if(curr == 0) {
                dp[i][0] += dp[i-1][0];
                dp[i][0]++;
                dp[i][0] %= MOD;
            }
            
            dp[i][1] = dp[i-1][1];
            if(curr == 1) {
                dp[i][1] += (dp[i-1][1] + dp[i-1][0]) % MOD;
                dp[i][1] %= MOD;
            }
            
            dp[i][2] = dp[i-1][2];
            if(curr == 2) {
                dp[i][2] += (dp[i-1][2] + dp[i-1][1]) % MOD;
                dp[i][2] %= MOD;
            }
        }
        
        
        return (int)(dp[n-1][2] % MOD);
    }
}

/*

Rudimentary formula:

dp[i][j]: tong so subsequence ending at i, with value j (0, 1, 2)
    
    dp[i][0] = sum(dp[k][0]) + 1 for k < i
    dp[i][1] = sum(dp[k][0] + dp[k][1]) for k < i
    dp[i][2] = sum(dp[k][1] + dp[k][2]) for k < i    

-------------------------------------------------------------------

Improved:

New dp definition: dp[i][j] = # of subsequences up to i (not necessarily ending at i) with value j (j = 0, 1, 2)

dp[i][0] = dp[i-1][0] (# of subsequences not containing i => propagate) + dp[i-1][0]
(number of subsequences containing i, if i == 0) + 1
dp[i][1] = dp[i-1][1] + dp[i-1][0] {+ dp[i-1][1] (if i == 1)}
dp[i][2] = dp[i-1][1] + dp[i-1][2] {+ dp[i-1][2] (if i == 2)}

*/  
    
