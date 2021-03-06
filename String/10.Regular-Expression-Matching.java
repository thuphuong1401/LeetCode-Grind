/*
https://leetcode.com/problems/regular-expression-matching/
*/

/*
Brute force solution. 
When encounter *, either 2 cases happens:
- Don't match current character of s => isMatch(s, p.substring(2))
- Match multiple occurences: first match && isMatch(s.substring(1), p)
*/
class Solution {
    
    public boolean isMatch(String s, String p) {
        if(p.isEmpty()) {
            return s.isEmpty();
        }    
        
        boolean firstMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') ;
        
        if(p.length() >= 2 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) || firstMatch && isMatch(s.substring(1), p) ;
        } else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }
}



/*
Another version of brute force
*/
class Solution {
    public boolean isMatch(String s, String p) {
        return match(s, 0, p, 0);
    }
    
    private boolean match(String s, int sIndex, String p, int pIndex) {
        if(pIndex == p.length()) {
            return sIndex == s.length();
        }
        
        boolean firstMatch = (sIndex < s.length()) && ((s.charAt(sIndex) == p.charAt(pIndex)) || (p.charAt(pIndex) == '.'));
        
        if(p.length() - (pIndex  + 1) >= 1 && p.charAt(pIndex + 1) == '*') {
            return (firstMatch && match(s, sIndex + 1, p, pIndex)) || match(s, sIndex, p, pIndex + 2);
        } else {
            
            return firstMatch && match(s, sIndex + 1, p, pIndex + 1);
        }
        
    }   
}



/*
Memoization
Remember the rule of memoization: call f(i, j) => cache dp[i][j]
*/
class Solution {
    
    Boolean[][] dp;
    
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        dp = new Boolean[m+1][n+1];
        return match(s, 0, p, 0);
    }
    
    private boolean match(String s, int sIndex, String p, int pIndex) { // only memoize what you are calling
        
        if(pIndex == p.length()) {
            return sIndex == s.length();
        }
        
        if(dp[sIndex][pIndex] != null) {
            return dp[sIndex][pIndex];
        }
        
        boolean firstMatch = (sIndex < s.length()) && ((s.charAt(sIndex) == p.charAt(pIndex)) || (p.charAt(pIndex) == '.'));
        
        if(p.length() - pIndex >= 2 && p.charAt(pIndex + 1) == '*') {
            
            boolean ans = (firstMatch && match(s, sIndex + 1, p, pIndex)) || match(s, sIndex, p, pIndex + 2);
            dp[sIndex][pIndex] = ans;
            return ans;
        } else {
            boolean ans = firstMatch && match(s, sIndex + 1, p, pIndex + 1);
            dp[sIndex][pIndex] = ans;
            return ans;
        }
        
    }   
}


/*
Shortest solution
*/
class Solution {
    
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        int sIndex = 0;
        int pIndex = 0;
        int match = -1; // mark (last index) + 1 compare to '*' in s
        int star = -1; // mark index of '*' in p
        
        while(sIndex < m) {
            if(pIndex < n && (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '?')) {
                sIndex++;
                pIndex++;
            } else if(pIndex < n && p.charAt(pIndex) == '*') { // not matching any chars in s
                star = pIndex;
                match = sIndex;
                pIndex++;
            } else if(star != -1) { // s[sIndex] != p[pIndex] (not same character, no '.') => backtrack!
                sIndex = match + 1;
                match = match + 1;
                pIndex = star + 1;
            } else {
                return false;
            }
        }
        boolean allStarsLeft = true;
        while(pIndex < n) {
            if(p.charAt(pIndex) != '*') {
                allStarsLeft = false;
                break;
            }
            pIndex++;
        }
        
        if(!allStarsLeft) {
            return false;
        }
        
        return true;
    }
}

