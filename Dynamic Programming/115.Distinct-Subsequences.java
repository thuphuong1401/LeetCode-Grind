/*
https://leetcode.com/problems/distinct-subsequences/
*/

class Solution {
    
    public int numDistinct(String s, String t) {
        
        int m = s.length();
        int n = t.length();
        s = " " + s;
        t = " " + t;
        
        // dp[i][j] = number of distinct subsequences of s[0: i] which equals to t[0: j]
        int[][] dp = new int[m+1][n+1]; 
        
        for(int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }
        
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(s.charAt(i) != t.charAt(j)) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
            }
        }
        
        return dp[m][n];
    }
}

/*
dp[i][j] = number of distinct subsequences of s[0: i] which equals to t[0: j]

(i-1, j-1)
(i-1, j)
(i, j-1)


if s[i] != t[j]:
    dp[i][j] = dp[i-1][j]
else:
    dp[i][j] = dp[i-1][j-1] + dp[i-1][j]


LCS:
if s[i] != s[j]:
    dp[i][j] = max(dp[i-1][j], dp[i][j-1])
else:
    dp[i][j] = dp[i-1][j-1] + 1
*/
