/*
https://leetcode.com/problems/number-of-paths-with-max-score/
*/

class Solution {
    
    int INF = (int)1e6;
    int MOD = (int)1e9 + 7;
    
    public int[] pathsWithMaxScore(List<String> boardString) {
        int n = boardString.size();
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = boardString.get(i).charAt(j);
            }
        }
        
        int[][] dp = new int[n][n]; // path length
        int[][] dp2 = new int[n][n]; // number of paths from E to S
        
        dp[0][0] = 0;
        dp2[0][0] = 1;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                
                if(i == 0 && j == 0) {
                    continue;
                }
                
                if(board[i][j] == 'X') {
                    dp[i][j] = -INF;
                    dp2[i][j] = 0;
                    continue;
                }
                
                int left = j == 0? -INF : dp[i][j-1];
                int up = i == 0? -INF: dp[i-1][j];
                int upLeft = (i == 0 || j == 0)? -INF : dp[i-1][j-1];
                
                int max = Math.max(Math.max(left, up), upLeft);
                
                if(board[i][j] == 'S') {
                    dp[i][j] = max;
                } else {
                    dp[i][j] = max + board[i][j] - '0';
                }
                    
                if(left == max && j > 0) {
                    dp2[i][j] += dp2[i][j-1] % MOD;
                    dp2[i][j] %= MOD;
                }
                if(up == max && i > 0) {
                    dp2[i][j] += dp2[i-1][j] % MOD;
                    dp2[i][j] %= MOD;
                }
                if(upLeft == max && i > 0 && j > 0) {
                    dp2[i][j] += dp2[i-1][j-1] % MOD;
                    dp2[i][j] %= MOD;
                }
            }
        }
        
        if(dp2[n-1][n-1] == 0) {
            return new int[]{0, 0};
        }
        return new int[]{dp[n-1][n-1], dp2[n-1][n-1]};
    }
}


/*


E 2 3 
2 X 2
1 2 S

// find max path length
// find all path with this length (lol)

dp[i][j]: max path length from E to (i ,j)
    
dp[i][j] = max(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + board[i][j]
answer is dp[n-1][n-1]


dp2[i][j]: so duong di tu E den (i, j)
    
dp2[i][j] = dp2[i-1][j] + dp[i][j-1] 


dp2[i][j] = dp2[i-1][j] + dp2[i][j-1] + dp2[i-1][j-1] 


dp2[n][n] = so luong cac path co length = maxLength (dp[0][0])
    
*/
