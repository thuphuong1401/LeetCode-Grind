/*
https://leetcode.com/problems/as-far-from-land-as-possible/
*/
class Point {
    int x;
    int y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int[] dx = {-1, 1, 0, 0}; // up, down, left, right
        int[] dy = {0, 0, -1, 1};
        boolean[][] visited = new boolean[n][n];
        Queue<Point> queue = new LinkedList<>();
        boolean hasLand = false;
        boolean hasWater = false;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    queue.add(new Point(i, j));
                    visited[i][j] = true;
                    hasLand = true;
                } else {
                    hasWater = true;
                }
            }
        }
        
        int level = -1;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Point curr = queue.remove();
                for(int j = 0; j < 4; j++) {
                    int ux = curr.x + dx[j];
                    int uy = curr.y + dy[j];
                    if(0 <= ux && ux < n && 0 <= uy && uy < n && !visited[ux][uy] && grid[ux][uy] == 0) {
                        visited[ux][uy] = true;
                        queue.add(new Point(ux, uy));
                    }
                }
            }
            level++;
        }
        
        if(!hasLand || !hasWater) {
            return -1;
        }
        
        return level;
    }
} 
