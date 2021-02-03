/*
https://leetcode.com/problems/valid-number/
*/

class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        boolean integerSeen = false;
        boolean dotSeen = false;
        boolean eSeen = false;
        int n = s.length();
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            
            if(0 <= c - '0' && c - '0' <= 9) {
                integerSeen = true;
            } else if(c == '.') {
                if(dotSeen || eSeen) {
                    return false;
                }
                dotSeen = true;
            } else if(c == '+' || c == '-') {
                if(i != 0 && (s.charAt(i-1) != 'e' && s.charAt(i-1) != 'E')) {
                    return false;
                }
            } else if(c == 'E' || c == 'e') {
                if(eSeen || !integerSeen || i == n-1) {
                    return false;
                }
                integerSeen = false;
                eSeen = true;
            } else {
                return false;
            }
        }
        return integerSeen;
        
    }
}
