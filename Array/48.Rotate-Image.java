/*
https://leetcode.com/problems/rotate-image/
*/
class Solution {
    
    /*
    rotate 90 degree clockwise = reflect through diagonal and flip every rows
    */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        
        // transpose
        for(int i = 0; i <= n; i++) {
            for(int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        // flip every row
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
        
    }
}
