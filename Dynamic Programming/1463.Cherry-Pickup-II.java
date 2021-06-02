/*
https://leetcode.com/problems/cherry-pickup-ii/
*/

class Solution {
    
    // dp[i][j][k]: max number of cherries when robot 1 is at jth col and robot 2 is at kth col
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][n];
        dp[0][0][n-1] = grid[0][0] + grid[0][n-1];
        
        for(int i = 1; i < m; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++) {
                    if(j > i || k < n - i - 1) {
                        continue; // unreachable by one of the 2 bots
                    }
                    
                    for(int l = -1; l <= 1; l++) {
                        for(int h = -1; h <= 1; h++) {
                            int uj = j + l;
                            int uk = k + h;
                            /*
                            Check 2 conditions:
                            1. uj and uk must be within bounds of the matrix
                            2. uj <= i-1 (robot1 can't reach positions in which row < col) and uk >= n-i (ditto)
                            */
                            if((0 <= uj && uj < n && uj <= i-1) && (uk < n && uk >= 0 && uk >= n-i)) {
                                dp[i][j][k] = Math.max(dp[i][j][k], dp[i-1][uj][uk]);
                            }
                        }
                    }
                    
                    if(j == k) {
                        dp[i][j][k] += grid[i][j];
                    } else {
                        dp[i][j][k] += (grid[i][j] + grid[i][k]);
                    }
                }
            }
        }
        
        int max = 0;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(dp[m-1][i][j] > max) {
                    max = dp[m-1][i][j];
                }
            }
        }
        
        return max;
    }
    
    
}

