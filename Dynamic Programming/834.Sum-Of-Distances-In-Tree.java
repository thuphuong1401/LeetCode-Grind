/*
https://leetcode.com/problems/sum-of-distances-in-tree/
A very very nice and classic DP on tree problem
See LeetCode official solution if stuck
*/
class Solution {
    
    int[] sumDistRootedAtZero;
    int[] subtreeSize;
    int[] ans;
    int N;
    
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        N = n;
        ans = new int[n];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());    
        }
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        sumDistRootedAtZero = new int[n+1];
        subtreeSize = new int[n+1];
        calculate(graph, 0, -1);
        
        ans[0] = sumDistRootedAtZero[0];
        
        solve(graph, 0, -1);
        
        return ans;
    }
    
    // calculate sum of distances from root (0) to all other nodes
    private void calculate(List<List<Integer>> graph, int curr, int parent) {
        subtreeSize[curr] = 1;
        for(int child : graph.get(curr)) {
            if(child != parent) {
                calculate(graph, child, curr);
                subtreeSize[curr] += subtreeSize[child];
                sumDistRootedAtZero[curr] += (sumDistRootedAtZero[child] + subtreeSize[child]);
            }
        }
    }
    
    private void solve(List<List<Integer>> graph, int curr, int parent) {
        for(int child : graph.get(curr)) {
            if(child != parent) { 
                ans[child] = ans[curr] - subtreeSize[child]  + (N - subtreeSize[child]);
                solve(graph, child, curr);
            }
        }
    }
    
}
