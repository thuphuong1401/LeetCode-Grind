/*
https://leetcode.com/problems/pacific-atlantic-water-flow/
Big idea: 
- Calculate which grids will water flow TO FROM PACIFIC OCEAN
- Calculate which grids will water flow TO FROM ATLANTIC OCEAN
- Get intersection between 2 sets => water from such grids can flow from Pacific to Atlantic Ocean.
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
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int m, n;
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        
        boolean[][] visitedPacific = new boolean[m][n];
        boolean[][] visitedAtlantic = new boolean[m][n];
        
        Queue<Point> queuePacific = new LinkedList<>();
        Queue<Point> queueAtlantic = new LinkedList<>();
        
        for(int i = 0; i < n; i++) {
            visitedPacific[0][i] = true;
            visitedAtlantic[m-1][i] = true;
            queuePacific.add(new Point(0, i));
            queueAtlantic.add(new Point(m-1, i));
        }
        
        for(int i = 0; i < m; i++) {
            visitedPacific[i][0] = true;
            visitedAtlantic[i][n-1] = true;
            queuePacific.add(new Point(i, 0));
            queueAtlantic.add(new Point(i, n-1));
        }
        
        BFS(heights, queuePacific, visitedPacific);
        BFS(heights, queueAtlantic, visitedAtlantic);
        
        List<List<Integer>> answer = new ArrayList<>();
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(visitedPacific[i][j] && visitedAtlantic[i][j]) {
                    answer.add(new ArrayList<>());
                    answer.get(answer.size() - 1).add(i);
                    answer.get(answer.size() - 1).add(j);
                }
            }
        }
        
        return answer;
    }
    
    
    private void BFS(int[][] heights, Queue<Point> queue, boolean[][] visited) {
        while(!queue.isEmpty()) {
            Point top = queue.remove();
            for(int i = 0; i < 4; i++) {
                int ux = top.x + dx[i];
                int uy = top.y + dy[i];
                if(0 <= ux && ux < m && 0 <= uy && uy < n && !visited[ux][uy] && heights[ux][uy] >= heights[top.x][top.y]) {
                    visited[ux][uy] = true;
                    queue.add(new Point(ux, uy));
                }
            }
        }
    }
    
}
