/*
https://leetcode.com/problems/tree-diameter/

Big idea: DFS twice
- DFS first time from a random vertex to its furthest leaf
- DFS second time from such leaf to another furthest leaf
*/
class Solution {

    public int treeDiameter(int[][] edges) {
        int n = edges.length + 1;
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
        
        int[] dist = new int[n];
        dfs(0, -1, graph, dist);
        int[] res1 = findFurthestVertex(dist);
        
        dist = new int[n];
        dfs(res1[0], -1, graph, dist);
        int[] res2 = findFurthestVertex(dist);
        
        int diameter = res2[1];
        return diameter;
    }
    
    
    private int[] findFurthestVertex(int[] dist) {
        int maxDist = -1;
        int furthestVertex = -1;
        for(int u = 0; u < dist.length; u++) {
            if(dist[u] > maxDist) {
                maxDist = dist[u];
                furthestVertex = u;
            }
        }
        int[] res = new int[]{furthestVertex, maxDist};
        return res;
    }
    
    private void dfs(int u, int p, List<List<Integer>> graph, int[] dist) {
        for(int child : graph.get(u)) {
            if(child != p) {
                dist[child] = dist[u] + 1;
                dfs(child, u, graph, dist);
            }
        }
    }
    
    
}
