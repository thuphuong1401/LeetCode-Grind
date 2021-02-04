/*
https://leetcode.com/problems/longest-common-subsequence/
*/

/*
Memoization
*/
class Solution {
    
    int[][] dp;
    
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return lcs(text1, text2, m, n);
    }
    
    public int lcs(String text1, String text2, int m, int n) {
        if(m == 0 || n == 0) {
            return 0;
        }
        
        if(dp[m-1][n-1] != -1) {
            return dp[m-1][n-1];
        }
        
        if(text1.charAt(m-1) == text2.charAt(n-1)) {
            dp[m-1][n-1] = 1 + lcs(text1, text2, m-1, n-1);
            return dp[m-1][n-1];
        } else {
            dp[m-1][n-1] = Math.max(lcs(text1, text2, m-1, n), lcs(text1, text2, m, n-1));
            return dp[m-1][n-1];
        }
    }    
}



/*
DP table
*/

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        
        for(int i = 0; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        return dp[m][n];
    }
}

