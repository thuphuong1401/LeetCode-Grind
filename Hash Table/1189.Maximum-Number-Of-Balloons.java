/*
https://leetcode.com/problems/maximum-number-of-balloons/
*/

class Solution {
    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> charCount = new HashMap<>();
        for(char c : text.toCharArray()) {
            if(charCount.containsKey(c)) {
                charCount.put(c, charCount.get(c) + 1);
            } else {
                charCount.put(c, 1);
            }
        }
        char[] balloon = new char[]{'b', 'a', 'l', 'o', 'n'};
        int numBalloon = Integer.MAX_VALUE;
        for(char c : balloon) {
            if(!charCount.containsKey(c)) {
                numBalloon = 0;
                break;
            }
            if(c == 'l' || c == 'o') {
                numBalloon = Math.min(numBalloon, charCount.get(c) / 2);
            } else {
                numBalloon = Math.min(numBalloon, charCount.get(c));
            }
        }
        return numBalloon;
    }
}
