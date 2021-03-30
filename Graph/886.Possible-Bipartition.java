/*
https://leetcode.com/problems/possible-bipartition/
*/

// BFS solution
class Solution {
    boolean[] visited;
    boolean[] color;
    
    public boolean possibleBipartition(int N, int[][] dislikes) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] edge : dislikes) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        visited = new boolean[N+1];
        color = new boolean[N+1];
        for(int v = 1; v <= N; v++) {   
            if(!visited[v]) {
                boolean twoColorable = BFS(N, graph, v);
                if(!twoColorable) {
                    return false;
                }
            }
        }
        return true;
    }
    
    
    private boolean BFS(int N, List<List<Integer>> graph, int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        color[s] = true;
        while(!queue.isEmpty()) {
            int top = queue.remove();
            boolean topColor = color[top];
            for(int i = 0; i < graph.get(top).size(); i++) {
                int neighbor = graph.get(top).get(i);
                if(!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                    if(topColor == true) {
                        color[neighbor] = false;
                    } else {
                        color[neighbor] = true;
                    }
                } else {
                    if(color[neighbor] == topColor) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}




// DFS solution
class Solution {
    boolean[] visited;
    boolean[] color;
    
    public boolean possibleBipartition(int N, int[][] dislikes) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] edge : dislikes) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        visited = new boolean[N+1];
        color = new boolean[N+1];
        for(int v = 1; v <= N; v++) {   
            if(!visited[v]) {
                color[v] = true;
                boolean twoColorable = DFS(graph, v);
                if(!twoColorable) {
                    return false;
                }
            }
        }
        return true;
    }
    
    
    private boolean DFS(List<List<Integer>> graph, int v) {
        visited[v] = true;
        for(int i = 0; i < graph.get(v).size(); i++) {
            int neighbor = graph.get(v).get(i);
            if(!visited[neighbor]) {
                color[neighbor] = !color[v];
                DFS(graph, neighbor);
            } else {
                if(color[neighbor] == color[v]) {
                    return false;
                }
            }
        }
        return true;
    }
}
