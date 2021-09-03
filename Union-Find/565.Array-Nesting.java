/*
https://leetcode.com/problems/array-nesting/

Formulate the problem as finding the largest component in a graph problem.
"Edges" between (i, nums[i])
*/

class DSU {
    
    int N;
    int[] parents;
    int[] size;
    
    public DSU(int n) {
        N = n;
        parents = new int[N];
        for(int i = 0; i < N; i++) {
            parents[i] = i;
        }
        size = new int[N];
        Arrays.fill(size, 1);
    }
    
    
    public int find(int p) {
        int root = p;
        while(root != parents[root]) {
            root = parents[root];
        }
        while(p != root) {
            int newP = parents[p];
            parents[p] = root;
            p = newP;
        }
        return root;
    }
    
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        
        if(rootP != rootQ) {
            if(size[rootP] >= size[rootQ]) {
                parents[rootQ] = rootP;
                size[rootP] += size[rootQ];
            } else {
                parents[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
        }
    }
    
    
}

class Solution {
    public int arrayNesting(int[] nums) {
        int n = nums.length;
        DSU dsu = new DSU(n);
        
        for(int i = 0; i < n; i++) {
            dsu.union(i, nums[i]);
        }
        
        int maxSize = -1;
        for(int i = 0; i < n; i++) {
            maxSize = Math.max(maxSize, dsu.size[i]);
        }
        
        return maxSize;
    }
}
