/*
https://leetcode.com/problems/verifying-an-alien-dictionary/
*/

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] map = new int[26];
        for(int i = 0; i < 26; i++) {
            map[order.charAt(i) - 'a'] = i;
        }    
        
        for(int i = 0; i < words.length - 1; i++) {
            if(!firstGreaterThanSecond(words[i], words[i+1], map)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean firstGreaterThanSecond(String w1, String w2, int[] map) {
        int n = w1.length();
        int m = w2.length();
        for(int i = 0, j = 0; i < n && j < m; i++, j++) {
            char c1 = w1.charAt(i);
            char c2 = w2.charAt(j);
            if(c1 != c2) {
                if(map[c1 - 'a'] > map[c2 - 'a']) {
                    return false;
                } else {
                    return true;
                }
            }
        }
        if(n <=  m) {
            return true;
        } else {
            return false; 
        }
    }
    
}
