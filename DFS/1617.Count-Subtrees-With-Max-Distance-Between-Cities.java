/*

https://leetcode.com/problems/count-subtrees-with-max-distance-between-cities/

Idea: 
- n small => brute force is OK
- List all subsets using mask
- Check whether each subset is connected via dfs. If connected, find diameter of subset.
*/
class Solution {
    
    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        int[] res = new int[n - 1];
        
        for(int mask = 1; mask < (int)Math.pow(2, n); mask++) {
            int tempMask = mask;
            int index = 0;
            List<Integer> subtree = new ArrayList<>();
            Set<Integer> set = new HashSet<>();
            while(tempMask != 0) {
                if((tempMask & 1) != 0) {
                    subtree.add(index);
                    set.add(index);
                }
                index++;
                tempMask >>= 1;
                
            }
            int[] dist = new int[n];
            Arrays.fill(dist, -1);
            dist[subtree.get(0)] = 0;
            dfs(subtree.get(0), -1, set, graph, dist);
            
            boolean connected = true;
            
            // check for connectedness of subtree
            for(int v : subtree) {
                if(dist[v] == -1) {
                    connected = false;
                    break;
                }    
            }
            
            if(!connected) {
                continue;
            }
            
            int d = treeDiameter(set, graph, dist);
            if(d == 0) {
                continue;
            }
            res[d - 1]++;
        }
        
        return res;
    }
    
    
    public int treeDiameter(Set<Integer> set, List<List<Integer>> graph, int[] dist) {
        int n = dist.length;
        int[] res1 = findFurthestVertex(dist);
        
        dist = new int[n];
        dfs(res1[0], -1, set, graph, dist);
        
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
    
    private void dfs(int u, int p, Set<Integer> subtree, List<List<Integer>> graph, int[] dist) {
        for(int child : graph.get(u)) {
            if(child != p && subtree.contains(child)) {
                dist[child] = dist[u] + 1;
                dfs(child, u, subtree, graph, dist);
            }
        }
    }
    
    
}
