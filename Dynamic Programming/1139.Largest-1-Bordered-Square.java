/*
https://leetcode.com/problems/largest-1-bordered-square/
*/

class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] leftToRight = new int[m][n];
        int[][] topToBot = new int[m][n];
        
        for(int i = 0; i < m; i++) {
            int count = 0;
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    count++;
                } else {
                    count = 0;
                }
                
                leftToRight[i][j] = count;
            }
        }
        
        for(int i = 0; i < n; i++) {
            int count = 0;
            for(int j = 0; j < m; j++) {
                if(grid[j][i] == 1) {
                    count++;
                } else {
                    count = 0;
                }
                
                topToBot[j][i] = count;
            }
        }
        
        int res = 0;
        
        for(int i = m-1; i >= 0; i--) {
            for(int j = n-1; j >= 0; j--) {
                int small = Math.min(leftToRight[i][j], topToBot[i][j]); // bottom right corner of the square
                while(small > 0) { // "candidates" for side length of square
                    if(leftToRight[i - small + 1][j] >= small && topToBot[i][j - small + 1] >= small) {
                        res = Math.max(res, small);
                    }
                    small--;
                }
            }
        }
        
        return res * res;
        
    }
}
