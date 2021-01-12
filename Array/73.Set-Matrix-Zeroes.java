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




// O(1) space, in theory
// Idea: use first row and first col to record all the rows & cols having 0 in them
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        boolean firstRowIsZero = false;
        boolean firstColIsZero = false;
        
        // first row
        for(int i = 0; i < n; i++) {
            if(matrix[0][i] == 0) {
                firstRowIsZero = true;
                break;
            }
        }
        
        // first col
        for(int i = 0; i < m; i++) {
            if(matrix[i][0] == 0) {
                firstColIsZero = true;
                break;
            }
        }
        
        // set 0's for the rest and record them on 1st row and 1st col
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        // set 0's
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        // process the 1st row and 1st col
        if(firstRowIsZero) {
            for(int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
        
        if(firstColIsZero) {
            for(int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
