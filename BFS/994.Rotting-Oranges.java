/*
https://leetcode.com/problems/rotting-oranges/
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
    int numFresh;
    int[] dx = {-1, 1, 0, 0}; // up, down, left, right
    int[] dy = {0, 0, -1, 1};
    
    public int orangesRotting(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        numFresh = 0;
        List<Point> rotten = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    numFresh++;
                }
                if(grid[i][j] == 2) {
                    rotten.add(new Point(i, j));
                }
            }
        }
        if(numFresh == 0) {
            return 0;
        }
        int minMinutes = BFS(rotten, grid);
        if(numFresh != 0) {
            return -1;
        }
        return minMinutes;
    }
    
    
    private int BFS(List<Point> rotten, int[][] grid) {
        Queue<Point> queue = new LinkedList<>();
        for(Point p : rotten) {
            queue.add(p);
        }
        int minMinutes = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int j = 0; j < size; j++) {
                Point curr = queue.remove();
                for(int i = 0; i < 4; i++) {
                    int ux = curr.x + dx[i];
                    int uy = curr.y + dy[i];
                    if(0 <= ux && ux < m && 0 <= uy && uy < n && grid[ux][uy] == 1) {
                        grid[ux][uy] = 2;
                        numFresh--;
                        Point newPoint = new Point(ux, uy);
                        queue.add(newPoint);
                        
                    }
                }
            }
            minMinutes++;
            if(numFresh == 0) {
                break;
            }
        }
        return minMinutes;
    }
    
}
