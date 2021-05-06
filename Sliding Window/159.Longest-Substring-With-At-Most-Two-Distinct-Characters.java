/*
https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
*/

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int n = s.length();
        int start = 0;
        int end = 0;
        int maxLength = 0;
        Map<Character, Integer> count = new HashMap<>();
        int currNumDistinctChars = 0;
        while(start <= end && end < n) {
            char currStart = s.charAt(start);
            char currEnd = s.charAt(end);
            count.put(currEnd, count.getOrDefault(currEnd, 0) + 1);
            if(count.get(currEnd) == 1) {
                currNumDistinctChars++;
            }
            if(currNumDistinctChars > 2) {
                count.put(currStart, count.get(currStart) - 1);
                if(count.get(currStart) == 0) {
                    currNumDistinctChars--;
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
