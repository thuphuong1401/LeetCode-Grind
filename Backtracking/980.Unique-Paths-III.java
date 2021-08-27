/*
https://leetcode.com/problems/unique-paths-iii/
*/

class Solution {
    int count;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int m, n;
    
    public int uniquePathsIII(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        count = 0;
        int start_x = 0;
        int start_y = 0;
        int numEmpty = 1;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    start_x = i;
                    start_y = j;
                } else if(grid[i][j] == 0) {
                    numEmpty++;
                }
            }
        }
        
        backtrack(grid, start_x, start_y, visited, numEmpty);
        return count;
    }
    
    
    private void backtrack(int[][] grid, int i, int j, boolean[][] visited, int numEmpty) {
        visited[i][j] = true;
        
        if(grid[i][j] == 2 && numEmpty == 0) {
            count += 1;
        }
        
        for(int k = 0; k < 4; k++) {
            int ux = i + dx[k];
            int uy = j + dy[k];
            if(0 <= ux && ux < m && 0 <= uy && uy < n && !visited[ux][uy] && grid[ux][uy] >= 0) {
                backtrack(grid, ux, uy, visited, numEmpty - 1);    
            }
        }
        
        visited[i][j] = false;
        
    }
    
} 
