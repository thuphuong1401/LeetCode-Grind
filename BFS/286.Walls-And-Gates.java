/*
https://leetcode.com/problems/walls-and-gates/
Big idea: 
- BFS from all gates
- If an empty square is visited for the first time, it is guaranteed that the distance is the shortest
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
    int INF = Integer.MAX_VALUE;
    int[] dx = {-1, 1, 0, 0}; // up, down, left, right
    int[] dy = {0, 0, -1, 1};
    
    public void wallsAndGates(int[][] rooms) {
        m = rooms.length;
        n = rooms[0].length;
        List<Point> gates = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(rooms[i][j] == 0) {
                    gates.add(new Point(i, j));
                }
            }
        }
        
        Queue<Point> queue = new LinkedList<>();
        for(Point p : gates) {
            queue.add(p);
        }
        
        while(!queue.isEmpty()) {
            Point curr = queue.remove();
            for(int i = 0; i < 4; i++) {
                int ux = curr.x + dx[i];
                int uy = curr.y + dy[i];
                if(0 <= ux && ux < m && 0 <= uy && uy < n && rooms[ux][uy] == INF) {
                    rooms[ux][uy] = rooms[curr.x][curr.y] + 1;
                    queue.add(new Point(ux, uy));
                } 
            }
        }
    }
    
}
