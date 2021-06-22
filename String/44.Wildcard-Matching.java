/*
https://leetcode.com/problems/wildcard-matching/
*/

/*
My implementation - recursion with memoization
*/
class Solution {
    Boolean[][] dp;
    
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        dp = new Boolean[m + 1][n + 1];
        return match(s, 0, p, 0);
        
    }
    
    private boolean match(String s, int sIndex, String p, int pIndex) {
        if(dp[sIndex][pIndex] != null) {
            return dp[sIndex][pIndex];
        }
        
        if(pIndex == p.length()) {
            return sIndex == s.length();
        }
        
        if(sIndex < s.length() && ((p.charAt(pIndex) == '?') || s.charAt(sIndex) == p.charAt(pIndex))) {
            dp[sIndex][pIndex] = match(s, sIndex + 1, p, pIndex + 1);
            return dp[sIndex][pIndex];
        }
        
        if(p.charAt(pIndex) == '*') {
            boolean b1, b2;
            b1 = match(s, sIndex, p, pIndex + 1);
            if(sIndex < s.length()) {
                b2 = match(s, sIndex + 1, p, pIndex);
            } else {
                b2 = false;
            }
            
            dp[sIndex][pIndex] = b1 | b2;
            
            return dp[sIndex][pIndex];
        } else {
            dp[sIndex][pIndex] = false;
            return false;
        }
        
    }
    
}
