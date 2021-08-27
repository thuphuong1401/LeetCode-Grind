/*
https://leetcode.com/problems/rank-transform-of-a-matrix/
*/

class UnionFind {
    
    int[] parents;
    int[] size;
    int N;
    
    public UnionFind(int n) {
        parents = new int[n];
        size = new int[n];
        Arrays.fill(size, 1);
        for(int i = 0; i < n; i++) {
            parents[i] = -1;
        }
        N = n;
    }
    
    private int find(int p) {
        int root = p;
        if(parents[p] == -1) {
            parents[p] = p;
            return p;
        }
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
        if(rootP == rootQ) {
            return;
        }   
        // make smaller component point to larger one
        if(size[rootP] < size[rootQ]) {
            parents[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            parents[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
    }
    
    public Map<Integer, List<Integer>> group() {
        Map<Integer, List<Integer>> res = new HashMap<>();
        for(int i = 0; i < N; i++) {
            if(parents[i] == -1) {
                continue;
            }
            int p = find(i);
            if(!res.containsKey(p)) {
                res.put(p, new ArrayList<>());
            }
            res.get(p).add(i);
        }
        return res;
    }
    
}

class Solution {
    public int[][] matrixRankTransform(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int curr = matrix[i][j];
                if(!map.containsKey(curr)) {
                    map.put(curr, new ArrayList<>());
                }
                map.get(curr).add(new int[]{i, j});
            }
        }
        
        
        int[] maxRank = new int[m+n];
        int[][] res = new int[m][n];
        
        for(int val : map.keySet()) {
            UnionFind uf = new UnionFind(m+n);
            for(int[] pos : map.get(val)) {
                int x = pos[0];
                int y = m + pos[1];
                uf.union(x, y);
            }
            
            Map<Integer, List<Integer>> groups = uf.group();
            
            for(int key : groups.keySet()) {
                int max = 0;
                for(int child : groups.get(key)) {
                    max = Math.max(max, maxRank[child]);
                }
                for(int child : groups.get(key)) {
                    maxRank[child] = max + 1;
                }
            }    
            
            for(int[] pos : map.get(val)) {
                res[pos[0]][pos[1]] = maxRank[pos[0]];
            }   
            
        }
        
        return res;
    }
    
    
}


