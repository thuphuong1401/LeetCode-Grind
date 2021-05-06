/*
https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
*/
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length();
        int start = 0;
        int end = 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        
        while(start <= end && end < n) {
            char currEnd = s.charAt(end);
            map.put(currEnd, map.getOrDefault(currEnd, 0) + 1);
            while(map.size() > k) {
                map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                if(map.get(s.charAt(start)) == 0) {
                    map.remove(s.charAt(start));
                }   
                start++;
            }
            int currLength = end - start + 1;
            maxLength = Math.max(maxLength, currLength);
            end++;
        }
        return maxLength;
    }
}
