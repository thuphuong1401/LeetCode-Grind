/*
https://leetcode.com/problems/valid-sudoku/
*/

class Solution {
    
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.' && !isValid(board, board[i][j] - '0', i, j)) {
                    return false;
                }
            }
        }    
        
        return true;
    }
    
    private boolean isValid(char[][] board, int val, int row, int col) {
        
        // check row
        for(int i = 0; i < 9; i++) {
            if(col == i) {
                continue;
            }
            if(board[row][i] - '0' == val) {
                return false;
            }    
        }
        
        // check col
        for(int i = 0; i < 9; i++) {
            if(row == i) {
                continue;
            }
            if(board[i][col] - '0' == val) {
                return false;
            }
        }
        
        // check subgrid
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for(int i = startRow; i < startRow + 3; i++) {
            for(int j = startCol; j < startCol + 3; j++) {
                if(i == row && j == col) {
                    continue;
                }
                if(board[i][j] - '0' == val) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
}
