/*
https://leetcode.com/problems/k-closest-points-to-origin/
*/

class Point implements Comparable<Point> {
    int x; 
    int y;
    Double dist;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        this.dist = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }
    
    @Override 
    public int compareTo(Point p) {
        return this.dist.compareTo(p.dist);
    }
    
}

class Solution {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        for(int i = 0; i < points.length; i++) {
            pq.add(new Point(points[i][0], points[i][1]));
        }
        int[][] ans = new int[K][2];
        for(int i = 0; i < K; i++) {
            Point closest = pq.remove();
            ans[i][0] = closest.x;
            ans[i][1] = closest.y;
        }
        return ans;
    }
}
