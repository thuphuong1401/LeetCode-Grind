/*
https://leetcode.com/problems/reconstruct-itinerary/

Big idea: find Eulerian Path. The problem guarantees that an Eulerian path exists, therefore no need to check for existence
- DFS from first vertex. At every dfs call, examine its neighbors, remove that neighbor from the adjacency list. 
- When a vertex has no more neighbors (or outgoing edges), add it to the Eulerian path list
- Reverse the list
*/
class Solution {
    
    List<String> eulerianPath;
    Map<String, PriorityQueue<String>> graph;
        
    public List<String> findItinerary(List<List<String>> tickets) {
        eulerianPath = new ArrayList<>();
        graph = new HashMap<>();
        for(List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            if(!graph.containsKey(from)) {
                graph.put(from, new PriorityQueue<>());
            }
            graph.get(from).add(to);
        }
        
        dfs("JFK");
        Collections.reverse(eulerianPath);
        return eulerianPath;
    }
    
    
    private void dfs(String vertex) {
        PriorityQueue<String> neighbors = graph.get(vertex);
        while(neighbors != null && neighbors.size() != 0) {
            String neighbor = neighbors.remove(); // different from vanilla DFS - we remove the visited vertex here
            dfs(neighbor);
        }
        eulerianPath.add(vertex);
    }
    
}
