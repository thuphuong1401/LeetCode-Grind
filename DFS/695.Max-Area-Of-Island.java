/*
https://leetcode.com/problems/max-area-of-island/
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
    
    private boolean[][] visited;
    private int m, n;
    private int[] dx = {-1, 1, 0, 0}; //up, down, left, right;
    private int[] dy = {0, 0, -1, 1};
    
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j] && grid[i][j] == 1) {
                    int currArea = dfs(grid, new Cell(i, j), 1);
                    max = Math.max(max, currArea);
                }
            }
        }
        return max;    
    }
    
    
    public int dfs(int[][] grid, Cell c, int curr) {
        visited[c.x][c.y] = true;
        for(int i = 0; i < 4; i++) {
            int ux = c.x + dx[i];
            int uy = c.y + dy[i];
            if(0 <= ux && ux < m && 0 <= uy && uy < n && !visited[ux][uy] && grid[ux][uy] == 1) {
                curr = dfs(grid, new Cell(ux, uy), curr + 1);
            }
        }
        return curr;
    }
    
}
