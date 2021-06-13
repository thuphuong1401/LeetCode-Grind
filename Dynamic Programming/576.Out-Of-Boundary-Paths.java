/*
https://leetcode.com/problems/out-of-boundary-paths/
*/
class Solution {
    int[][][] dp;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int MOD = (int)1e9 + 7;
    int sizeX;
    int sizeY;
    
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        sizeX = m;
        sizeY = n;
        dp = new int[m][n][maxMove + 1]; // out of bounds path starting at (startRow, startColumn) and having numMoves left
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < maxMove+1; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        int res = dfs(startRow, startColumn, maxMove);
        return res % MOD;
    }
    
    
    private int dfs(int startRow, int startColumn, int move) {
        
        // if out of bounds and still have some moves left
        if(!checkInBounds(startRow, startColumn) && move >= 0) {
            return 1; 
        } else if(move <= 0) {
            return 0;
        } else /*checkInBounds(grid.length, grid[0].length, startRow, startColumn)*/ {
            if(dp[startRow][startColumn][move] != -1) {
                return dp[startRow][startColumn][move]; 
            } else {
                int ans = 0;
                for(int i = 0; i < 4; i++) {
                    int ux = startRow + dx[i];
                    int uy = startColumn + dy[i];
                    int res = dfs(ux, uy, move - 1);
                    ans += (res % MOD);
                    ans %= MOD;
                }        
                dp[startRow][startColumn][move] = ans;
                return ans;
            }
        }
    }
    
    private boolean checkInBounds(int ux, int uy) {
        if(0 <= ux && ux < sizeX && 0 <= uy && uy < sizeY) {
            return true;
        }
        return false;
    }
    
}
