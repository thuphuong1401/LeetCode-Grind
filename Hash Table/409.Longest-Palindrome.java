/*
https://leetcode.com/problems/longest-palindrome/
*/

class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> count = new HashMap<>();
        for(char c : s.toCharArray()) {
            if(count.containsKey(c)) {
                count.put(c, count.get(c) + 1);
            } else {
                count.put(c, 1);
            }
        }
        
        int maxLength = 0;
        boolean containsOdd = false;
        for(Map.Entry<Character, Integer> entry : count.entrySet()) {
            int freq = entry.getValue();
            if(freq % 2 == 0) {
                maxLength += freq;
            } else {
                maxLength += (freq - 1);
                containsOdd = true;
            }
        }
        
        if(containsOdd) {
            maxLength++;
        }
        return maxLength;
    }
}
