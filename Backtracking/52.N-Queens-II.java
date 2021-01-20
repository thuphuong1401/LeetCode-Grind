/*
https://leetcode.com/problems/n-queens-ii/
*/

class Solution {
    
    public int totalNQueens(int n) {
        int[][] board = new int[n][n];
        int count = NQueen(board, 0, n);
        return count;
    }
    
    
    private int NQueen(int[][] board, int row, int n) {
        if(row == n) {
            return 1;
        } 
        
        int count = 0;
        for(int j = 0; j < n; j++) {
            if(valid(board, row, j, n)) { // whether position (row, j) is "unattacked"
                board[row][j] = 1; // place queen
                count += NQueen(board, row + 1, n);
                board[row][j] = 0; // backtracking
            }
        }

        return count;
    }
    
    
    private boolean valid(int[][] board, int row, int col, int n) {
        //  vertical
        for(int i = 0; i < row; i++) {
            if(board[i][col] != 0) {
                return false;
            }
        }
        
        // main diagonal
        for(int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if(board[i][j] != 0) {
                return false;
            }
        }
        
        // secondary diagonal
        for(int i = row, j = col; j < n && i >= 0; i--, j++) {
            if(board[i][j] != 0) {
                return false;
            }
        }
        return true;
    }
    
    
    
}
