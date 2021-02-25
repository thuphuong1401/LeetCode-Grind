/*
https://leetcode.com/problems/spiral-matrix-ii/
*/

/*
My implementation
*/
class Solution {
    public int[][] generateMatrix(int n) {
        int rowStart = 0;
        int rowEnd = n-1;
        int colStart = 0;
        int colEnd = n-1;
        
        int[][] answer = new int[n][n];
        
        int curr = 1;
        while(curr <= n*n) {
            
            for(int i = colStart; i <= colEnd; i++) {
                answer[rowStart][i] = curr;
                curr++;
            }
            rowStart++;
            
            for(int i = rowStart; i <= rowEnd; i++) {
                answer[i][colEnd] = curr;
                curr++;
            }
            colEnd--;
            
            for(int i = colEnd; i >= colStart; i--) {
                answer[rowEnd][i] = curr;
                curr++;
            }
            rowEnd--;
            
            for(int i = rowEnd; i >= rowStart; i--) {
                answer[i][colStart] = curr;
                curr++;
            }
            colStart++;
            
        }
        
        return answer;
    }
}
