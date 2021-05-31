/*
https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
*/
class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int m;
    int n;
    int[][] dp; // dp[i][j]: longest path starting from (i, j)
    
    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        int maxPathLength = 0;
        dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int pathLength = DFS(matrix, i, j);
                maxPathLength = Math.max(maxPathLength, pathLength);
            }
        }
        return maxPathLength;
    }
    
    private int DFS(int[][] matrix, int i, int j) { // longest path starting at (i, j)
        if(dp[i][j] != 0) {
            return dp[i][j];
        }
        int length = 0;
        for(int k = 0; k < 4; k++) {
            int ux = i + dx[k];
            int uy = j + dy[k];
            if(0 <= ux && ux < m && 0 <= uy && uy < n && matrix[ux][uy] > matrix[i][j]) {
                length = Math.max(length, DFS(matrix, ux, uy));
            }
        }
        dp[i][j] = length+1;
        return length+1;
    }
    
}
