/*
https://leetcode.com/problems/course-schedule/
*/


// Kahn's algorithm - BFS based
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        int[] indegree = new int[numCourses];
        Queue<Integer> zeroIndegree = new LinkedList<>();
        for(int u = 0; u < numCourses; u++) {
            for(int v : graph.get(u)) {
                indegree[v]++;
            }
        }
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                zeroIndegree.add(i);
            }
        }
        
        while(!zeroIndegree.isEmpty()) {
            int u = zeroIndegree.remove();
            for(int v : graph.get(u)) {
                indegree[v]--;
                if(indegree[v] == 0) {
                    zeroIndegree.add(v);
                }
            }
        }
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] != 0) {
                return false;
            }
        }
        return true;
    }
}


// DFS

class Solution {
    int[] visited;
    List<List<Integer>> graph;
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        graph = new ArrayList<List<Integer>>();
        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        visited = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            if(visited[i] == 0) {
                boolean x = DFS(i);
                if(x) {
                    return false; 
                }
            }
        }
        return true;
    }
    
    public boolean DFS(int s) { // has cycle => return true
        visited[s] = 1;
        for(int i = 0; i < graph.get(s).size(); i++) {
            int u = graph.get(s).get(i);
            if(visited[u] == 0) {
                if(DFS(u)) {
                    return true;
                }
            } else if(visited[u] == 1) {
                return true;
            }
        }
        visited[s] = 2;
        return false;
    }
}



/*
DFS solution
*/
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] edge : prerequisites) {
            int u = edge[0];
            int v = edge[1];
            graph.get(v).add(u);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] allChildrenVisited = new boolean[numCourses];
        for(int u = 0; u < numCourses; u++) {
            boolean ans = false;
            if(!visited[u] && !allChildrenVisited[u]) {
                ans = findCycle(u, -1, graph, visited, allChildrenVisited);    
            }
            if(ans) {
                return false;
            }
        }
        return true;
    }
    
    
    private boolean findCycle(int u, int p, List<List<Integer>> graph, boolean[] visited, boolean[] allChildrenVisited) {
        visited[u] = true;
        for(int neighbor : graph.get(u)) {
            if(!visited[neighbor]) {
                boolean ans = findCycle(neighbor, u, graph, visited, allChildrenVisited);
                if(ans) {
                    return true;
                }
            } else if(visited[neighbor] && !allChildrenVisited[neighbor]) {
                return true;
            }
        }
        allChildrenVisited[u] = true;
        return false;
    }
    
}

