/*
https://leetcode.com/problems/all-paths-from-source-to-target/
*/

/*
n : number of nodes in the graph
Time O(2^n * n)
- There are at most 2^n - 1 paths in a graph (a node can either belong to the path from source to dest or not)
- There are at most n nodes in a path (beecase graph is acyclic)
=> Time (2^n - 1) * n

Space O(2^n * n)
- At most 2^n - 1 paths, each having n nodes => space must contains (2^n - 1) * n
- Recursion stack O(n) (because there are at most n nodes in a path) => O(n)
=> Overall space complexity O(2^n - 1) * n + O(n) = O(2^n * n)
*/
class Solution {

    List<List<Integer>> answer;
    boolean[] visited;
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        answer = new ArrayList<List<Integer>>();
        int n = graph.length;
        visited = new boolean[n];
        dfs(0, graph, n, new ArrayList<Integer>());
        return answer;
    }
    
    private void dfs(int s, int[][] graph, int n, List<Integer> currList) {
        visited[s] = true;
        currList.add(s);
        
        if(s == n-1) {
            answer.add(new ArrayList<Integer>(currList));
            return;
        }
        
        for(int i = 0; i < graph[s].length; i++) {
            int neighbor = graph[s][i];
            if(!visited[neighbor]) {
                dfs(neighbor, graph, n, currList);
                visited[neighbor] = false; // after finish dfs a node (reach the destination node n-1), we backtrack by 1. set visited[that node] = false, 
                currList.remove(currList.size() - 1); // and 2. remove that node from the current list
            }
        }   
    }
}


class Solution {
    List<List<Integer>> allPaths;
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        allPaths = new ArrayList<>();
        int n = graph.length;
        backtrack(0, graph, n, new ArrayList<>());
        return allPaths;
    }
    
    private void backtrack(int s, int[][] graph, int n, List<Integer> currPath) {   
        
        currPath.add(s);
        
        if(s == n-1) {
            allPaths.add(new ArrayList<>(currPath));
            currPath.remove(currPath.size() - 1);
            return;
        }   
        
        for(int neighbor : graph[s]) {
            backtrack(neighbor, graph, n, currPath);
        }
        
        currPath.remove(currPath.size() - 1);
    }
    
}
