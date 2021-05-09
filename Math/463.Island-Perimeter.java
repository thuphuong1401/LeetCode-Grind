/*
https://leetcode.com/problems/island-perimeter/
*/

/*
My implementation 
No hash table required
Time O(4mn) - Space O(1)
*/
class Solution {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int perimeter = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    int numAdjacentCells = check(grid, i, j);
                    perimeter += (4 - numAdjacentCells);
                }
            } 
        }
        return perimeter;
    }
    
    private int check(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int numAdjacentCells = 0;
        for(int k = 0; k < 4; k++) {
            int ux = i + dx[k];
            int uy = j + dy[k];
            if(0 <= ux && ux < m && 0 <= uy && uy < n && grid[ux][uy] == 1) {
                numAdjacentCells++;
            }
        }
        return numAdjacentCells;
    }
}


/*
Slightly better counting
Only check whether a grid borders with either (LEFT or UP) or (RIGHT or DOWN) squares
*/
class Solution {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int perimeter = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    perimeter += 4;
                    // check whether this square borders with any LEFT and UP squares
                    if(j > 0 && grid[i][j-1] == 1) {
                        perimeter -= 2;
                    }
                    
                    if(i > 0 && grid[i-1][j] == 1) {
                        perimeter -= 2;
                    }
                } 
            }
        }
        return perimeter;
    }
}




