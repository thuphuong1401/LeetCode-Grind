/*
https://leetcode.com/problems/set-matrix-zeroes/
*/

// Space O(m+n)
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        // Allocate new space
        int[] rowZero = new int[m];
        int[] colZero = new int[n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                
                if(matrix[i][j] == 0) {
                    rowZero[i]++;
                    colZero[j]++;
                }
            }
        }
        
        for(int i = 0; i < m; i++) {
            if(rowZero[i] > 0) {
                for(int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        for(int i = 0; i < n; i++) {
            if(colZero[i] > 0) {
                for(int j = 0; j < m; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }
}
