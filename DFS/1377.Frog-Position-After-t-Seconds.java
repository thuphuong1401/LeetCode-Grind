/*
https://leetcode.com/problems/frog-position-after-t-seconds/
*/
class Solution {
    
    int[] path;
    
    public double frogPosition(int n, int[][] edges, int t, int target) {
        /*
        Approach:
        1. Populate the int[] path array to obtain all paths in tree
        2. Calculate probability based on int[] path (currProb *= 1/numChildren in each step)
        */
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        } 
        
        path = new int[n+1];
        dfs(graph, 1, -1);
        double prob = calculateProb(graph, t, target);
        return prob;
    }
    
    
    private void dfs(List<List<Integer>> graph, int v, int p) {
        for(int child : graph.get(v)) {
            if(child != p) {
                path[child] = v;
                dfs(graph, child, v);
            }
        }    
    } 
    
    
    private double calculateProb(List<List<Integer>> graph, int t, int target) {
        if(target == 1) {
            if(t == 0 || graph.size() == 2) {
                return 1.0;
            } else {
                return 0.0;
            }
        }
        List<Integer> pathFromRootToTarget = new ArrayList<>();
        int curr = target;
        // add all vertices between root to target into a list (endpoints excluded)
        while(path[curr] != 1) {
            curr = path[curr];
            pathFromRootToTarget.add(curr);
        }
        /*
        Prob = 0 iff:
        - path too long, cannot be reached within time t
        - t is too big and target is not a leaf, hence the frog cannot jump in place till time ends
        */
        int len = pathFromRootToTarget.size();
        if(len < t - 1 && !isLeaf(graph, target)) {
            return 0.0;
        } else if(len > t - 1) {
            return 0.0;
        }
        double prob = 1.0;
        for(int i = len - 1; i >= 0; i--) {
            int v = pathFromRootToTarget.get(i);
            prob *= 1.0 / (double)(graph.get(v).size() - 1);
        }
        prob *= 1.0 / (double)(graph.get(1).size());
        return prob;
    }
    
    private boolean isLeaf(List<List<Integer>> graph, int v) {
        int numChildren = graph.get(v).size();
        if(numChildren == 1) {
            return true;
        } 
        return false;
    }
    
    
}
