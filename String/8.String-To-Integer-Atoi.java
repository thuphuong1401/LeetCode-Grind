/*
https://leetcode.com/problems/string-to-integer-atoi/
*/

class Solution {
    
    public int myAtoi(String s) {
        if(s.length() == 0) {
            return 0;
        }
        
        if(containsAllWhitespaces(s)) {
            return 0;
        }
        
        int total = 0;
        int sign = 0;
        
        // Remove all spaces
        s = s.trim();
        
        // Get signs
        int index = 0;
        if(s.charAt(index) == '-') {
            sign = -1;
            index++;
        } else if(s.charAt(index) == '+' || (s.charAt(index) - '0' >= 0 && s.charAt(index) - '0' <= 9)) {
            sign = 1;
            if(s.charAt(index) == '+') {
                index++;
            }
        } else {
            return 0;
        }
        
        // Check overflow
        while(index < s.length()) {
            int digit = s.charAt(index) - '0';
            if(digit < 0 || digit > 9) {
                break;
            }
            
            // check overflow
            if(Integer.MAX_VALUE / 10 < total || Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit) {
                if(sign == -1) {
                    return Integer.MIN_VALUE;
                } else if(sign == 1) {
                    return Integer.MAX_VALUE;
                }
            }
            
            total *= 10;
            total += digit;
            
            index++;
        }
        
        return total * sign;
    }
    
    
    private boolean containsAllWhitespaces(String s) {
        boolean ans = true;
        for(char c : s.toCharArray()) {
            if(c != ' ') {
                ans = false;
                break;
            }
        }
        return ans;
    }
    
}
