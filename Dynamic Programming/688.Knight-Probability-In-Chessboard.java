/*
https://leetcode.com/problems/knight-probability-in-chessboard/
*/

/*
dp[r][c][numMovesLeft]: number of scenario in which knight ends up IN BOUND starting from r, c and having numMovesLeft left.
numerator: 8^k because regardless of whether one path would have the same end as another path,
there's 8^k distinct paths. Our question is, of all 8^k path, what percentage is paths ending 
IN BOUND?
*/
class Solution {
    
    int[][] positions = {{2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}};
    double[][][] dp; // in bound
    
    public double knightProbability(int n, int k, int row, int column) {
        dp = new double[n][n][k+1];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int l = 0; l <= k; l++) {
                    dp[i][j][l] = -1.0;
                }
            }
        }
        double ans = dfs(n, row, column, k);
        double total = Math.pow(8, k);
        double res = ans / total;
        return res;
    }
    
    
    private double dfs(int n, int row, int col, int numMovesLeft) {
        if(!isInBound(n, row, col) && numMovesLeft >= 0) {
            return 0.0;
        } else if(numMovesLeft == 0) {
            return 1.0;
        } else {
            if(dp[row][col][numMovesLeft] != -1.0) {
                return dp[row][col][numMovesLeft];
            } else {
                double ans = 0.0;
                for(int i = 0; i < 8; i++) {
                    int ux = row + positions[i][0];
                    int uy = col + positions[i][1];
                    double res = dfs(n, ux, uy, numMovesLeft - 1);
                    ans += res;
                }
                dp[row][col][numMovesLeft] = ans;
                return ans;
            }
        }
    }
    
    private boolean isInBound(int n, int row, int col) {
        if(0 <= row && row < n && 0 <= col && col < n) {
            return true;
        } 
        return false;
    }
  
}


/*
Bottom-up DP, based on the fact that dp[r][c][k] = probability of ending up in (r, c) after k steps = sum(dp[r - dx[i]][c - dy[i]][k-1] / 8)
Use 3D dp
*/
class Solution {
    int[][] positions = {{2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}};
    
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[n][n][k+1]; // probability of ending up in (r, c) after k steps.
        
        dp[row][column][0] = 1.0;
        
        for(int m = 1; m <= k; m++) {
            for(int r = 0; r < n; r++) {
                for(int c = 0; c < n; c++) {
                    for(int l = 0; l < 8; l++) {
                        int ux = r - positions[l][0];
                        int uy = c - positions[l][1];

                        if(0 <= ux && ux < n && 0 <= uy && uy < n) {
                            dp[r][c][m] += dp[ux][uy][m-1] / 8.0;
                        }
                    }
                }
            }
        }
        
        double ans = 0.0;
        for(int r = 0; r < n; r++) {
            for(int c = 0; c < n; c++) {
                ans += dp[r][c][k];
            }
        }
        
        return ans;
        
    }
}



/*
Same idea as the 2nd approach but save space
*/

class Solution {
    int[][] positions = {{2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}};
    
    public double knightProbability(int n, int k, int row, int column) {
        double[][] dp = new double[n][n];
        
        dp[row][column] = 1.0;
        
        for(int step = 0; step < k; step++) {
            double[][] dp2 = new double[n][n];
            for(int r = 0; r < n; r++) {
                for(int c = 0; c < n; c++) {
                    for(int i = 0; i < 8; i++) {
                        // previous positions
                        int ux = r - positions[i][0];
                        int uy = c - positions[i][1];
                        
                        if(0 <= ux && ux < n && 0 <= uy && uy < n) {
                            dp2[r][c] += (dp[ux][uy] / 8.0);
                        }
                    }
                }
            }
            
            dp = dp2;
        }
        double ans = 0.0;
        for(int r = 0; r < n; r++) {
            for(int c = 0; c < n; c++) {
                ans += dp[r][c];
            }
        }
        
        return ans;
    }
    
}




