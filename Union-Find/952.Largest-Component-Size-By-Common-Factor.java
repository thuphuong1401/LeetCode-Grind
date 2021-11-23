/*
https://leetcode.com/problems/largest-component-size-by-common-factor/
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
    
    public int largestComponentSize(int[] nums) {
        
        int l = nums.length;
        int max = nums[l - 1];
        DSU dsu = new DSU(l);
        int bound = (int)1e5;
        Map<Integer, List<Integer>> multipleOfKey = new HashMap<>();
        
         
        for(int i = 0; i < l; i++) {
            int d = 2;
            int num = nums[i];
            while(d * d <= num) {
                if(num % d == 0) {
                    while(num % d == 0) {
                        num /= d;
                    }
                    multipleOfKey.putIfAbsent(d, new ArrayList<>());
                    multipleOfKey.get(d).add(i);
                }
                d++;
            }
            if(num > 1) {
                multipleOfKey.putIfAbsent(num, new ArrayList<>());
                multipleOfKey.get(num).add(i);
            }
        }
        
        for(int key : multipleOfKey.keySet()) {
            List<Integer> curr = multipleOfKey.get(key);
            int s = curr.size();
            for(int u = 1; u < s; u++) {
                dsu.union(curr.get(u - 1), curr.get(u));
                //System.out.println(curr.get(u - 1) + " " + curr.get(u ));
            }
        }
        
        int maxSize = 1;
        
        for(int key : multipleOfKey.keySet()) {
            List<Integer> curr = multipleOfKey.get(key);
            if(curr.size() == 0) {
                continue;
            }
            int member = curr.get(0);
            int p = dsu.find(member);
            maxSize = Math.max(maxSize, dsu.size[p]);
        }
        
        return maxSize;
    }
    
    
}
