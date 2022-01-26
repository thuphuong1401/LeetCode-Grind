/*
https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/
*/
class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(new int[]{0, 0, k});
        visited.add("0 0 " + k);
        int level = 0;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] topNode = queue.remove();
                int x = topNode[0];
                int y = topNode[1];
                int r = topNode[2];
                if(x == m-1 && y == n-1) {
                    return level;
                }
                for(int j = 0; j < 4; j++) {
                    int ux = x + dx[j];
                    int uy = y + dy[j];
                    String state = ux + " " + uy + " " + r;
                    String eliminateState = ux + " " + uy + " " + (r - 1);
                    if(0 <= ux && ux < m && 0 <= uy && uy < n) {
                        if(!visited.contains(state) && grid[ux][uy] == 0) {
                            visited.add(state);
                            queue.add(new int[]{ux, uy, r});
                        } else if (!visited.contains(eliminateState) && grid[ux][uy] == 1 && r > 0) {
                            visited.add(eliminateState);
                            queue.add(new int[]{ux, uy, r - 1});
                        }
                    }
                }
            }
            level++;
        }
        return -1;
    }
}

