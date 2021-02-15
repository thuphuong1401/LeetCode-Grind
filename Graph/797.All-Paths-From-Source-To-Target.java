/*
https://leetcode.com/problems/all-paths-from-source-to-target/
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
                visited[neighbor] = false;
                currList.remove(currList.size() - 1);
            }
        }   
    }
}
