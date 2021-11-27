/*
https://leetcode.com/problems/trapping-rain-water-ii/
*/

/*
Big idea: BFS
- Add all heights on the border into the priority queue
- BFS to the inside of the height map
- Add neighbors into queue (4 directions). Remember to adjust the border accordingly
*/

class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        int res = 0;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
            
        for(int i = 0; i < n; i++) {
            pq.add(new int[]{0, i, heightMap[0][i]});
            pq.add(new int[]{m-1, i, heightMap[m-1][i]});
            visited[0][i] = visited[m-1][i] = true;
        }
        
        for(int i = 0; i < m; i++) {
            pq.add(new int[]{i, 0, heightMap[i][0]});
            pq.add(new int[]{i, n-1, heightMap[i][n-1]});
            visited[i][0] = visited[i][n-1] = true;
        }
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        while(!pq.isEmpty()) {
            int[] stack = pq.remove();
            for(int i = 0; i < 4; i++) {
                int ux = stack[0] + dx[i];
                int uy = stack[1] + dy[i];
                if(0 <= ux && ux < m && 0 <= uy && uy < n && !visited[ux][uy]) {
                    int height = heightMap[ux][uy];
                    if(stack[2] >= height) { // lower height than its border => can contain water
                        res += (stack[2] - height);
                    }
                    visited[ux][uy] = true;
                    pq.add(new int[]{ux, uy, Math.max(height, stack[2])}); // adjust the border accordingly
                }
            }
        }
        
        return res;
    }
}
