/*
https://leetcode.com/problems/ones-and-zeroes/
A classical knapsack problem with extra constraints
An important problem: learn about looping from 0 -> n and from n-1 -> 0 of knapsack
*/

/*
3D DP solution
*/
class Solution {
    
    public int findMaxForm(String[] strs, int m, int n) {
        
        int l = strs.length;
        int[][][] dp = new int[l+1][m+1][n+1];
        
        for(int i = 1; i <= l; i++) {
            for(int j = 0; j <= m; j++) {
                for(int k = 0; k <= n; k++) {
                    int currZeros = numZeros(strs[i-1]);
                    int length = strs[i-1].length();
                    int currOnes = length - currZeros;
                    
                    dp[i][j][k] = dp[i - 1][j][k];
                    if(currZeros <= j && currOnes <= k) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - currZeros][k - currOnes] + 1);
                    }
                }
            }
        }
        
        return dp[l][m][n];
    }
    
    
    private int numZeros(String s) {
        int ans = 0;
        for(char c : s.toCharArray()) {
            if(c == '0') {
                ans++;
            }
        }
        return ans;
    }
    
}



/*
2D dp solution, save space
*/
class Solution {
    
    public int findMaxForm(String[] strs, int m, int n) {
        int l = strs.length;
        int[][] dp = new int[m + 1][n + 1];
        
        for(int i = 0; i < l; i++) {
            int numZeroes = numZeros(strs[i]);
            int numOnes = strs[i].length() - numZeroes;
            for(int j = m; j >= numZeroes; j--) {
                for(int k = n; k >= numOnes; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - numZeroes][k - numOnes] + 1);
                    
                }
            }
        }    
        
        return dp[m][n];
    }
    
    
    private int numZeros(String s) {
        int ans = 0;
        for(char c : s.toCharArray()) {
            if(c == '0') {
                ans++;
            }
        }
        return ans;
    }
    
}
