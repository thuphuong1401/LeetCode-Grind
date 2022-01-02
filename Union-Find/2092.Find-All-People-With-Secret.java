/*
https://leetcode.com/problems/find-all-people-with-secret/
*/

class DSU {
    int[] parents;
    int[] size;
    int numComponents;
    
    public DSU (int n) {
        parents = new int[n];
        size = new int[n];
        numComponents = n;
        
        for(int u = 0; u < n; u++) {
            parents[u] = u;
            size[u] = 1;
        }
    }
    
    public int find (int p) {
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
    
    public void union (int p, int q) {
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
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, (m1, m2) -> Integer.compare(m1[2], m2[2]));
        int m = meetings.length;
        int i = 0;
        Set<Integer> secret = new HashSet<>();
        secret.add(0);
        secret.add(firstPerson);
        
        while(i < m) {
            
            int[] curr = meetings[i];
            int currTime = curr[2];
            Map<Integer, Integer> compress = new HashMap<>(); // number compression
            Map<Integer, Integer> decompress = new HashMap<>();
            int j = 0; // compressed index
            int k = i;
            
            while(currTime == curr[2]) {
                currTime = curr[2];
                int xi = curr[0];
                int yi = curr[1];
                if(!compress.containsKey(xi)) {
                    compress.put(xi, j);
                    decompress.put(j, xi);
                    j++;
                }
                if(!compress.containsKey(yi)) {
                    compress.put(yi, j);
                    decompress.put(j, yi);
                    j++;
                }
                i++;
                if(i >= m) {
                    break;
                }
                curr = meetings[i];
            }
            
            DSU dsu = new DSU(j);
            
            while(k < i) {
                int[] meeting = meetings[k];
                int xi = meeting[0];
                int yi = meeting[1];
                dsu.union(compress.get(xi), compress.get(yi));
                k++;
            }
            
            
            for(int p = 0; p < j; p++) {
                if(secret.contains(decompress.get(p))) {
                    int parent = dsu.find(p);
                    parent = decompress.get(parent);
                    secret.add(parent);
                }
            }
            
            for(int p = 0; p < j; p++) {
                int parent = dsu.find(p);
                parent = decompress.getOrDefault(parent, -1);
                if(secret.contains(parent)) {
                    secret.add(decompress.get(p));
                }
            }
            
        }
        
        return new ArrayList<>(secret);
    }
}

