/*
https://leetcode.com/problems/longest-palindromic-subsequence/
*/

/*
1st method: LCS(s, reverse(s))
*/
class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        
        String s2 = new StringBuilder(s).reverse().toString();
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(s2.charAt(j-1) == s.charAt(i-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        return dp[n][n];
    }
}


