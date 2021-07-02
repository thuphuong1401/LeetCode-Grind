/*
https://leetcode.com/problems/palindrome-partitioning-ii/
*/

class Solution {
    Boolean[][] palindromes;
    int[] dp;
    
    public int minCut (String s) {
        palindromes = new Boolean[2001][2001];
        dp = new int[2001]; // dp[i]: min num of cuts from index i to the right
        Arrays.fill(dp, -1);
        int res = backtrack(s, 0);
        return res;
    }
    
    
    private int backtrack(String s, int index) {
        if(dp[index] != -1) {
            return dp[index];
        }
        
        if(isPalindrome(s, index, s.length() - 1)) {
            dp[index] = 0;
            return 0;
        }
        
        if(index >= s.length()) {
            return 0;
        }
        
        int minNumSep = 2001;
        
        for(int i = index; i < s.length() - 1; i++) {
            if(!isPalindrome(s, index, i)) {
                continue;
            }
            
            int currNumSep = 1 + backtrack(s, i + 1); // place another separator ^^
            minNumSep = Math.min(minNumSep, currNumSep);
        }
        
        dp[index] = minNumSep;        
        return minNumSep;
    }
    
    
    private boolean isPalindrome(String s, int i, int j) {
    
        if(palindromes[i][j] != null) {
            return palindromes[i][j];
        }
        
        if(i >= j) {
            return true;
        }
        
        boolean ans = (s.charAt(i) == s.charAt(j)) && isPalindrome(s, i + 1, j - 1);
        palindromes[i][j] = ans;
        return ans;
    }
    
}

