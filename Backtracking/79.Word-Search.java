/*
https://leetcode.com/problems/word-search/
*/

class Cell {
    int x;
    int y;
    
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    int n, m;
    boolean[][] visited;
    int[] dx = {-1, 1, 0, 0}; // up, down, left, right
    int[] dy = {0, 0, -1, 1};
    
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        
        visited = new boolean[m][n];
        boolean answer = false;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == word.charAt(0) && !answer) {
                    answer = DFS(board, new Cell(i, j), word, 1);
                }
            }
        }
        return answer;
    }
    
    
    public boolean DFS(char[][] board, Cell c, String word, int index) {
        if(index >= word.length()) {
            return true;
        }
        visited[c.x][c.y] = true;
        for(int i = 0; i < 4; i++) {
            int ux = c.x + dx[i];
            int uy = c.y + dy[i];
            if(0 <= ux && ux < m && 0 <= uy && uy < n) {
                if(!visited[ux][uy] && board[ux][uy] == word.charAt(index)) {
                    //visited[ux][uy] = true;
                    if(DFS(board, new Cell(ux, uy), word, index+1)) {
                        return true;
                    }
                }
            }
        }
        
        // backtracking wrong moves
        visited[c.x][c.y] = false;
        
        return false;
    }
}
