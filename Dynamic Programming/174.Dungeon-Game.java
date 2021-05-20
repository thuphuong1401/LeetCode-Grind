/*
https://leetcode.com/problems/dungeon-game/
*/

class Solution {
    int m, n;
    int[][] dp;
    int MAX = Integer.MAX_VALUE;
    
    private int minHealth(int currCell, int row, int col) {
        if(row >= m || col >= n) {
            return MAX;
        }
        return Math.max(1, dp[row][col] - currCell);
    }
    
    public int calculateMinimumHP(int[][] dungeon) {
        m = dungeon.length;
        n = dungeon[0].length;
        dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j] = MAX;
            }
        }
        
        for(int i = m-1; i >= 0; i--) {
            for(int j = n-1; j >= 0; j--) {
                int currCell = dungeon[i][j];
                if(i == m-1 && j == n-1) {
                    if(currCell >= 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = 1 - currCell;
                    }
                    continue;
                }
                
                int rightHealth = minHealth(currCell, i, j+1);
                int downHealth = minHealth(currCell, i+1, j);
                int currHealth = Math.min(rightHealth, downHealth);
                dp[i][j] = currHealth;
                
            }
        }
        return dp[0][0];
    }
}
