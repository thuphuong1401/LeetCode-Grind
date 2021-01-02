/*
https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
*/

// It's 02:30am, I'm coding Union-Find, what am I doing with my life?
class Solution {
    
    private int[] parents;
    private int[] size;
    private int count;
    
    public int countComponents(int n, int[][] edges) {
        parents = new int[n];
        size = new int[n];
        count = n;
        for(int i = 0; i < n; i++) {
            parents[i] = i;
            size[i] = 1;
        }
        
        for(int i = 0; i < edges.length; i++) {
            union(edges[i][0], edges[i][1]);
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
        if(size[rootP] > size[rootQ]) {
            parents[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parents[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        
        count--;
    }
    
}
