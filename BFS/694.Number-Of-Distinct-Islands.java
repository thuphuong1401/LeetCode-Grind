/*
https://leetcode.com/problems/number-of-distinct-islands/
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
    boolean[][] visited;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int m;
    int n;
    
    public int numDistinctIslands(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        Set<String> numIsland = new HashSet<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j] && grid[i][j] == 1) {
                    List<Point> island = BFS(grid, new Point(i, j));
                    String globalCoord = translateToGlobalCoord(island);
                    numIsland.add(globalCoord);
                }
            }
        }
        System.out.println(numIsland);
        return numIsland.size();
    }
    
    private List<Point> BFS(int[][] grid, Point source) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(source);
        List<Point> shape = new ArrayList<>();
        visited[source.x][source.y] = true;
        while(!queue.isEmpty()) {
            Point top = queue.remove();
            int x = top.x;
            int y = top.y;
            shape.add(new Point(x, y));
            for(int i = 0; i < 4; i++) {
                int ux = x + dx[i];
                int uy = y + dy[i];
                if(0 <= ux && ux < m && 0 <= uy && uy < n && !visited[ux][uy] && grid[ux][uy] == 1) {
                    visited[ux][uy] = true;
                    queue.add(new Point(ux, uy));
                }
            }
        }
        return shape;
    }
    
    
    private String translateToGlobalCoord(List<Point> island) {
        
        Point start = island.get(0);
        int offsetX = start.x;
        int offsetY = start.y;
        StringBuilder sb = new StringBuilder();
        for(Point p : island) {
            int x = p.x - offsetX;
            int y = p.y - offsetY;
            String newCoord = "(" + x + "," + y + ")";
            sb.append(newCoord);
        }
        return sb.toString();
    }
    
}
