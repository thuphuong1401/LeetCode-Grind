/*
https://leetcode.com/problems/matrix-block-sum/
*/

class Solution {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] answer = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                for(int r = i-K; r <= i+K; r++) {
                    for(int c = j-K; c <= j+K; c++) {
                        if(0 <= r && r < m && 0 <= c && c < n) {
                            answer[i][j] += mat[r][c];
                        }
                    }
                }
            }
        }
        return answer;
    }
}
