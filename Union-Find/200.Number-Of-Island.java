/*
https://leetcode.com/problems/number-of-islands/
*/

/*
DFS approach
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
    
    public int numIslands(char[][] grid) {
        int count = 0;
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j] && grid[i][j] == '1') {
                    dfs(new Cell(i, j), grid);
                    count++;
                }
            }
        }
        return count;
    }
    
    public void dfs(Cell cell, char[][] grid) {
        visited[cell.x][cell.y] = true;
        int[] dx = {-1, 1, 0, 0}; //up, down, left, right
        int[] dy = {0, 0, -1, 1}; // ditto
        for(int i = 0; i < 4; i++) {
            int u = cell.x + dx[i];
            int v = cell.y + dy[i];
            if(0 <= u && u < m && 0 <= v && v < n) {
                if(!visited[u][v] && grid[u][v] == '1') {
                    dfs(new Cell(u, v), grid);
                }
            }
        }
    }
}


// Union-Find
class Solution {
    private int[] parents;
    private int[] size;
    private int count;
    private int m, n;
    
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)  {
            return 0;
        }
        
        m = grid.length;
        n = grid[0].length;
        parents = new int[m*n];
        size = new int[m*n];
        count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    parents[i*n + j] = i*n + j;
                    size[i * n + j] = 1;
                }
            }
        }

        
        int[] dx = {-1, 1, 0, 0}; // up,down,left,right
        int[] dy = {0, 0, -1, 1};
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    for(int k = 0; k < 4; k++) {
                        int ux = i + dx[k];
                        int uy = j + dy[k];
                        if(0 <= ux && ux < m && 0 <= uy && uy < n && grid[ux][uy] == '1') {
                            union(i * n + j, ux * n + uy);
                        }
                    }
                }
            }
        }
        return count;
    }
    
    
    public int find(int p) {
        int root = p;
        while(root != parents[root]) {
            root = parents[root];
        }
        while(p != root) {
            int newp = parents[p];
            parents[p] = root;
            p = newp;
        }
        return root;
    }
    
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        
        if(rootP == rootQ) {
            return;
        }
        
        if(size[rootP] > rootQ) {
            parents[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parents[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        count--;
    }
    
}
