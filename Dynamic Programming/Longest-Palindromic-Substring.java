/*
https://leetcode.com/problems/longest-palindromic-substring/
*/

class Solution {
    // expand around center, divide into 2 cases: odd length && even length
    public String longestPalindrome(String s) {
        int max = 0;
        String answer = "";
        int n = s.length();
        
        // odd length (including 1 character string)
        // i is the middle
        for(int i = 0; i < n; i++) {
            for(int j = 0; i - j >= 0 && i + j < n; j++) {
                if(s.charAt(i-j) != s.charAt(i + j)) {
                    break;
                }
                int currLength = 2 * j + 1;
                if(currLength > max) {
                    max = currLength;
                    answer = s.substring(i - j, i + j + 1);
                }
            }
        }
        
        // even length
        for(int i = 0; i < n-1; i++) {
            for(int j = 1; i - j + 1 >= 0 && i + j < n; j++) {
                if(s.charAt(i - j + 1) != s.charAt(i + j)) {
                    break;
                }
                int currLength = 2 * j;
                if(currLength > max) {
                    max = currLength;
                    answer = s.substring(i - j + 1, i + j + 1);
                }
                
            }
        }
        return answer;
    }
    
}
