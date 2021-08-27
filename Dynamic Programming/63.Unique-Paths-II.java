/*
https://leetcode.com/problems/unique-paths-ii/
*/

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        int ind = 0;
        while(ind < n) {
            if(obstacleGrid[0][ind] == 1) {
                break;
            } else {
                dp[0][ind] = 1;
            }
            ind++;
        }
        ind = 0;
        while(ind < m) {
            if(obstacleGrid[ind][0] == 1) {
                break;
            } else {
                dp[ind][0] = 1;
            }
            ind++;
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                } 
            }
        }
        return dp[m-1][n-1];
    }
}
