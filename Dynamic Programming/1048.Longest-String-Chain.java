/*
https://leetcode.com/problems/longest-string-chain/
*/

/*
Big idea: 
- Think of this as a graph problem, and we have to find the longest path in a DAG (done by DP on graph).
- Each word in the list corresponds to 1 vertex
- Vertices have edge iff word[i] + 1 char in a position = word[j]. In other words, word[j] deletes one character is word[i]. THIS IS AN IMPORTANT OBSERVATION
- Build graph, then DP. 
DP[i] = longest path starting from i, i is a vertex.
DP[i] = 1 (since path includes vertex i)
DP[i] = max(DP[i], longestPath(DP[u]) + 1) with u being a neighbor of i.
*/

class Solution {
    Map<String, Integer> vertices;
    Map<Integer, List<Integer>> graph;
    int[] maxPathLength;
    
    public int longestStrChain(String[] words) {
        int n = words.length;
        vertices = new HashMap<>();
        graph = new HashMap<>();
        for(int i = 0; i < n; i++) {
            vertices.put(words[i], i);
            graph.put(i, new ArrayList<>());
        }
        for(int i = 0; i < n; i++) {
            String curr = words[i];
            for(int j = 0; j < curr.length(); j++) {
                String deleteOneChar = curr.substring(0, j) + curr.substring(j+1);
                if(vertices.containsKey(deleteOneChar)) {
                    int u = vertices.get(deleteOneChar);
                    graph.get(u).add(i); // edge from short (len) word to long (len+1) word 
                }
            }
        }
        
        maxPathLength = new int[n];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            maxPathLength[i] = longestPath(i);
            max = Math.max(max, maxPathLength[i]);
        }
        return max;
    }
    
    
    private int longestPath(int v) {
        if(maxPathLength[v] > 0) {
            return maxPathLength[v];
        }
        maxPathLength[v] = 1;
        for(int u : graph.get(v)) {
            maxPathLength[v] = Math.max(maxPathLength[v], longestPath(u) + 1);
        }
        
        return maxPathLength[v];
        
    }
    
}
