/*
https://leetcode.com/problems/is-subsequence/
*/

class Solution {
    public boolean isSubsequence(String s, String t) {
        
        int i = 0, j = 0;
        int n = s.length();
        int m = t.length();
        
        while(i < n && j < m) {
            if(t.charAt(j) == s.charAt(i)) {
                i++;
            }
            j++;
        }
        
        if(i == n) {
            return true;
        }
        return false;
    }
}
