/*
https://leetcode.com/problems/roman-to-integer/
*/

class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int ans = 0;
        int n = s.length();
        ans += map.get(s.charAt(0));
        for(int i = 1; i < n; i++) {
            char curr = s.charAt(i);
            char prev = s.charAt(i-1);
            if(prev == 'I' && (curr == 'V' || curr == 'X')) {
                ans += (map.get(curr) - 2 * map.get(prev));
            } else if(prev == 'X' && (curr == 'L' || curr == 'C')) {
                ans += (map.get(curr) - 2 * map.get(prev));
            } else if(prev == 'C' && (curr == 'D' || curr == 'M')) {
                ans += (map.get(curr) - 2 * map.get(prev));
            } else {
                ans += map.get(curr);
            }
        }
        return ans;
        
    }
}
