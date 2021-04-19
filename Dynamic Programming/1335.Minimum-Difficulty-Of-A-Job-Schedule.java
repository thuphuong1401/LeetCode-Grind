/*
https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/
*/

class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if(n < d) {
            return -1;
        }
        int[][] dp = new int[n+1][d+1];
        int INF = (int)1e6;
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= d; j++) {
                dp[i][j] = INF;
            }
        }
        
        int currMax = 0;
        
        for(int i = 1; i <= n; i++) {
            currMax = Math.max(currMax, jobDifficulty[i-1]);
            dp[i][1] = currMax;
        }
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= d; j++) {
                for(int k = 1; k < i; k++) {
                    if(j > i) {
                        continue;
                    }
                    dp[i][j] = Math.min(dp[i][j], dp[k][j-1] + getMax(jobDifficulty, k, i-1));
                }
            }
        }    
        return dp[n][d];
    }
    
    
    private int getMax(int[] arr, int start, int end) {
        int ans = 0;
        for(int i = start; i <= end; i++) {
            ans = Math.max(ans, arr[i]);
        }
        return ans;
    }
}
