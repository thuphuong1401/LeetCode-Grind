/*
https://leetcode.com/problems/valid-palindrome/
*/

class Solution {
    
    public boolean isPalindrome(String s) {
        if(s.length() == 0) {
            return true;
        }
        int i = 0;
        int j = s.length() - 1;
        while(i != j && i < s.length() && j >= 0) {
            if(!isAlphanumeric(s.charAt(i))) {
                i++;
                continue;
            }
            if(!isAlphanumeric(s.charAt(j))) {
                j--;
                continue;
            }
            if(Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j))) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
    
    
    public boolean isAlphanumeric(char c) {
        if((48 <= c && c <= 57) || (97 <= c && c <= 122) || (65 <= c && c <= 90)) {
            return true;
        }
        return false;
    }
    
}
