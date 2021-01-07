/*
https://leetcode.com/problems/first-unique-character-in-a-string/
*/

// Time O(n), Space O(1) => because English alphabet has 26 letters
class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for(char c : s.toCharArray()) {
            if(!freq.containsKey(c)) {
                freq.put(c, 1);
            } else {
                freq.put(c, freq.get(c) + 1);
            }
        }
        
        for(int i = 0; i < s.length(); i++) {
            if(freq.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}


// Same idea, but use an array to count instead of hash table
class Solution {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        for(char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        
        for(int i = 0; i < s.length(); i++) {
            if(count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
