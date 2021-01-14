/*
https://leetcode.com/problems/course-schedule-ii/
*/


/* 
Topo sort based on DFS method
Big Idea: 
- DFS from all unvisited vertices
- If DFS found cycles => return no topo order can be found. Else, after finish visiting all children of a node, add such node into the topo order list
- Reverse the list and return
*/
class Solution {
    List<List<Integer>> graph;
    int[] visited;
    List<Integer> result;
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        graph = new ArrayList<List<Integer>>();
        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);    
        }
        visited = new int[numCourses];
        result = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            if(visited[i] == 0) {
                boolean x = DFS(i);
                if(x) { // contains cycle, hence can't get topo order
                    return new int[0];
                }
            }
        }
        Collections.reverse(result);
        
        int[] res = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            res[i] = result.get(i);
        }
        return res; 
    }
    
    
    public boolean DFS(int s) { // true: cycle, false: no cycle
        visited[s] = 1;
        for(int i = 0; i < graph.get(s).size(); i++) {
            int neighbor = graph.get(s).get(i);
            if(visited[neighbor] == 0) {
                boolean x = DFS(neighbor);
                if(x) {
                    return true;
                }
            } else if(visited[neighbor] == 1) {
                return true;
            }
        }
        visited[s] = 2;
        result.add(s);
        return false;
    }   
}



/*
Kahn's algorithm
Idea: take out all vertices without dependencies (indegree = 0) off the graph. 
Process:
- Queue up all vertices with 0 indegree
- Remove a vertex from the queue, reduce the indegree of its adjacent vertices
- In the end, if all indegree = 0 => true; else => no topo order found
*/
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        // Kahn's algorithm
        int[] topoOrder = new int[numCourses];
        int[] inDegree = new int[numCourses];
        for(int i = 0; i < prerequisites.length; i++) {
            int target = prerequisites[i][0];
            inDegree[target]++;
        }
        
        Queue<Integer> zeroIndegree = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(inDegree[i] == 0) {
                zeroIndegree.add(i);
            }
        }
        
        int index = 0;
        while(!zeroIndegree.isEmpty()) {
            int u = zeroIndegree.remove();
            topoOrder[index] = u;
            index++;
            for(int i = 0; i < graph.get(u).size(); i++) {
                int v = graph.get(u).get(i);
                inDegree[v]--;
                if(inDegree[v] == 0) {
                    zeroIndegree.add(v);
                }
            }
        }
        
        for(int i = 0; i < numCourses; i++) {
            if(inDegree[i] != 0) {
                return new int[0];
            }
        }
        
        return topoOrder;
        
    }
}
