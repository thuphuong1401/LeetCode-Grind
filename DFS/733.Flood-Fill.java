/*
https://leetcode.com/problems/flood-fill/
*/
class Solution {
    
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length;
        int n = image[0].length;
        int currColor = image[sr][sc];
        boolean[][] visited = new boolean[m][n];
        image = dfs(visited, image, sr, sc, currColor, newColor, m, n);
        return image;
    }
    
    
    private int[][] dfs(boolean[][] visited, int[][] image, int sr, int sc, int currColor, int newColor, int m, int n) {
        image[sr][sc] = newColor;
        visited[sr][sc] = true;
        for(int i = 0; i < 4; i++) {
            int ux = sr + dx[i];
            int uy = sc + dy[i];
            if(0 <= ux && ux < m && 0 <= uy && uy < n && !visited[ux][uy] && image[ux][uy] == currColor) {
                dfs(visited, image, ux, uy, currColor, newColor, m, n);
            }
        }
        return image;
    }
}
