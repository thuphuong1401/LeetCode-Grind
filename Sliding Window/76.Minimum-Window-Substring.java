/*
https://leetcode.com/problems/minimum-window-substring/
*/

class Solution {
    
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(n < m) {
            return "";
        }
        Map<Character, Integer> count = new HashMap<>();
        for(char c : t.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        int start = 0;
        int end = 0;
        int minLength = (int)1e5 + 1;
        int startAns = 0;
        int numOfMatchedCharacters = 0;
        
        while(start <= end && end < n) {
            char currEnd = s.charAt(end);
            if(count.containsKey(currEnd)) {
                count.put(currEnd, count.get(currEnd) - 1);
                if(count.get(currEnd) >= 0) {
                    numOfMatchedCharacters++;
                }
            }
            
            while(numOfMatchedCharacters == m) {
                int currLength = end - start + 1;
                if(currLength < minLength) {
                    minLength = currLength;
                    startAns = start;
                }
                char currStart = s.charAt(start);
                if(count.containsKey(currStart)) {
                    count.put(currStart, count.get(currStart) + 1);
                    if(count.get(currStart) > 0) {
                        numOfMatchedCharacters--;
                    }
                }
                start++;
            }
            end++;
        }
        if(minLength == (int)1e5 + 1) {
            return "";
        }
        String ans = s.substring(startAns, startAns + minLength);
        return ans;
    }
}
