/*
https://leetcode.com/problems/number-of-provinces/
This problem was named "Friend Circles" at first
*/

/*
My implementation using Union-Find.
The problem basically asks us to calculate the number of components. In the matrix (just iterate through either lower/upper half), 
connect i and j if M[i][j] == 1.
*/
class Solution {
    
    int[] parent;
    int[] size;
    int numComponents;
    
    public int findCircleNum(int[][] M) {
        int n = M.length;
        
        parent = new int[n];
        size = new int[n];
        
        for(int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        
        numComponents = n;
        
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                if(M[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        
        return numComponents;
    }
    
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP == rootQ) {
            return;
        }
        if(size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
        numComponents--;
    }
    
    public int find(int p) {
        int root = p;
        // traverse till you meet a self-loop 
        while(root != parent[root]) {
            root = parent[root];
        }
        // path compression
        while(p != root) {
            int newp = parent[p];
            parent[p] = root;
            p = newp;
        }
        return root;
    }
}



/*
DFS approach - Find the number of connected components in a graph
// DFS solution: DFS from every cell of M if it's not visited
// Since this matrix is symmetrical, we can use a 1D visited array. Else we need to use a 2D array
*/
class Solution {
    boolean[] visited;
    
    public int findCircleNum(int[][] M) {
        int n = M.length;
        visited = new boolean[n];
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(M, i);
                count++;
            }
         }
        return count;
    }
    
    public void dfs(int[][] M, int i) {
        int n = M.length;
        for(int j = 0; j < n; j++) {
            if(!visited[j] && M[i][j] == 1) {
                visited[j] = true;
                dfs(M, j);
            }
        }
    }
}


// BFS approach
class Solution {
    boolean[] visited;
    int n;
    
    public int findCircleNum(int[][] M) {
        int count = 0;
        n = M.length;
        visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                BFS(M, i);
                count++;
            }    
        }
        return count;
    }
    
    public void BFS(int[][] M, int i) {
        Queue<Integer> queue = new LinkedList<>();
        visited[i] = true;
        queue.add(i);
        while(!queue.isEmpty()) {
            int top = queue.remove();
            for(int j = 0; j < n; j++) {
                if(M[top][j] == 1 && !visited[j]) {
                    visited[j] = true;
                    queue.add(j);
                }
            }
        }
    }
    
}

