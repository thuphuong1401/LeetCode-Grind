/*
https://leetcode.com/problems/couples-holding-hands/
 
Read discussion 2 for more details.
*/

class DSU {
    int[] parents;
    int[] size;
    int numComponents;
    
    public DSU(int n) {
        parents = new int[n];
        size = new int[n];
        numComponents = n;
        
        for(int u = 0; u < n; u++) {
            parents[u] = u;
            size[u] = 1;
        }
    }
    
    public int find(int p) {
        int u = p;
        while(u != parents[u]) {
            u = parents[u];
        }
        while(p != u) {
            int parentP = parents[p];
            parents[p] = u;
            p = parentP;
        }
        return u;
    }
    
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        
        if(rootP == rootQ) {
            return;
        }
        
        if(size[rootP] >= size[rootQ]) {
            parents[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parents[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
    }
}


class Solution {
    public int minSwapsCouples(int[] row) {
        int l = row.length;
        int n = l/2;
        Map<Integer, Integer> chairToCouch = new HashMap<>();
        for(int i = 0; i < l; i++) {
            chairToCouch.put(row[i], i/2);
        }
        
        DSU dsu = new DSU(n);
        
        for(int i = 0; i < l; i++) {
            int chair = row[i];
            int next = -1;
            if(chair % 2 == 0) {
                next = chair + 1;
            } else {
                next = chair - 1;
            }
            dsu.union(chairToCouch.get(chair), chairToCouch.get(next));
        }
        
        int minSwap = 0;
        
        for(int i = 0; i < n; i++) {
            if(i == dsu.find(i)) {
                minSwap += (dsu.size[i] - 1);
            }
        }
        
        return minSwap;
        
        
    }
}
