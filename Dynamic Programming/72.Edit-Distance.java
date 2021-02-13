/*
https://leetcode.com/problems/edit-distance/
*/


/*
Big idea: represents operation replace, insert, delete as follows:
        |
replace | delete
------------------------------------------
insert  | current operation (you are here)
        |
At every choice, choose the least costly operation among replace, insert, and delete. 
- If char[i] == char[j]: no operation needed, therefore dp[i][j] = dp[i-1][j-1]
- Else, dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1], dp[i-1][j-1] + 1)

Why replace is at dp[i-1][j-1]: we're replacing 2 characters at the end of the string, therefore cost of replace = cost of transforming str1[0...i-1] to str2[0...j-1].
Why delete is at dp[i-1][j]: we're deleting 1 character from str1 (hence i-1) then transform str1[0...i-1] to str2[0...j].
Why insert is at dp[i][j-1]: we're transforming str1[0...i] to str[0...j-1] then insert a character at the end of str2.
*/

class Solution {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        
        int[][] dp = new int[n1 + 1][n2 + 1];
        for(int i = 0; i <= n1; i++) {
            dp[i][0] = i;
        }
        
        for(int i = 0; i <= n2; i++) {
            dp[0][i] = i;
        }
        
        for(int i = 1; i <= n1; i++) {
            for(int j = 1; j <= n2; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]) + 1;
                }
            }
        }
        
        return dp[n1][n2];
    }
}
