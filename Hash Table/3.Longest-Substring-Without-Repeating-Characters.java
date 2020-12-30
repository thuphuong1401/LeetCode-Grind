/*
https://leetcode.com/problems/longest-substring-without-repeating-characters/
*/

// Brute force, O(n^2)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        for(int i = 0; i < n; i++) {
            Set<Character> set = new HashSet<>();
            for(int j = i; j < n; j++) {
                char c = s.charAt(j);
                if(!set.contains(c)) {
                    set.add(c);
                    maxLength = Math.max(maxLength, set.size());
                } else {
                    break;
                }
            }
        }
        return maxLength;
    }
}



