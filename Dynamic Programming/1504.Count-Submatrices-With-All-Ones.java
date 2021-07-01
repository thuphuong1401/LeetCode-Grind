/*
https://leetcode.com/problems/count-submatrices-with-all-ones/
*/
class Solution {
    public int numSubmat(int[][] mat) {
        int count = 0;
        int m = mat.length;
        int n = mat[0].length;
        int[][] heights = new int[m][n];
        
        for(int i = 0; i < n; i++) {
            heights[0][i] = mat[0][i];
        }
        
        for(int i = 1; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 0) {
                    heights[i][j] = 0;
                } else if(mat[i][j] == 1) {
                    heights[i][j] = heights[i-1][j] + 1;
                }
            }
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int min = 200;
                for(int l = j; l < n; l++) {
                    min = Math.min(min, heights[i][l]);
                    count += min;
                }
            }
        }
        
        
        return count;
    }
}
