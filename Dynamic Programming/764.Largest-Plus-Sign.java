/*
https://leetcode.com/problems/largest-plus-sign/
My implementation - A space-optimzed DP version
Big idea: find the cumulative number of ones to the left, right, top, bottom of each position (i, j), and each dp[i][j] is the minimum of those 4 numbers.
*/

class Solution {
    
    public int orderOfLargestPlusSign(int n, int[][] mineSpots) {
        
        int[][] dp = new int[n][n];
        int maxOrder = 0;
        
        int[][] mines = new int[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(mines[i], 1);
        }
        
        for(int[] spot : mineSpots) {
            mines[spot[0]][spot[1]] = 0;
        }
            
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(mines[i][j] == 1) {
                    dp[i][j] = n;
                }
            }
        }
        
        for(int i = 0; i < n; i++) {
            
            // left to right
            int count = 0;
            for(int j = 0; j < n; j++) {
                if(mines[i][j] == 1) {
                    count++;
                } else {
                    count = 0;
                }
                dp[i][j] = Math.min(dp[i][j], count);
            }
            
            // right to left
            count = 0;
            for(int j = n-1; j >= 0; j--) {
                if(mines[i][j] == 1) {
                    count++;
                } else {
                    count = 0;
                }
                dp[i][j] = Math.min(dp[i][j], count);
            }   
        }
        
        
        for(int i = 0; i < n; i++) {
            
            // top to bottom
            int count = 0;
            for(int j = 0; j < n; j++) {
                if(mines[j][i] == 1) {
                    count++;
                } else {
                    count = 0;
                }
                dp[j][i] = Math.min(dp[j][i], count);
            }
            
            // bottom to top
            count = 0;
            for(int j = n-1; j >= 0; j--) {
                if(mines[j][i] == 1) {
                    count++;
                } else {
                    count = 0;
                }
                dp[j][i] = Math.min(dp[j][i], count);
            }
        }
        
        int res = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}
