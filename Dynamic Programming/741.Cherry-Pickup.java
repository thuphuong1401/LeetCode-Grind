/*
https://leetcode.com/problems/cherry-pickup/
*/

class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        
        int[][][] dp = new int[n+1][n+1][n+1];
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= n; j++) {
                for(int k = 0; k <= n; k++) {
                    dp[i][j][k] = Integer.MIN_VALUE;
                }
            }
        }
        // imagine 2 people both travelling from (0, 0) to (n-1, n-1)
        // after k steps, r1 + c1 = k = r2 + c2
        for(int r1 = 1; r1 <= n; r1++) {
            for(int c1 = 1; c1 <= n; c1++) {
                for(int r2 = 1; r2 <= n; r2++) {
                    int k = r1 + c1;
                    if(k - r2 <= 0 || k - r2 > n || grid[r1 - 1][c1 - 1] == -1 || grid[r2 - 1][k - r2 - 1] == -1) {
                        continue;
                    }
                    if(r1 == 1 && c1 == 1 && r2 == 1) { 
                        dp[r1][c1][r2] = grid[0][0];
                        continue;
                    }
                    dp[r1][c1][r2] = Math.max(dp[r1 - 1][c1][r2], Math.max(dp[r1 - 1][c1][r2 - 1], Math.max(dp[r1][c1 - 1][r2], dp[r1][c1 - 1][r2 - 1])));
                    if(r1 == r2 && c1 == k - r2) { // if both people come to the same position
                        dp[r1][c1][r2] += grid[r1 - 1][c1 - 1];
                    } else {
                        dp[r1][c1][r2] += grid[r1 - 1][c1 - 1];
                        dp[r1][c1][r2] += grid[r2 - 1][k - r2 - 1];
                    }
                }
            }
        }
        
        if(dp[n][n][n] < 0) {
            return 0;
        }
        return dp[n][n][n]; // both people travel successfully from (0,0) to (n-1, n-1)
        
    }
}
