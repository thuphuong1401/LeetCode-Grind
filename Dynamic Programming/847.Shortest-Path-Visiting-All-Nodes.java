/*
https://leetcode.com/problems/shortest-path-visiting-all-nodes/
*/

/*
Estimated time complexity: O(shortestPathLength * N)
Another option: O(N * 2^N)
Space: O(2^N)
*/

class State {
    int u;
    int state;
    
    public State(int u, int state) {
        this.u = u;
        this.state = state;
    }
}

class Solution {
    public int shortestPathLength(int[][] graph) {
        int N = graph.length;
        Queue<State> queue = new LinkedList<>();
        Set<Integer>[] visited = new HashSet[N];
        
        int allVisitedMask = 0;
        
        for(int u = 0; u < N; u++) {
            int initialState = (1 << u);
            visited[u] = new HashSet<>();
            visited[u].add(u);
            queue.add(new State(u, initialState));
            allVisitedMask |= initialState;
        }
        
        // allVisitedMask = (1 << N) - 1;
    
        int minPathLength = 0;
                
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                State top = queue.remove();
                if(top.state == allVisitedMask) {
                    return minPathLength;
                }
                for(int neighbor : graph[top.u]) {
                    int bitMask = (1 << neighbor) | top.state;
                    if(!visited[neighbor].contains(bitMask)) {
                        visited[neighbor].add(bitMask);
                        queue.add(new State(neighbor, bitMask));
                    }
                }
            }
            minPathLength++;
        }
        
        return -1; // never reached since graph is connected
    }
}
