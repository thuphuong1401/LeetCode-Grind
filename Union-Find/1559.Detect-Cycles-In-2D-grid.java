/*
https://leetcode.com/problems/detect-cycles-in-2d-grid/
*/

/*
Big idea: enumerate (top, left) or (bottom, right) of a cell. If both such cells are in the same component => cycle detected!
*/

// Union-Find
class Solution {
    int n;
    int m;
    int[] parents;
    int[] size;
    
    public boolean containsCycle(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        makeSet();
        int[] dx = {0, 1}; // (bottom, right) here. (top,left) also works.
        int[] dy = {1, 0};
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < 2; k++) {
                    int ux = i + dx[k];
                    int uy = j + dy[k];
                    if(0 <= ux && ux < m && 0 <= uy && uy < n && grid[ux][uy] == grid[i][j]) {
                        int parent1 = find(ux * n + uy);
                        int parent2 = find(i * n + j);
                        if(parent1 == parent2) {
                            return true;
                        } else {
                            union(ux * n + uy, i * n + j);
                        }
                    }
                }
            }
        }
        return false;
    }
    
    public void makeSet() {
        parents = new int[m*n];
        size = new int[m*n];
        for(int i = 0; i < m*n; i++) {
            parents[i] = i;
            size[i] = 1;
        }
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
        if(size[rootP] > size[rootQ]) {
            parents[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parents[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
    }
    
    
}
