/*
https://leetcode.com/problems/longest-substring-without-repeating-characters/
*/

/*
My implementation
Not optimized sliding window
Time O(2N) - worst case: every character gets visited by start and end
Space O(N)
*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n == 0) {
            return 0;
        }
        int maxLength = 0;
        int start = 0;
        int end = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(start <= end && end < n) {
            char currEnd = s.charAt(end);
            map.put(currEnd, map.getOrDefault(currEnd, 0) + 1);
            if(map.get(currEnd) == 2) {
                while(map.get(currEnd) != 1) {
                    char currStart = s.charAt(start);
                    map.put(currStart, map.get(currStart) - 1);
                    if(map.get(currStart) == 0) {
                        map.remove(currStart);
                    }
                    start++;
                }
            }
            int currLength = end - start + 1;
            maxLength = Math.max(maxLength, currLength);
            end++;
        }
        return maxLength;
    }
}

/*
Optimized sliding window
Time O(N), Space O(N)
*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int start = 0;
        int end = 0;
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(end < n) {
            if(map.containsKey(s.charAt(end))) {
                start = Math.max(start, map.get(s.charAt(end)));
            }
            int currLength = end - start + 1;
            maxLength = Math.max(maxLength, currLength);
            map.put(s.charAt(end), end + 1); 
            end++;
        }
        return maxLength;
    }
}

/*
Optimized sliding window; however, the index added to the hashmap is a little different from the previous version
*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int start = 0;
        int end = 0;
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(end < n) {
            if(map.containsKey(s.charAt(end))) {
                start = Math.max(start, map.get(s.charAt(end)) + 1); // diff
            }
            int currLength = end - start + 1;
            maxLength = Math.max(maxLength, currLength);
            map.put(s.charAt(end), end); // diff
            end++;
        }
        return maxLength;
    }
}
