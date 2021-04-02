/*
https://leetcode.com/problems/shortest-distance-from-all-buildings/
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
    int m, n;
    boolean[][] visited;
    int[][] dist;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int[][] reachable;
    
    public int shortestDistance(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        
        List<Point> buildings = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    buildings.add(new Point(i, j));
                    
                }
            }
        }
        
        dist = new int[m][n];
        reachable = new int[m][n];
        
        for(Point p : buildings) {
            visited = new boolean[m][n];
            BFS(p, grid);
        }
        
        int minDist = Integer.MAX_VALUE;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0 && visited[i][j] && reachable[i][j] == buildings.size()) {
                    minDist = Math.min(minDist, dist[i][j]);        
                }
            }
        }
        
        if(minDist == Integer.MAX_VALUE) {
            return -1;
        }
        return minDist;
    }
    
    
    private void BFS(Point p, int[][] grid) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(p);
        visited[p.x][p.y] = true;
        int level = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int j = 0; j < size; j++) {
                Point top = queue.remove();
                for(int i = 0; i < 4; i++) {
                    int ux = top.x + dx[i];
                    int uy = top.y + dy[i];
                    if(0 <= ux && ux < m && 0 <= uy && uy < n && !visited[ux][uy] && grid[ux][uy] == 0) {
                        visited[ux][uy] = true;
                        dist[ux][uy] += level;
                        reachable[ux][uy]++;
                        Point neighbor = new Point(ux, uy);
                        queue.add(neighbor);
                    }
                }
            }
            level++;
        }   
    }
}
