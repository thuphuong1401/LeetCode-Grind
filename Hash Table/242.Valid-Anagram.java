/*
https://leetcode.com/problems/valid-anagram/
*/

class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        int m = s.length();
        int n = t.length();
        if(n != m) {
            return false;
        }
        for(int i = 0; i < n; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            map.put(c1, map.getOrDefault(c1, 0) + 1);
            map.put(c2, map.getOrDefault(c2, 0) - 1);
        }
        
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            int count = entry.getValue();
            if(count != 0) {
                return false;
            }
        }
        
        return true;
        
    }
}
