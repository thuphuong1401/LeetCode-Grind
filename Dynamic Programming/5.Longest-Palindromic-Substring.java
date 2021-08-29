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



/*
My implementation. I think this is clearer.
*/
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String longest = "";
        
        // check for odd length palindrome
        for(int i = 0; i < n; i++) {
            int j = i;
            for(int l = 0; l < n; l++) {
                int start = i - l;
                int end = i + l;
                if(start >= 0 && end < n && s.charAt(start) == s.charAt(end)) {
                    int currLength = end - start + 1;
                    if(longest.length() < currLength) {
                        longest = s.substring(start, end + 1);
                    }
                } else {
                    break;
                }
            }
        }
        
        // check for even length palindrome
        for(int i = 0; i < n-1; i++) {
            int j = i;
            for(int l = 0; l < n; l++) {
                int start = i - l;
                int end = i + l + 1;
                if(start >= 0 && end < n && s.charAt(start) == s.charAt(end)) {
                    int currLength = end - start + 1;
                    if(longest.length() < currLength) {
                        longest = s.substring(start, end + 1);
                    }
                } else {
                    break;
                }
            }
        }
        
        return longest;
    }
}
