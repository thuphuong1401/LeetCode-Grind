/*
https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/
*/


/*
Idea: the set of minimum number of vertices from which every node in the graph can be reached = set of vertices having 0 indegree
- Vertices having 0 indegree must be in the set since they are the only way to reach themselves 
- Vertices having > 0 indegree are reachable from another vertices.  
*/
class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> answer = new ArrayList<>();
        int[] indegree = new int[n];
        for(int i = 0; i < edges.size(); i++) {
            indegree[edges.get(i).get(1)]++;
        }
        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) {
                answer.add(i);
            }
        }
        return answer;
    }
}
