/*
https://leetcode.com/problems/palindromic-substrings/
*/

class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        
        // check substrings of odd length
        for(int i = 0; i < n; i++) {
            int j = i;
            for(int l = 0; l < n; l++) {
                int start = i - l;
                int end = i + l;
                if(start >= 0 && end < n && s.charAt(start) == s.charAt(end)) {
                    count++;
                } else {
                    break;
                }
            }
        }
        
        // check substrings of even length
        for(int i = 0; i < n; i++) {
            int j = i;
            for(int l = 0; l < n; l++) {
                int start = i - l;
                int end = i + l + 1;
                if(start >= 0 && end < n && s.charAt(start) == s.charAt(end)) {
                    count++;
                } else {
                    break;
                }
            }
        }
        
        return count;
        
    }
}
