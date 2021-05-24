/*
https://leetcode.com/problems/n-queens/
*/
class Solution {
    
    List<List<String>> result;
    
    public List<String> stringifyBoard(int[][] board) {
        int n = board.length;
        List<String> ans = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 0) {
                    sb.append(".");
                } else {
                    sb.append("Q");
                }
            }
            ans.add(sb.toString());
        }
        return ans;
    }
    
    
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        int[][] board = new int[n][n];
        solve(board, 0, n);
        return result;
    }
    
    public boolean checkBoard(int[][] board, int row, int col) {
        int n = board.length;
        
        // check column
        for(int i = 0; i < n; i++) {
            if(board[i][col] == 1) {
                return false;
            }
        }
        
        // check row
        for(int i = 0; i < n; i++) {
            if(board[row][i] == 1) {
                return false;
            }
        }
        
        // check main diagonal
        int r = row;
        int c = col;
        while(r >= 0 && c >= 0) {
            if(board[r][c] == 1) {
                return false;
            }
            r--;
            c--;
        }
        
        r = row;
        c = col;
        
        while(r < n && c < n) {
            if(board[r][c] == 1) {
                return false;
            }
            r++;
            c++;
        }
        
        // check secondary diagonal
        r = row;
        c = col;
        while(r < n && c >= 0) {
            if(board[r][c] == 1) {
                return false;
            }
            r++;
            c--;
        }
        r = row;
        c = col;
        
        while(r >= 0 && c < n) {
            if(board[r][c] == 1) {
                return false;
            }
            r--;
            c++;
        }
        return true;
    }
    
    
    public void solve(int[][] board, int row, int n) {
        if(row == n) {
            result.add(stringifyBoard(board));
            return;
        }
        
        for(int col = 0; col < n; col++) {
            if(checkBoard(board, row, col)) {
                board[row][col] = 1;
                solve(board, row+1, n);
                board[row][col] = 0;
            }
        }
    }
    
}
