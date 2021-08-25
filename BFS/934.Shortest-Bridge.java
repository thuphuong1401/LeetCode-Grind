/*
https://leetcode.com/problems/shortest-bridge/

Very nice problem, can be solved using both BFS and DFS. Big idea: 
1. Use BFS to traverse one island first.
2. Add all visited elements of that island to a queue. 
3. BFS (level order) using that queue to discover the first instance of 1.
*/

class Solution {
    
    public int shortestBridge(int[][] grid) {
        
        int n = grid.length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        boolean flag = false;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j] && grid[i][j] == 1) {
                    bfs(queue, visited, i, j, grid, dx, dy);
                    flag = true;
                    break;
                }
            }
            if(flag) {
                break;
            }
        }
        
        
        int dist = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] top = queue.remove();
                for(int j = 0; j < 4; j++) {
                    int ux = top[0] + dx[j];
                    int uy = top[1] + dy[j];
                    if(0 <= ux && ux < n && 0 <= uy && uy < n && !visited[ux][uy]) {
                        if(grid[ux][uy] == 1) {
                            return dist;
                        }
                        queue.add(new int[]{ux, uy});
                        visited[ux][uy] = true;
                    }
                }
            }
            dist++;
        }
        
        return 0;
    }
    
    
    private void bfs(Queue<int[]> queue, boolean[][] visited, int i, int j, int[][] grid, int[] dx, int[] dy) {
        visited[i][j] = true;
        int n = visited.length;
        queue.add(new int[]{i, j});
        while(!queue.isEmpty()) {
            int[] top = queue.remove();
            for(int k = 0; k < 4; k++) {
                int ux = top[0] + dx[k];
                int uy = top[1] + dy[k];
                if(0 <= ux && ux < n && 0 <= uy && uy < n && !visited[ux][uy] && grid[ux][uy] == 1) {
                    queue.add(new int[]{ux, uy});
                    visited[ux][uy] = true;
                }
            }
        }
        
        for(int k = 0; k < n; k++) {
            for(int l = 0; l < n; l++) {
                if(visited[k][l]) {
                    queue.add(new int[]{k, l});
                }
            }
        }
        
    }
    
}
