/*
https://leetcode.com/problems/unique-paths/
*/

/*
Time: O(mn), Space: O(mn)
Explanation: the logic is just like the staircase problem. Every position (i, j) can be reached by going down or right, i.e. from positions (i-1, j) or (i, j-1).
Therefore total number of ways to reach position (i, j) = total number of ways to reach (i-1, j) + total number of ways to reach (i, j-1)
*/
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0) {
                    dp[i][j] = 1;
                } else if(j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
