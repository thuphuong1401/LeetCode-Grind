/*
https://leetcode.com/problems/dice-roll-simulation/
*/
class Solution {
    public int dieSimulator(int n, int[] rollMax) {
        int MOD = (int)(1e9) + 7;
        long[][] dp = new long[n+1][7];
        dp[0][6] = 1;
        for(int j = 0; j < 6; j++) {
            dp[1][j] = 1;
        }
        dp[1][6] = 6;
        for(int i = 2; i <= n; i++) {
            for(int j = 0; j < 6; j++) {
                for(int k = 1; k <= rollMax[j]; k++) {
                    if(i - k < 0) {
                        break;
                    }
                    dp[i][j] += (dp[i-k][6] - dp[i-k][j]) % MOD;
                    dp[i][j] %= MOD;
                }
            }
            for(int j = 0; j <= 5; j++) {
                dp[i][6] += dp[i][j] % MOD;
                dp[i][6] %= MOD;
            }
        }
        return (int)(dp[n][6] + MOD) % MOD;
    }
}

