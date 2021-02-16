/*
https://leetcode.com/problems/graph-valid-tree/
*/

/*
n : number of nodes in the graph
Time: O(n * alpha(n)) where alpha(n) is the inverse Ackerman function (approximately O(1))
  - Call union() on roughly n nodes => call find() on roughly n nodes
  - Each find() operation takes alpha() time 
Space: O(n) (for parents and size array in DSU)
*/
class Solution {
    public boolean validTree(int n, int[][] edges) {
        int numEdges = edges.length;
        if(numEdges != n-1) {
            return false;
        }
        
        DSU dsu = new DSU(n);
        for(int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            if(dsu.find(start) == dsu.find(end)) {
                return false; // encounter a cycle
            }
            dsu.union(start, end);
        }
        
        return true;    
    }
    
    
}


class DSU {
    int[] parents;
    int[] size;
    
    public DSU(int n) {
        this.parents = new int[n];
        this.size = new int[n];
        
        for(int i = 0; i < n; i++) {
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
        
        if(size[rootP] >= size[rootQ]) {
            parents[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parents[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
    
    }
    
}
