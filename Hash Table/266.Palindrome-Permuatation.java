/*
https://leetcode.com/problems/palindrome-permutation/
*/

class Solution {
    public boolean canPermutePalindrome(String s) {
        Map<Character,Integer> count = new HashMap<>();
        for(char c : s.toCharArray()) {
            if(count.containsKey(c)) {
                count.put(c, count.get(c) + 1);
            } else {
                count.put(c, 1);
            }
        }
        
        int numOddFrequencies = 0;
        for(int freq : count.values()) {
            if(freq % 2 == 1) {
                numOddFrequencies++;
            }
        }
        
        if(numOddFrequencies <= 1) {
            return true;
        } else {
            return false;
        }
        
        
    }
}
