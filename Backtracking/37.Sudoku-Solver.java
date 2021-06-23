/*
https://leetcode.com/problems/sudoku-solver/
*/
class Solution {
    
    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }
    
    private boolean solve(char[][] board, int i, int j) {
        if(j == 9) {
            i++;
            j = 0;
        }
        
        if(i == 9) {
            return true;
        }
        
        /*
        for(int l = 0; l < 9; l++){
            for(int m = 0; m < 9; m++) {
                System.out.print(board[l][m] + " ");
            }
            System.out.println();
        }
        System.out.println("_____");
        */
        
        if(board[i][j] == '.') {
            for(int val = 1; val <= 9; val++) {
                if(isValid(board, val, i, j)) {
                    board[i][j] = (char) (val + '0');
                    boolean ans = solve(board, i, j+1);
                    if(ans) {
                        return true;
                    } else {
                        board[i][j] = '.';
                    }
                }
            }
        } else { // occupied number on the board
            return solve(board, i, j+1);
        }
        
        return false;
    }
    
    
    private boolean isValid(char[][] board, int val, int row, int col) {
        
        // check row
        for(int i = 0; i < 9; i++) {
            if(board[row][i] - '0' == val) {
                return false;
            }    
        }
        
        // check col
        for(int i = 0; i < 9; i++) {
            if(board[i][col] - '0' == val) {
                return false;
            }
        }
        
        // check subgrid
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for(int i = startRow; i < startRow + 3; i++) {
            for(int j = startCol; j < startCol + 3; j++) {
                if(board[i][j] - '0' == val) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
}
