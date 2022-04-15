/*
https://leetcode.com/problems/swim-in-rising-water/
*/

class Square implements Comparable<Square> {
    int x;
    int y;
    int level;
    
    public Square(int x, int y, int level) {
        this.x = x;
        this.y = y;
        this.level = level;
    }
    
    public int compareTo(Square other) {
        return this.level - other.level;
    }
}

class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<Square> pq = new PriorityQueue<>(); // min heap
        boolean[][] visited = new boolean[n][n];
        pq.add(new Square(0, 0, grid[0][0]));
        visited[0][0] = true;
        int minTime = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while(!pq.isEmpty()) {
            Square top = pq.remove();
            int x = top.x;
            int y = top.y;
            int level = top.level;
            
            minTime = Math.max(minTime, level);
            
            if(x == n - 1 && y == n - 1) {
                break;
            }
            
            for(int i = 0; i < 4; i++) {
                int ux = x + dx[i];
                int uy = y + dy[i];
                if(0 <= ux && ux < n && 0 <= uy && uy < n && !visited[ux][uy]) {
                    pq.add(new Square(ux, uy, grid[ux][uy]));
                    visited[ux][uy] = true;
                }
            }
        }
        
        return minTime;
    }
}

