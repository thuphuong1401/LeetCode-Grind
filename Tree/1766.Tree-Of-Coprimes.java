/*
https://leetcode.com/problems/tree-of-coprimes/
*/

class Solution {
    
    int n;
    int[] ans;
    
    public int[] getCoprimes(int[] nums, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        n = nums.length;
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        ans = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        int[] levels = new int[n];
        dfs(0, -1, graph, map, nums, levels, 0);
        
        return ans;
    }
    
    
    // pathSoFar: (value, vertex index)
    private void dfs(int v, int p, List<List<Integer>> graph, Map<Integer, Integer> pathSoFar, int[] nums, int[] levels, int currLevel) {
        
        int val = nums[v];
        boolean hasCoprimeAncestor = false;
        int minLevel = Integer.MIN_VALUE;
        for(int div = 1; div <= 50; div++) {
            if(gcd(val, div) == 1 && pathSoFar.containsKey(div) && levels[pathSoFar.get(div)] > minLevel) {
                ans[v] = pathSoFar.get(div);
                hasCoprimeAncestor = true;
                minLevel = levels[pathSoFar.get(div)];
            }
        }
        
        if(!hasCoprimeAncestor) {
            ans[v] = -1;
        }
        
        Integer oldVal = pathSoFar.get(nums[v]);
        pathSoFar.put(nums[v], v);
        levels[v] = currLevel;
        
        for(int child : graph.get(v)) {
            if(child != p) {
                dfs(child, v, graph, pathSoFar, nums, levels, currLevel + 1);
            }
        }
        
        pathSoFar.remove(nums[v], v);
        if(oldVal != null) {
            pathSoFar.put(nums[v], oldVal);
        }
    }
    
    
    private int gcd(int a, int b) {
        if(a == b) {
            return a;
        }
        
        if(a > b) {
            return gcd(a - b, b);
        } else {
            return gcd(a, b - a);
        }
    }
    
    
}
