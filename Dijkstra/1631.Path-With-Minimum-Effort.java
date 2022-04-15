/*
https://leetcode.com/problems/path-with-minimum-effort/

Use Dijkstra, but dist = min effort required to go from (0, 0)  to (i, j)
*/
class Square implements Comparable<Square> {
    int x;
    int y;
    int absDiff;
    
    public Square(int x, int y, int absDiff) {
        this.x = x;
        this.y = y;
        this.absDiff = absDiff;
    }
    
    public int compareTo(Square other) {
        return this.absDiff - other.absDiff;
    }
}

class Solution {
    public int minimumEffortPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        PriorityQueue<Square> pq = new PriorityQueue<>(); // min heap
        pq.add(new Square(0, 0, 0));
        int[][] dist = new int[n][m]; // min effort required to go from (0, 0) to (i. j)
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        
        dist[0][0] = 0;
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        while(!pq.isEmpty()) {
            Square top = pq.remove();
            int x = top.x;
            int y = top.y;
            int absDiff = top.absDiff;
            
            for(int i = 0; i < 4; i++) {
                int ux = x + dx[i];
                int uy = y + dy[i];
                if(0 <= ux && ux < n && 0 <= uy && uy < m) {
                    int currAbsDiff = Math.abs(grid[ux][uy] - grid[x][y]);
                    int newDist = Math.max(dist[x][y], currAbsDiff);
                    if(newDist < dist[ux][uy]) {
                        dist[ux][uy] = newDist;
                        pq.add(new Square(ux, uy, dist[ux][uy]));
                    }
                }
            }
        }
        
        return dist[n - 1][m - 1];
    }
}
