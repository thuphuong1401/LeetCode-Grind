/*
https://leetcode.com/problems/is-graph-bipartite/
*/

/*
My implementation using BFS - BFS from every unvisited node and use an extra visited array
*/
// Idea: check whether graph is 2-colorable
class Solution {
    int n;
    boolean[] visited;
    int[] color; // -1: no color, 0: black, 1:white
    
    public boolean isBipartite(int[][] graph) {
        n = graph.length;
        if(n == 1) {
            return true;
        }
        visited = new boolean[n];
        color = new int[n];
        Arrays.fill(color, -1);
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                if(!BFS(i, graph)) {
                    return false;
                }
            }
        }
        return true;
    }
        
        
    public boolean BFS(int s, int[][] graph) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        color[s] = 0;
        while(!queue.isEmpty()) {
            int top = queue.remove();
            visited[top] = true;
            for(int i = 0; i < graph[top].length; i++) { // enumerate all vertices adjacent to vertex top
                int neighbor = graph[top][i];

                // if neighbor already been colored
                if(color[neighbor] != -1) {
                    if(color[neighbor] == color[top]) {
                        return false;
                    } else {
                        if(!visited[neighbor]) {
                            queue.add(neighbor);
                        }
                    }
                } else {
                    // set color
                    if(color[top] == 0) {
                        color[neighbor] = 1;
                    } else {
                        color[neighbor] = 0;
                    }
                    if(!visited[neighbor]) {
                        queue.add(neighbor);
                    }
                }
            }
        }
        return true;
    }
}






/* 
BFS - cleaner - use visited array to color 0, 1, 2
*/
class Solution {
    int[] visited; // 0: not visited, 1: black, 2: white
    
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        visited = new int[n];
        for(int i = 0; i < n; i++) {
            if(graph[i].length != 0 && visited[i] == 0) {
                boolean x = BFS(i, graph);
                if(!x) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean BFS(int s, int[][] graph) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = 1;
        while(!queue.isEmpty()) {
            int top = queue.remove();
            for(int i = 0; i < graph[top].length; i++) {
                int neighbor = graph[top][i];
                if(visited[neighbor] == 0) {
                    visited[neighbor] = (visited[top] == 1)? 2 : 1;
                    queue.add(neighbor);
                } else {
                    if(visited[neighbor] == visited[top]) {
                        return false;
                    }
                }
            }
        }
        
        return true;   
    }   
}




/*
Union-Find:
Idea: 
for(int i = 0; i < graph.length; i++) {
  for(int j = 0; j < graph[i].length; j++) {
    if(find(i) == find(j)) {
      return false; // since 2 adjacent vertices can't be in the same set
    }
    union(graph[i][0], graph[i][j); // union all children of a vertex to a set
  }
}

*/

