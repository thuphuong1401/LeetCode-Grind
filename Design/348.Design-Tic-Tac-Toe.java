/*
https://leetcode.com/problems/design-tic-tac-toe/
*/


/*
Optimized brute force
Time O(N), space O(N^2)
*/
class TicTacToe {

    int[][] board;
    int boardSize;
    
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.board = new int[n][n];
        this.boardSize = n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        this.board[row][col] = player;
        if(checkWin(row, col, player)) {
            return player;
        } else {
            return 0;
        }
    }
    
    private boolean checkWin(int row, int col, int player) {
        
        if(checkRow(row, player)) {
            return true;
        } else if(checkCol(col, player)) {
            return true;
        } else if(checkMainDiag(player)) {
            return true;
        } else if(checkSecondaryDiag(player)) {
            return true;
        }
        
        
        return false;
    }
    
    
    private boolean checkRow(int row, int player) {
        for(int i = 0; i < this.boardSize; i++) {
            if(this.board[row][i] != player) {
                return false;
            }
        }
        return true;
    } 
    
    
    private boolean checkCol(int col, int player) {
        for(int i = 0; i < this.boardSize; i++) {
            if(this.board[i][col] != player) {
                return false;
            }
        }
        return true;
    } 
    
    
    private boolean checkMainDiag(int player) {
        for(int i = 0; i < this.boardSize; i++) {
            if(this.board[i][i] != player) {
                return false;
            }
        }
        return true;
    } 
    
    
    private boolean checkSecondaryDiag(int player) {
        int r = this.boardSize - 1;
        int c = 0;
        while(r >= 0 && c < this.boardSize) {
            if(this.board[r][c] != player) {
                return false;
            }
            r--;
            c++;
        }
        return true;
    }
    
    
}



/*
Very smart solution
Idea:
- Win = got N symbols in a row/col/main diag/secondary diag. Because moves are guaranteed to be valid, this mean we need to get the count of
number of time each person is marking a row/col/main diag/secondary diag. If that count == N that means a player won.
*/
class TicTacToe {
    int[] row;
    int[] col;
    int mainDiag;
    int secondaryDiag;
    int N;
    
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.row = new int[n];
        this.col = new int[n];
        this.mainDiag = 0;
        this.secondaryDiag = 0;
        this.N = n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int r, int c, int player) {
        int delta = -1;
        if(player == 1) {
            delta = 1;
        } 
        row[r] += delta;
        col[c] += delta;
        if(r == c) {
            mainDiag += delta;
        }
        if(r == N - c - 1) {
            secondaryDiag += delta;
        }
        
        if(Math.abs(row[r]) == N || Math.abs(col[c]) == N || Math.abs(mainDiag) == N || Math.abs(secondaryDiag) == N) {
            return player;
        }
        
        return 0;
    }
    
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
